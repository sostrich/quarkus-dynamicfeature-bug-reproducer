package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class GreetingResource {

    @RestClient
    ExampleRestClient restClient;

    @GET()
    @Path("google-call")
    @Produces(MediaType.TEXT_PLAIN)
    public Response callGoogle() {
        try (var restClientResponse = restClient.googleCall()) {
            //do nothing with it
        }
        return Response
                .status(200).build();
    }
    @RegisterRestClient(baseUri = "https://www.google.com")
    public interface ExampleRestClient {
        @GET
        Response googleCall();
    }
}
