package demonqa.bookstore.ui;

import org.openqa.selenium.WebDriver;

public class BookStorePage extends BasicPage{
    public BookStorePage(WebDriver driver){
        super(driver);

    }

    public BookPage openFirstBook() {

        return new BookPage(driver);
    }
}