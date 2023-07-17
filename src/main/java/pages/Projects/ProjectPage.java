package pages.Projects;

import com.codeborne.selenide.SelenideElement;
import pages.Projects.Tabs.ProjectDetailsTab;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.$;
import static util.locators.Project.ProjectPageLocators.*;
import static com.codeborne.selenide.Condition.*;

public class ProjectPage {

    private static ProjectPage projectPage;

    private final ProjectDetailsTab projectDetailsTab = ProjectDetailsTab.getInstance();
    private final ProjectsPage projectsPage = ProjectsPage.getInstance();

    String projectName;
    String projectNum;

    // Elements

    private final SelenideElement projectTitle = $(PROJECT_TITLE_LOCATOR);
    private final SelenideElement saveButton = $(SAVE_BUTTON_LOCATOR);
    private final SelenideElement closeButton = $(CLOSE_BUTTON_LOCATOR);

    private final SelenideElement projectNameTB = $(PROJECT_NAME_LOCATOR);
    private final SelenideElement projectNumber = $(PROJECT_NUMBER_LOCATOR);
    private final SelenideElement enterprisingCompany = $(ENTERPRISING_COMPANY_LOCATOR);
    private final SelenideElement projectLeader = $(PROJECT_LEADER_LOCATOR);
    private final SelenideElement projectManager = $(PROJECT_MANAGER_LOCATOR);

    private final SelenideElement firstLevel = $(FIRST_LEVEL_LOCATOR);
    private final SelenideElement PlanningLevel = $(PLANNING_LEVEL_LOCATOR);
    private final SelenideElement implementationLevel = $(IMPLEMENTATION_LEVEL_LOCATOR);
    private final SelenideElement canceledLevel = $(CANCELLED_LEVEL_LOCATOR);

    private final SelenideElement projectDetails = $(PROJECT_DETAILS_LOCATOR);
    private final SelenideElement contacts = $(CONTACTS_LOCATOR);
    private final SelenideElement subProjects = $(SUB_PROJECTS_LOCATOR);
    private final SelenideElement timeline = $(TIMELINE_LOCATOR);
    private final SelenideElement stepLogAtProjects = $(STEP_LOG_AT_PROJECTS_LOCATOR);
    private final SelenideElement messagesBoard = $(MESSAGES_BOARD_LOCATOR);
    // Constructor

    public static ProjectPage getInstance() {
        if (projectPage == null) {
            projectPage = new ProjectPage();
        }

        return projectPage;
    }

    // Class methods

    private void checkProjectTitleAfterSaving() {
        this.projectTitle.shouldHave(text(projectName));
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private String getCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private void checkProjectNumber() {
        if (!projectNumber.is(exist)) {
            closeButton.shouldBe(exist).click();
            projectsPage.changeOpeningDateToBeDown();
            projectsPage.getProjectsList().get(0).doubleClick();
        }

        this.projectNum = this.projectNumber.shouldBe(exist).getValue();
    }

    private void checkIfLevelIsLocked(SelenideElement level) {
        level.shouldBe(exist).shouldHave(cssValue("cursor", "not-allowed"));
    }

    // Global methods

    public void inputProjectName(String projectName) {
        this.projectNameTB.shouldBe(exist).sendKeys(projectName);
        this.projectName = projectName;
    }

    public void checkEnterprisingCompany(String enterprisingCompany) {
        this.enterprisingCompany.shouldHave(text(enterprisingCompany));
    }

    public void checkProjectLeader(String projectLeader) {
        this.projectLeader.shouldHave(text(projectLeader));
    }

    public void clickOnSaveButton() {
        String saveTime = getCurrentTime();
        saveButton.click();

        checkIfFirstLevelIsChecked();
        checkIfLevelIsLocked(firstLevel);

        checkProjectTitleAfterSaving();
        checkProjectNumber();

        projectDetailsTab.getOpeningDate().shouldHave(value(getCurrentDate()));
        projectDetailsTab.getOpeningTime().shouldHave(value(saveTime));
        projectDetailsTab.getModifiedDate().shouldHave(value(getCurrentDate()));
        projectDetailsTab.getModifyingTime().shouldHave(value(saveTime));
    }

    public SelenideElement getProjectTitle() {
        return projectTitle;
    }

    public void checkIfFirstLevelIsChecked() {
        String colorOfSelectedStatus = "rgba(142, 203, 96, 1)";
        firstLevel.shouldBe(exist).shouldHave(cssValue("background-color",
                colorOfSelectedStatus));
    }

    public void clickOnProjectDetails() {
        projectDetails.shouldBe(exist).click();
    }

    public void clickOnContacts() {
        contacts.shouldBe(exist).click();
    }

    public void clickOnSubProjects() {
        subProjects.shouldBe(exist).click();
    }

    public void clickOnTimeline() {
        timeline.shouldBe(exist).click();
    }

    public void clickOnStepLogAtProjects() {
        stepLogAtProjects.shouldBe(exist).click();
    }

    public void clickOnMessagesBoard() {
        messagesBoard.shouldBe(exist).click();
    }


}
