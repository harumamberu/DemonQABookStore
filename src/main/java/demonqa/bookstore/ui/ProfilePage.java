package demonqa.bookstore.ui;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasicPage{
    ProfilePage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//*[contains(@id,\"see-book\")]")
    WebElement seeBookID;

    public void checkThereIsAnyBookInProfile(){
        Assert.assertTrue(seeBookID.isDisplayed());
    }
}