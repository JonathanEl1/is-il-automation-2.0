package pages.Projects.Tabs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static util.locators.Project.ProjectPageLocators.CONTACT_NAME;

public class ContactTab {

    private  static ContactTab contactTab;

    private final SelenideElement contactName = $(CONTACT_NAME);
    public void checkContactName(String name){
        contactName.shouldHave(text(name));
    }

    public static ContactTab getInstance() {
        if (contactTab == null) {
            contactTab = new ContactTab();
        }

        return contactTab;
    }

}
