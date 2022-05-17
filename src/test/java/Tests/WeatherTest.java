package Tests;

import Tests.BaseTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;

public class WeatherTest extends BaseTest {

    @Test
    void weatherOne() { when().get();}
}
