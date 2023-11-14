package demonqa.bookstore.regression.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserCanAddBookToHisOwnStoreTest extends BasicUITest{

    @Before
    public void createAndLoginUser(){
        createNewUserUUID("testmykhaylo33", "!A12!a12");
        bookStorePage.navigateToLoginPage()
                .login();
    }

    @Test
    public void userCanAddBookToHisOwnStore(){
        bookStorePage
                .navigateToBookStorePage()
                .openFirstBook()
                .addBookToProfile()
                .navigateToProfilePage()
                .checkThereIsAnyBookInProfile();
    }

    @After
    public void deleteTestUser(){
        deleteUserByUUID();
    }
}
