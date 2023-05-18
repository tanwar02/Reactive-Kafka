package rapipay.nye.reactivekafka.kafkaproducer

import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/nye/v1")
class ReceiverController {

    val producer: Producer

    constructor(producer: Producer){

        this.producer = producer
    }

    @PostMapping("/publish")
    fun postMessage(@RequestBody message: String): Mono<ResponseEntity<String>> {

        return producer.send(message)
    }
}