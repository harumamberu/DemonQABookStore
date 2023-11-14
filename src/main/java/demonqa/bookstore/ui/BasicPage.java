package demonqa.bookstore.ui;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import static demonqa.bookstore.ui.models.PageURIs.*;

public abstract class BasicPage {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://demoqa.com/";

    BasicPage(WebDriver driver){
        this.driver = driver;
    }

    public BookStorePage navigateToBookStorePage(){
        navigateToURI(BOOK_STORE_URI.getUri());
        return new BookStorePage(driver);
    }

    public LoginPage navigateToLoginPage(){
        navigateToURI(LOGIN_URI.getUri());
        return new LoginPage(driver);
    }

    public ProfilePage navigateToProfilePage(){
        navigateToURI(PROFILE_URI.getUri());
        return new ProfilePage(driver);
    }

    public void navigateToURI(String uri){
        driver.navigate().to(BASE_URL + uri);
    }

    public String getBaseUrl(){
        return BASE_URL;
    }
}
