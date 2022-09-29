package ca.quebec.bootcamp.cloudparking.controller;

import ca.quebec.bootcamp.cloudparking.controller.parking.dto.ParkingDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTests extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .auth().basic("user", "12345")
                .when()
                .get("/parked")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void whenCreateThenCheckIsCreated() {
        var createDTO = new ParkingDTO();
        createDTO.setId(1L);
        createDTO.setColor("AMARELO");
        createDTO.setLicense("WRT-5555");
        createDTO.setModel("BRASILIA");
        createDTO.setState("SP");

        RestAssured.given()
                .when()
                .auth().basic("user", "12345")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parked")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("WRT-5555"))
                .body("color", Matchers.equalTo("AMARELO"));
    }
}
