package ar.edu.unq.eperdemic

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@EnableAutoConfiguration
@TestConfiguration
@ComponentScan(basePackages = ["ar.edu.unq.eperdemic.services","ar.edu.unq.eperdemic.controllers"])
class ControllerTestConfig {


}

