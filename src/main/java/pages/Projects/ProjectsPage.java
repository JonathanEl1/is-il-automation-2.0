package pages.Projects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.*;
import static util.locators.Project.ProjectsPageLocators.*;
import static util.locators.CommonObjectsLocators.*;
import static com.codeborne.selenide.Condition.*;

public class ProjectsPage {

    private static ProjectsPage projectsPage;

    private static ProjectPage projectPage = ProjectPage.getInstance();

    // Elements

    private final SelenideElement newProjectButton  = $(NEW_PROJECT_BUTTON_LOCATOR);
    private final ElementsCollection projectsList = $$(PROJECTS_LIST_LOCATOR);
    private final SelenideElement amount = $(AMOUNT_LOCATOR);
    private final SelenideElement scrollTopButton = $(SCROLL_TOP_BUTTON);
    private final SelenideElement enterprisingCompanyColumn =
            $(ENTERPRISING_COMPANY_COLUMN_LOCATOR);
    private final SelenideElement openingDateColumn = $(OPENING_DATE_COLUMN_LOCATOR);


    // Constructor

    public static ProjectsPage getInstance() {
        if (projectsPage == null) {
            projectsPage = new ProjectsPage();
        }

        return projectsPage;
    }

    // Class methods

    // Global methods

    public void checkAmountOfProjects() {
        projectsList.get(0).shouldBe(exist);
        JavascriptExecutor js = (JavascriptExecutor)WebDriverRunner.getWebDriver();

        while (!String.valueOf(projectsList.size()).equals(amount.text())) {
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }
    }

    public void checkEnterprisingCompanyInProjects(String enterprisingCompany) {
        for (int i = 0; i < 2; i++) {
            enterprisingCompanyColumn.shouldBe(exist).click();
            projectsList.get(0).$(By.className("grid-cols-4")).shouldHave(text(
                    enterprisingCompany));
        }
    }

    public void clickOnNewProjectButton() {
        newProjectButton.shouldBe(exist).click();
        projectPage.getProjectTitle().shouldHave(text("רשומה חדשה"));
        projectPage.checkIfFirstLevelIsChecked();
    }

    public void clickOnScrollTopButton() {
        scrollTopButton.shouldBe(exist).click();
    }

    public SelenideElement getOpeningDateColumn() {
        return this.openingDateColumn;
    }

    public void changeOpeningDateToBeDown() {
        if (!openingDateColumn.find("div").is(exist)) {
            openingDateColumn.click();
        }

        if (openingDateColumn.find("div").getAttribute("class").contains("up")) {
            openingDateColumn.click();
        }
    }

    public ElementsCollection getProjectsList() {
        return this.projectsList;
    }
}
