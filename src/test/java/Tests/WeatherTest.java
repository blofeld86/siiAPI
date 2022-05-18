package Tests;

import data.DataStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class WeatherTest extends BaseTest {

    @Test
    void countryTest() {
        DataStore.COUNTRY =
                            when().
                                   get().
                            then().
                                   extract().
                                   path("sys.country");
        Assertions.assertEquals("GB",DataStore.COUNTRY);
    }

    @Test
    void pressureTest(){
          when().
                  get().
          then().
                  body("main.pressure",is(1012)).
                  body("sys.sunset",is(1485794875)).
                  body("wind.speed",is(4.1F)).
                  body("weather[0].main",is("Drizzle")).
                  body("clouds.all",is(90));
    }
}
