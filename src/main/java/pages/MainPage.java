package pages;

import com.codeborne.selenide.SelenideElement;
import pages.Projects.ProjectsPage;;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static util.locators.MainPageLocators.*;

public class MainPage {

    private static MainPage mainPage;

    // Elements

    private final SelenideElement projectsButton = $(PROJECTS_LOCATOR);
    private final SelenideElement requestsButton = $(REQUESTS_LOCATOR);
    private final SelenideElement applicationsButton = $(APPLICATIONS_LOCATOR);
    private final SelenideElement openingNewUsernameButton = $(OPENING_NEW_USERNAME_LOCATOR);
    private final SelenideElement openingNewCompanyButton = $(OPENING_NEW_COMPANY_LOCATOR);
    private final SelenideElement internalTreatmentButton = $(INTERNAL_TREATMENT_LOCATOR);
    private final SelenideElement internalReferenceButton = $(INTERNAL_REFERENCE_LOCATOR);

    // Constructor

    public static MainPage getInstance() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }

        return mainPage;
    }

    // Global methods

    public void clickOnProjects() {
        projectsButton.shouldBe(exist).click();
    }

    public void clickOnRequests() {
        requestsButton.shouldBe(exist).click();
    }

    public void clickOnApplications() {
        applicationsButton.shouldBe(exist).click();
    }

    public void clickOnOpeningNewUsername() {
        openingNewUsernameButton.shouldBe(exist).click();
    }

    public void clickOnOpeningNewCompany() {
        openingNewCompanyButton.shouldBe(exist).click();
    }

    public void clickOnInternalTreatment() {
        internalTreatmentButton.shouldBe(exist).click();
    }

    public void clickOnInternalReference() {
        internalReferenceButton.shouldBe(exist).click();
    }
    public void existingProjectLink() {
        projectsButton.shouldBe(enabled);
    }


}
