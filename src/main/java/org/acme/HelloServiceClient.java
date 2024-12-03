package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "hello-service")
public interface HelloServiceClient {
    @GET
    @Path("/greet")
    String greet();

    @POST
    @Path("/hello")
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_XML)
    String hello(@HeaderParam("Content-Type") String contentType,
                 @HeaderParam("Cache-Control") String cacheControl,
                 @HeaderParam("User-Agent") String userAgent,
                 String soapBody);

}


