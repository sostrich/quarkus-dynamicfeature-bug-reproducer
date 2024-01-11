package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    //fails because application shuts down
    void testGoogleCall() {
        given()
                .when()
                .accept(MediaType.TEXT_PLAIN)
                .get("/hello/google-call")

                .then()
                .statusCode(402);
    }
}