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
                                   path("clouds.all");
        assertEquals(6,DataStore.CLOUDS);
    }

    @Test
    void answerTest(){

        when().
                get().
        then().
                body("name",is("Lublin Voivodeship")).
                body("timezone",is(7200)).
                body("main.temp_max",is(289.92F)).
                body("wind.gust",is(6.23F)).
                body("sys.country",is("PL"));
    }


}
