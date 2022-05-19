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
        assertEquals(System.getProperty("countryAnswer"),DataStore.COUNTRY);
    }

    @Test
    void answerTest(){
          when().
                  get().
          then().
                  body(System.getProperty("pressurePath"),is(Integer.parseInt(System.getProperty(("pressureAnswer"))))).
                  body(System.getProperty("sunsetPath"),is(Integer.parseInt(System.getProperty("sunsetAnswer")))).
                  body(System.getProperty("windSpeedPath"),is(Float.parseFloat(System.getProperty("windAnswer")))).
                  body(System.getProperty("weatherPath"),is(System.getProperty("weatherAnswer"))).
                  body(System.getProperty("cloudsPath"),is(Integer.parseInt(System.getProperty("cloudAnswer"))));
    }
}
