package Tests;

import data.DataStore;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LondonWeatherTest extends BaseTest {

    // ENV_INT

    @Test
    void countryTest() {
        DataStore.COUNTRY =
                            when().
                                   get().
                            then().
                                   extract().
                                   path(System.getProperty("countryPath"));
        assertEquals("GB",DataStore.COUNTRY);
    }

    @Test
    void answerTest(){
          when().
                  get().
          then().
                  body(System.getProperty("pressurePath"),is(1012)).
                  body(System.getProperty("sunsetPath"),is(1485794875)).
                  body(System.getProperty("windSpeedPath"),is(4.1F)).
                  body(System.getProperty("weatherPath"),is("Drizzle")).
                  body(System.getProperty("cloudsPath"),is(90));
    }
}
