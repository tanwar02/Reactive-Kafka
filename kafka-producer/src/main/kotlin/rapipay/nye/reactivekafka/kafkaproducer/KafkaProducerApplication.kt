package rapipay.nye.reactivekafka.kafkaproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
class KafkaProducerApplication

fun main(args: Array<String>) {
    runApplication<KafkaProducerApplication>(*args)
}