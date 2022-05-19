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
                body(System.getProperty("namePath"),is(System.getProperty("nameAnswer"))).
                body(System.getProperty("timezonePath"),is(Integer.parseInt(System.getProperty("timezoneAnswer")))).
                body(System.getProperty("tempMaxPath"),is(Float.parseFloat(System.getProperty("tempMaxAnswer")))).
                body(System.getProperty("gustPath"),is(Float.parseFloat(System.getProperty("gutsAnswer")))).
                body(System.getProperty("cloudsPath"),is(Integer.parseInt(System.getProperty("cloudsAnswer"))));
    }


}
