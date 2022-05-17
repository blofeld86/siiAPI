package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class firstAPIsteps {

    @Given("I declare the content type")
    public void iDeclareTheContentType() {
        given()
                .contentType(ContentType.JSON);
    }

    @When("I connect with the correct data base")
    public void i_connect_with_the_correct_data_base() {
        when()
               .get("https://samples.openweathermap.org/data/2.5/weather").
        then()
                .log()
                .all()
                .statusCode(200);

    }

    @Then("I get the content")
    public void i_get_the_content() {}


}
