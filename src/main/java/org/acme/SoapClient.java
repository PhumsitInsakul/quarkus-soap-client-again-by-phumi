package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import jakarta.inject.Inject;

@ApplicationScoped
public class SoapClient {

    @Inject
    @RestClient
    HelloServiceClient helloServiceClient;

    public String sendRequest() {
        String soapBody = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<soap:Body>"
                + "<ns2:hello xmlns:ns2=\"http://server.it.cxf.quarkiverse.io/\">"
                + "<arg0>Papi (Using SoapClient!)</arg0>"
                + "<arg1>2024-11-29T00:00:00Z</arg1>"
                + "<arg2>Phumikul</arg2>"
                + "<arg2>Carlos Sainz</arg2>"
                + "<arg2>Shunpei</arg2>"
                + "<arg3>"
                + "<field1>Earth</field1>"
                + "<field2>Milky Way</field2>"
                + "</arg3>"
                + "<arg4>"
                + "<field1>The Sun</field1>"
                + "<field2>The Moon</field2>"
                + "</arg4>"
                + "</ns2:hello>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        String response = helloServiceClient.hello("text/xml;charset=UTF-8",
                "no-cache",
                "Quarkus REST Client",
                soapBody);
        return response;
    }
}
