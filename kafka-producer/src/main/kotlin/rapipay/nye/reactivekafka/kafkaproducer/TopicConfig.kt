package rapipay.nye.reactivekafka.kafkaproducer

import org.springframework.context.annotation.Configuration
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.kafka.config.TopicBuilder
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.SenderOptions

@Configuration
class TopicConfig {

    @Bean
    fun generateTopic(): NewTopic{

        return TopicBuilder.name("reactive-topic").build()
    }
}