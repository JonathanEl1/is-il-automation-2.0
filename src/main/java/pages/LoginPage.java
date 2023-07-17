package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.jboss.aerogear.security.otp.Totp;
import pages.Projects.ProjectsPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static util.locators.LoginPageLocators.*;

public class LoginPage {

    private static LoginPage loginPage;

    // Elements

    private final SelenideElement usernameTextBox = $(USERNAME_LOCATOR);
    private final SelenideElement passwordTextBox = $(PASSWORD_LOCATOR);
    private  SelenideElement codeTextBox = $(CODE_LOCATOR);
    private final SelenideElement loginButton = $(LOG_IN_BUTTON_LOCATOR);
    private final SelenideElement forgotPasswordButton =
            $(FORGOT_PASSWORD_BUTTON_LOCATOR);
    private final SelenideElement usernameErrorMessage =
            $(USERNAME_ERROR_MESSAGE_LOCATOR);
    private final SelenideElement passwordErrorMessage =
            $(PASSWORD_ERROR_MESSAGE_LOCATOR);
    private final SelenideElement okButton = $(OK_BUTTON_IN_POPUP_LOCATOR);
    private final SelenideElement errorMessagePopup = $(ERROR_MESSAGE_POPUP_LOCATOR);

    // Constructor

    public static LoginPage getInstance() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        return loginPage;
    }

   // Class methods

    private String decodedText(String text) {
        return new String(Base64.decodeBase64(text));
    }

    // Global methods

    public void clickOnLoginButton() {
        loginButton.shouldBe(visible).click();
    }

    public void usernameErrorMessageExist(boolean shouldExist) {
        if (shouldExist) {
            usernameErrorMessage.shouldHave(text("Enter a value"));
        } else {
            usernameErrorMessage.shouldBe(empty);
        }
    }

    public void passwordErrorMessageExist(boolean shouldExist) {
        if (shouldExist) {
            passwordErrorMessage.shouldHave(text("Enter a value"));
        } else {
            passwordErrorMessage.shouldBe(empty);
        }
    }
    @Step("insert user name")
    public void inputUsername(String username) {
        usernameTextBox.setValue(decodedText(username));
    }
    @Step("insert password")
    public void inputPassword(String password) {
        passwordTextBox.setValue(decodedText(password));
    }
    @Step("insert code")
    public void inputCode(String code) throws InterruptedException {
        Thread.sleep(5000);
        Totp totp = new Totp(decodedText(code));
        String totpcode = totp.now();
        System.out.println(totpcode);
        System.out.println(totpcode);
        codeTextBox.setValue(totpcode);
    }

    public void clickOnCodeTextBox() {
        codeTextBox.click();
    }

    public void clearUsername() {
        usernameTextBox.clear();
    }

    public void clearPassword() {
        passwordTextBox.clear();
    }

    public void clearCode() {
        codeTextBox.clear();
    }

    public void errorMessagePopupExist(boolean shouldExist) {
        if (shouldExist) {
            errorMessagePopup.shouldNotHave(cssValue("display", "none"));
        } else {
            errorMessagePopup.shouldHave(cssValue("display", "none"));
        }
    }

    public void clickOnOkButton() {
        okButton.shouldBe(exist).hover().click();
    }

    public void login(String userName, String password, String code)
            throws InterruptedException {
        inputUsername(userName);
        inputPassword(password);
        inputCode(code);
        clickOnLoginButton();
        Thread.sleep(10000);
    }
}
