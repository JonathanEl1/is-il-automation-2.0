package util.locators;

import org.openqa.selenium.By;

public final class LoginPageLocators {
    private LoginPageLocators() {}

    public static final By USERNAME_LOCATOR = By.id("loginEdit-el");
    public static final By PASSWORD_LOCATOR = By.id("passwordEdit-el");
    public static final By CODE_LOCATOR = By.id("totpCodeEdit-el");
    public static final By LOG_IN_BUTTON_LOCATOR = By.id("t-comp16-textEl");
    public static final By FORGOT_PASSWORD_BUTTON_LOCATOR = By.id("t-comp16");
    public static final By USERNAME_ERROR_MESSAGE_LOCATOR = By.id("loginEdit-validation");
    public static final By PASSWORD_ERROR_MESSAGE_LOCATOR = By.id("passwordEdit-" +
            "validation");
    public static final By OK_BUTTON_IN_POPUP_LOCATOR = By.cssSelector("span[data-item" +
            "-marker='OK']");
    public static final By ERROR_MESSAGE_POPUP_LOCATOR = By.id("t-comp0-wrap");
}