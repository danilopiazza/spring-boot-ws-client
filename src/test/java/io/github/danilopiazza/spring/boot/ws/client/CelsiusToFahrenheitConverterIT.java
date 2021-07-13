package io.github.danilopiazza.spring.boot.ws.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CelsiusToFahrenheitConverterIT {
    @Autowired
    CelsiusToFahrenheitConverter converter;

    @Test
    void testConvert() {
        assertEquals(68, converter.convert(20));
    }
}
