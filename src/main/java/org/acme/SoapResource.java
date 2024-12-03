package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.inject.Inject;

@Path("/soap")
public class SoapResource {

    @Inject
    SoapClient soapClient;

    @GET
    @Path("/send")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendSoapRequest() {
        return soapClient.sendRequest();
    }
}