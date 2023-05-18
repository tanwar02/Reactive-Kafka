package rapipay.nye.reactivekafka.kafkaproducer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Consumer {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["reactive-topic"], groupId = "group1")
    fun consumeMessage(message: String){

        logger.info("message received : $message")
    }
}