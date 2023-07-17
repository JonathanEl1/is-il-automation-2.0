package pages.Projects.Tabs;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.Projects.ProjectsPage;

import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static util.locators.Project.Tabs.ProjectDetailsLocators.*;
import static com.codeborne.selenide.Condition.*;

public class ProjectDetailsTab {

    private static ProjectDetailsTab projectDetailsTab;

    // Elements

    private final SelenideElement projectDomain = $(PROJECT_DOMAIN_LOCATOR);
    private final SelenideElement projectSubDomainText = $(
            PROJECT_SUB_DOMAIN_TEXT_LOCATOR);
    private final SelenideElement projectSubDomainButton = $(
            PROJECT_SUB_DOMAIN_BUTTON_LOCATOR);
    private final ElementsCollection projectSubDomainList = $$(
            PROJECT_SUB_DOMAIN_LIST_LOCATOR);
    private final SelenideElement projectDescription = $(PROJECT_DESCRIPTION_LOCATOR);
    private final SelenideElement locationDescription = $(LOCATION_DESCRIPTION_LOCATOR);
    private final SelenideElement projectStatus = $(PROJECT_STATUS_LOCATOR);
    private final SelenideElement createdBy = $(CREATED_BY_LOCATOR);
    private final SelenideElement openingDate = $(OPENING_DATE_LOCATOR);
    private final SelenideElement openingTime = $(OPENING_TIME_LOCATOR);
    private final SelenideElement modifiedBy = $(MODIFIED_BY_LOCATOR);
    private final SelenideElement modifiedDate = $(MODIFIED_DATE_LOCATOR);
    private final SelenideElement modifyingTime = $(MODIFYING_TIME_LOCATOR);

    // Constructor

    public static ProjectDetailsTab getInstance() {
        if (projectDetailsTab == null) {
            projectDetailsTab = new ProjectDetailsTab();
        }

        return projectDetailsTab;
    }

    // Class methods


    // Global methods

    public void checkProjectDomain(String projectDomain) {
        this.projectDomain.shouldHave(value(projectDomain));
    }

    public void chooseRandomProjectSubDomain() {
        Random random = new Random();
        int randomNumber;
        String projectSubDomain;

        projectSubDomainButton.click();
        projectSubDomainList.shouldBe(sizeGreaterThan(0));
        randomNumber = random.nextInt(projectSubDomainList.size());
        projectSubDomain = projectSubDomainList.get(randomNumber).getAttribute(
                "data-item-marker");
        projectSubDomainList.get(randomNumber).doubleClick();
        projectSubDomainText.shouldHave(value(projectSubDomain));
    }

    public void inputProjectDescription(String projectDescription) {
        this.projectDescription.shouldBe(exist).sendKeys(projectDescription);
    }

    public void inputLocationDescription(String locationDescription) {
        this.locationDescription.shouldBe(exist).sendKeys(locationDescription);
    }

    public void checkProjectStatus(String status) {
        projectStatus.shouldHave(value(status));
    }

    public void CheckCreatedBy(String entrepreneurName) {
        createdBy.shouldHave(text(entrepreneurName));
    }

    public void CheckModifiedBy(String entrepreneurName) {
        modifiedBy.shouldHave(text(entrepreneurName));
    }

    public SelenideElement getOpeningDate() {
        return this.openingDate;
    }

    public SelenideElement getOpeningTime() {
        return this.openingTime;
    }

    public SelenideElement getModifiedDate() {
        return this.modifiedDate;
    }

    public SelenideElement getModifyingTime() {
        return this.modifyingTime;
    }
}
