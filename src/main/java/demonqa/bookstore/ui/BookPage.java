package demonqa.bookstore.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends BasicPage{
    BookPage(WebDriver driver){super(driver);}

    public BookPage addBookToProfile(){
        return new BookPage(driver);
    }
}