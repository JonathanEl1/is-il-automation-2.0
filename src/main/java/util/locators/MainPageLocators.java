package util.locators;

import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

public class MainPageLocators {
    private MainPageLocators() {}

    public static final By PROJECTS_LOCATOR = Selectors.byCssSelector(
            "[data-item-marker='פרויקטים']");
    public static final By REQUESTS_LOCATOR = Selectors.byText("בקשות");
    public static final By APPLICATIONS_LOCATOR = Selectors.byText("פניות");
    public static final By OPENING_NEW_USERNAME_LOCATOR = Selectors.byText(
            "בקשות לפתיחת חשבון משתמש");
    public static final By OPENING_NEW_COMPANY_LOCATOR = Selectors.byText(
            "בקשות להקמת חברה");
    public static final By INTERNAL_TREATMENT_LOCATOR = Selectors.byText(
            "טיפול פנימי בפניות");
    public static final By INTERNAL_REFERENCE_LOCATOR = Selectors.byText(
            "התייחסויות פנימיות");
}
