package util.locators;

import org.openqa.selenium.By;

public class CommonObjectsLocators {
    private CommonObjectsLocators() {}

    public static final By FILTERS_OR_LIBRARY_LOCATOR = By.cssSelector(
            "span[data-item-marker='filterButton']");
    public static final By ADD_FILTER_LOCATOR = By.cssSelector(
            "li[data-item-marker='הוספת מסנן']");
    public static final By ALL_FILTERS_BUTTON_LOCATOR = By.cssSelector(
            "input[placeholder='עמודה']");
    public static final By ALL_FILTERS_LIST_LOCATOR = By.cssSelector("li[dir]");
    public static final By VALUE_TEXT_BOX_LOCATOR = By.cssSelector(
            "div[data-item-marker='searchEdit']");
    public static final By V_BUTTON_LOCATOR = By.cssSelector(
            "span[data-item-marker='applyButton']");
    public static final By AMOUNT_LOCATOR = By.cssSelector(
            "label[data-item-marker='כמות: ']");
    public static final By REMOVE_FILTER_LOCATOR = By.cssSelector(
            "span[data-tag='customFilterUsrName_UsrProjects']");
    public static final By CLOSE_BUTTON_LOCATOR = By.cssSelector(
            "[data-item-marker='CloseButton']");
    public static final By SCROLL_TOP_BUTTON = By.cssSelector(
            "[data-item-marker='ScrollTopBtn']");
}
