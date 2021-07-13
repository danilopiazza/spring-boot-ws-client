package io.github.danilopiazza.spring.boot.ws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        CelsiusToFahrenheitConverter celsiusToFahrenheit = context.getBean(CelsiusToFahrenheitConverter.class);
        double celsius = 25;
        LOGGER.info("{} °C → {} °F", celsius, celsiusToFahrenheit.convert(celsius));
    }
}
