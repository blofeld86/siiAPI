package Tests;

import data.DataStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LublinWeatherTest extends BaseTest{

    //ENV_TEST

    @Test
    void countryNameTest() {

        DataStore.CLOUDS =
                            when().
                                    get().
                            then().
                                   extract().
                                   path(System.getProperty("cloudsPath"));
        assertEquals(7,DataStore.CLOUDS);
    }

    @Test
    void answerTest(){

        when().
                get().
        then().
                body(System.getProperty("namePath"),is("Lublin Voivodeship")).
                body(System.getProperty("timezonePath"),is(7200)).
                body(System.getProperty("tempMaxPath"),is(289.92F)).
                body(System.getProperty("gustPath"),is(5.7F)).
                body(System.getProperty("countryPath"),is("PL"));
    }


}
