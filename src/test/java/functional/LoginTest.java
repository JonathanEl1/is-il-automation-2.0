package functional;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;


public class LoginTest extends BaseTest {
    private final LoginPage loginPage = LoginPage.getInstance();
    private final MainPage mainPage = MainPage.getInstance();
    final String word = "QWRp";

    @Test
    @Description("Login with entrepreneur in Netivei Israel")
    @Parameters({"userNameOfEntrepreneurInNetiveiIsrael",
            "passwordOfEntrepreneurInNetiveiIsrael",
            "codeOfEntrepreneurInNetiveiIsrael"})
    public void loginValid(String userNameOfEntrepreneurInNetiveiIsrael, String passwordOfEntrepreneurInNetiveiIsrael,
                           String codeOfEntrepreneurInNetiveiIsrael) throws InterruptedException {
    loginPage.login(userNameOfEntrepreneurInNetiveiIsrael,
                passwordOfEntrepreneurInNetiveiIsrael,
                codeOfEntrepreneurInNetiveiIsrael);
    mainPage.clickOnProjects();
    mainPage.existingProjectLink();
    }

    @Test(priority = 1)
    @Description("Testing error message popup with input a wrong username")
    @Parameters({"userNameOfEntrepreneurInNetiveiIsrael","passwordOfEntrepreneurInNetiveiIsrael",
            "codeOfEntrepreneurInNetiveiIsrael"})
    public void wrongUserna(String userNameOfEntrepreneurInNetiveiIsrael, String passwordOfEntrepreneurInNetiveiIsrael,
                            String codeOfEntrepreneurInNetiveiIsrael) throws InterruptedException {
        loginPage.inputUsername(userNameOfEntrepreneurInNetiveiIsrael);
        loginPage.inputPassword(passwordOfEntrepreneurInNetiveiIsrael);
        loginPage.inputCode(codeOfEntrepreneurInNetiveiIsrael);
        loginPage.clickOnLoginButton();
    }
    @Test(priority = 2)
    @Description("Testing enter a value error message")
    public void errorMessage() {
        loginPage.clickOnLoginButton();
        loginPage.usernameErrorMessageExist(true);
        loginPage.passwordErrorMessageExist(true);

        loginPage.inputUsername(word);
        loginPage.clickOnCodeTextBox();
        loginPage.usernameErrorMessageExist(false);
        loginPage.passwordErrorMessageExist(true);

        loginPage.clearUsername();
        loginPage.inputPassword(word);
        loginPage.clickOnCodeTextBox();
        loginPage.usernameErrorMessageExist(true);
        loginPage.passwordErrorMessageExist(false);
    }

    @Test(priority = 3)
    @Description("Testing error message popup with input a wrong username")
    @Parameters({"passwordOfEntrepreneurInNetiveiIsrael",
            "codeOfEntrepreneurInNetiveiIsrael"})
    public void wrongUsername(String passwordOfEntrepreneurInNetiveiIsrael,
                              String codeOfEntrepreneurInNetiveiIsrael) throws InterruptedException {
        loginPage.inputUsername(word);
        loginPage.inputPassword(passwordOfEntrepreneurInNetiveiIsrael);
        loginPage.inputCode(codeOfEntrepreneurInNetiveiIsrael);
        loginPage.clickOnLoginButton();
        loginPage.errorMessagePopupExist(true);
        loginPage.clickOnOkButton();
        loginPage.clearUsername();
        loginPage.clearPassword();
        loginPage.clearCode();
    }

    @Test(priority = 4)
    @Description("Testing error message popup with input a wrong password")
    @Parameters({"userNameOfEntrepreneurInNetiveiIsrael",
            "codeOfEntrepreneurInNetiveiIsrael"})
    public void wrongPassword(String userNameOfEntrepreneurInNetiveiIsrael,
                              String codeOfEntrepreneurInNetiveiIsrael) throws InterruptedException {
        loginPage.inputUsername(userNameOfEntrepreneurInNetiveiIsrael);
        loginPage.inputPassword(word);
        loginPage.inputCode(codeOfEntrepreneurInNetiveiIsrael);
        loginPage.clickOnLoginButton();
        loginPage.errorMessagePopupExist(true);
        loginPage.clickOnOkButton();
        loginPage.clearUsername();
        loginPage.clearPassword();
        loginPage.clearCode();
    }

    @Test(priority = 5)
    @Description("Testing error message popup with input a wrong code")
    @Parameters({"userNameOfEntrepreneurInNetiveiIsrael",
            "passwordOfEntrepreneurInNetiveiIsrael"})
    public void wrongCode(String userNameOfEntrepreneurInNetiveiIsrael,
                          String passwordOfEntrepreneurInNetiveiIsrael) throws InterruptedException {
        loginPage.inputUsername(userNameOfEntrepreneurInNetiveiIsrael);
        loginPage.inputPassword(passwordOfEntrepreneurInNetiveiIsrael);
        loginPage.inputCode(word);
        loginPage.clickOnLoginButton();
        loginPage.errorMessagePopupExist(true);
        loginPage.clickOnOkButton();
        loginPage.clearUsername();
        loginPage.clearPassword();
        loginPage.clearCode();
    }
}
