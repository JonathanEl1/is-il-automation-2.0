package util.locators.Project;

import org.openqa.selenium.By;

public class ProjectPageLocators {
    private ProjectPageLocators() {}

    public static final By PROJECT_TITLE_LOCATOR = By.xpath(
            "//div[@id='PageHeaderContainer']/*[1]");
    public static final By SAVE_BUTTON_LOCATOR = By.cssSelector(
            "[data-item-marker='SaveButton']");
    public static final By CLOSE_BUTTON_LOCATOR = By.cssSelector(
            "[data-item-marker='CloseButton']");

    public static final By PROJECT_NAME_LOCATOR = By.id(
            "UsrProjects1PageUsrName7bff1995-75e9-43e6-9adf-0823b93f33e0TextEdit-el");
    public static final By PROJECT_NUMBER_LOCATOR = By.xpath("//div[@data-item-marker=" +
            "'STRING240fd41a-dff0-4e7e-b434-42886be6b1cd מספר פרויקט']/*[1]");
    public static final By ENTERPRISING_COMPANY_LOCATOR = By.id("UsrProjects1Page" +
            "LOOKUPe4f86829-16fd-40c0-a608-05cdf5c6294cLookupEdit-link-el");
    public static final By PROJECT_LEADER_LOCATOR = By.id("UsrProjects1PageLOOKUP" +
            "316c16bf-a81f-4eb5-9fbc-22064cef93caLookupEdit-link-el");
    public static final By PROJECT_MANAGER_LOCATOR = By.id(
            "UsrProjects1PageLOOKUP422b5bf9-84e4-483c-a7d6-e42f5aef606aLookupEdit-el");

    public static final By FIRST_LEVEL_LOCATOR = By.cssSelector(
            "[data-item-marker='שלב ראשוני/סטטורי']");
    public static final By PLANNING_LEVEL_LOCATOR = By.cssSelector(
            "[data-item-marker='שלב תכנון מפורט']");
    public static final By IMPLEMENTATION_LEVEL_LOCATOR = By.cssSelector(
            "[data-item-marker='שלב ביצוע']");
    public static final By CANCELLED_LEVEL_LOCATOR = By.cssSelector(
            "[data-item-marker='מבוטל']");

    public static final By PROJECT_DETAILS_LOCATOR = By.xpath(
            "//ul[@id='UsrProjects1PageTabsTabPanel-tabpanel-items']/*[1]");
    public static final By CONTACTS_LOCATOR = By.xpath(
            "//ul[@id='UsrProjects1PageTabsTabPanel-tabpanel-items']/*[2]");
    public static final By SUB_PROJECTS_LOCATOR = By.xpath(
            "//ul[@id='UsrProjects1PageTabsTabPanel-tabpanel-items']/*[3]");
    public static final By TIMELINE_LOCATOR = By.xpath(
            "//ul[@id='UsrProjects1PageTabsTabPanel-tabpanel-items']/*[4]");
    public static final By STEP_LOG_AT_PROJECTS_LOCATOR = By.xpath(
            "//ul[@id='UsrProjects1PageTabsTabPanel-tabpanel-items']/*[5]");
    public static final By MESSAGES_BOARD_LOCATOR = By.xpath(
            "//ul[@id='UsrProjects1PageTabsTabPanel-tabpanel-items']/*[6]");
    public  static final By CONTACT_NAME =
            By.xpath("//*[@id=\"UsrSchema1f17d41eDetailDataGridGrid-69044c51-54f5-4193-a3fa-daff9b3fc712-item-ef7db870-fa44-4b92-bf66-4641c6e7798c\"]/div[1]");
}
