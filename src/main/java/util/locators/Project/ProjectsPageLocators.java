package util.locators.Project;

import org.openqa.selenium.By;

public class ProjectsPageLocators {
    private ProjectsPageLocators() {}

    public static final By NEW_PROJECT_BUTTON_LOCATOR = By.cssSelector(
            "[data-item-marker='SeparateModeAddRecordButton']");
    public static final By PROJECTS_LIST_LOCATOR = By.cssSelector(
            "[class*='grid-listed-row grid-active-selectable']");
    public static final By ENTERPRISING_COMPANY_COLUMN_LOCATOR = By.cssSelector(
            "[data-item-marker='חברה יוזמת']");
    public static final By OPENING_DATE_COLUMN_LOCATOR = By.cssSelector(
            "[data-item-marker='תאריך פתיחה']");
}
