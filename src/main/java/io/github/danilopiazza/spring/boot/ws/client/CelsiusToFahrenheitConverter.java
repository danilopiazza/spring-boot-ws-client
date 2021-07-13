package io.github.danilopiazza.spring.boot.ws.client;

import javax.xml.bind.JAXBElement;

import com.learnwebservices.services.tempconverter.CelsiusToFahrenheitRequest;
import com.learnwebservices.services.tempconverter.CelsiusToFahrenheitResponse;
import com.learnwebservices.services.tempconverter.ObjectFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class CelsiusToFahrenheitConverter {
    private final WebServiceTemplate webServiceTemplate;

    public CelsiusToFahrenheitConverter(@Autowired WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public double convert(double celsius) {
        var request = new CelsiusToFahrenheitRequest();
        request.setTemperatureInCelsius(celsius);
        var objectFactory = new ObjectFactory();
        var requestElement = objectFactory.createCelsiusToFahrenheitRequest(request);
        @SuppressWarnings("unchecked")
        var responseElement = (JAXBElement<CelsiusToFahrenheitResponse>) webServiceTemplate.marshalSendAndReceive(requestElement);
        var response = responseElement.getValue();
        return response.getTemperatureInFahrenheit();
    }
}
