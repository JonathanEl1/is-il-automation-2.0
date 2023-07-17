package functional;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import pages.Projects.*;
import pages.Projects.Tabs.ContactTab;
import pages.Projects.Tabs.ProjectDetailsTab;


public class EntrepreneurTest extends BaseTest {

    private final LoginPage loginPage = LoginPage.getInstance();
    private final MainPage mainPage = MainPage.getInstance();
    private final ProjectsPage projectsPage = ProjectsPage.getInstance();
    private final ProjectPage projectPage = ProjectPage.getInstance();
    private final ProjectDetailsTab projectDetailsTab = ProjectDetailsTab.getInstance();
    private final ContactTab contactTab = ContactTab.getInstance();

    @Test(priority = 1)
    @Description("Login with entrepreneur in Netivei Israel")
    @Parameters({"userNameOfEntrepreneurInNetiveiIsrael",
            "passwordOfEntrepreneurInNetiveiIsrael",
            "codeOfEntrepreneurInNetiveiIsrael"})
    public void loginWithEntrepreneur(String userNameOfEntrepreneurInNetiveiIsrael,
                        String passwordOfEntrepreneurInNetiveiIsrael,
                        String codeOfEntrepreneurInNetiveiIsrael)
            throws InterruptedException {
        loginPage.login(userNameOfEntrepreneurInNetiveiIsrael,
                passwordOfEntrepreneurInNetiveiIsrael,
                codeOfEntrepreneurInNetiveiIsrael);
    }

    @Test(priority = 2)
    @Description("Testing if entrepreneur user sees only projects of his company")
    @Parameters({"enterprisingCompany"})
    public void seeOnlyMyProjects(String enterprisingCompany) {
        mainPage.clickOnProjects();
        projectsPage.checkEnterprisingCompanyInProjects(enterprisingCompany);
        projectsPage.checkAmountOfProjects();
    }

    @Test(priority = 3)
    @Description("Open new project")
    @Parameters({"projectName", "enterprisingCompany", "entrepreneurName",
            "projectDomain", "projectDescription", "locationDescription"})
    public void openNewProject(String projectName, String enterprisingCompany,
                               String entrepreneurName, String projectDomain,
                               String projectDescription, String locationDescription) {
        final String OPEN_STATUS = "פתוח";

        projectsPage.clickOnNewProjectButton();
        projectPage.inputProjectName(projectName);
        projectPage.checkEnterprisingCompany(enterprisingCompany);
        projectPage.checkProjectLeader(entrepreneurName);

        projectDetailsTab.checkProjectDomain(projectDomain);
        projectDetailsTab.chooseRandomProjectSubDomain();
        projectDetailsTab.inputProjectDescription(projectDescription);
        projectDetailsTab.inputLocationDescription(locationDescription);
        projectDetailsTab.checkProjectStatus(OPEN_STATUS);
        projectDetailsTab.CheckCreatedBy(entrepreneurName);
        projectDetailsTab.CheckModifiedBy(entrepreneurName);

        projectPage.clickOnSaveButton();
    }

    @Test(priority = 4)
    @Description("Contact tab name")
    @Parameters({"entrepreneurName"})
    public void ContactsTab(String entrepreneurName){
        projectPage.clickOnContacts();
        contactTab.checkContactName(entrepreneurName);
    }
}