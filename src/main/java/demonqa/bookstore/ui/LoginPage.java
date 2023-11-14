package demonqa.bookstore.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage{
    LoginPage(WebDriver driver){super(driver);}

    @FindBy(id = "userName")
    WebElement usernameField;

    @FindBy(id = "")
    WebElement passField;

    public ProfilePage login() {
        usernameField.sendKeys("testmykhaylo11");
        passField.sendKeys("!A12!a12");
        return new ProfilePage(driver);
    }
}
