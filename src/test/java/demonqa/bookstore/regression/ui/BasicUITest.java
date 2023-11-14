package demonqa.bookstore.regression.ui;

import demonqa.bookstore.ui.BookStorePage;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.time.Duration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BasicUITest {
    WebDriver driver;
    BookStorePage bookStorePage;
    FirefoxOptions firefoxOptions;

    Response response;
    String userID;
    String tokenResponse;


    @Before
    public void preconditions(){
        initiateWebDriverInstance(new FirefoxOptions().configureFromEnv());
        bookStorePage = new BookStorePage(driver);
        driver.navigate().to("https://demoqa.com/books");
        RestAssured.baseURI = bookStorePage.getBaseUrl();
    }

    public void initiateWebDriverInstance(AbstractDriverOptions driverOptions){
        if (driverOptions.getBrowserName().equals("Firefox")){
            this.driver = new FirefoxDriver((FirefoxOptions) driverOptions);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void createNewUserUUID(String name, String pass){
        response =
            given().
                    param("userName", name).
                    param("password", pass).
            when().
                    post("Account/v1/User").
            then().
                    statusCode(200).
                    body("username", equalTo(name)).
            extract().response();

        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        userID = jsonPath.getString("userId");
    }

    public void deleteUserByUUID(){
        given().
                param("userID", userID).
        when().
                delete("Account/v1/User/" + userID).
        then().
                statusCode(200);
    }
}
