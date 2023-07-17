package functional;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class RequestsTest extends BaseTest {
    private final LoginPage loginPage = LoginPage.getInstance();
    private final MainPage mainPage = MainPage.getInstance();

    @Test(priority = 1)
    @Description("Login with entrepreneur in Netivei Israel")
    @Parameters({"userNameOfEntrepreneurInNetiveiIsrael",
            "passwordOfEntrepreneurInNetiveiIsrael",
        "codeOfEntrepreneurInNetiveiIsrael"})
    public void request(String userNameOfEntrepreneurInNetiveiIsrael,
                             String passwordOfEntrepreneurInNetiveiIsrael,
                             String codeOfEntrepreneurInNetiveiIsrael)
            throws InterruptedException {
        loginPage.login(userNameOfEntrepreneurInNetiveiIsrael,
                passwordOfEntrepreneurInNetiveiIsrael,
                codeOfEntrepreneurInNetiveiIsrael);
        mainPage.clickOnRequests();
    }
}
