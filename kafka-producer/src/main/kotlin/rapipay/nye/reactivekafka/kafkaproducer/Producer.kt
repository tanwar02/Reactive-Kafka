package rapipay.nye.reactivekafka.kafkaproducer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import reactor.core.publisher.Mono
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.SenderRecord
import reactor.kafka.sender.SenderResult


@Service
class Producer {

    var sender: KafkaProducer<String, String>
    var topic: String = "reactive-topic"
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    constructor(sender: KafkaProducer<String, String>){

        this.sender = sender
    }

    fun send(message: String): Mono<ResponseEntity<String>>{

        logger.info("sending message $message to topic $topic")
        val record: ProducerRecord<String, String> = ProducerRecord(topic, message)

        return Mono.just(record).flatMap {
            Mono.just(sender.send(it))
        }.doOnNext {
            logger.info("successfully sent record $it")
        }.flatMap {
            Mono.just(ResponseEntity.ok().body("message sent"))
        }
    }
}