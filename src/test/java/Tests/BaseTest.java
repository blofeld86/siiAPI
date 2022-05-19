package Tests;

import configuration.YamlReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;

public class BaseTest {


    @BeforeAll
    static void beforeAll() {
        YamlReader.setPropertiesFromYamlEnvironment();
    }

    @BeforeEach
    void setUp() {

        RestAssured.baseURI = System.getProperty("appUrl");
        RestAssured.basePath = System.getProperty("basePath");
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification =
                given().
                        param(System.getProperty("paramQ"),System.getProperty("city")).
                        param(System.getProperty("appId"), System.getProperty("token"));

        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
    }
}
