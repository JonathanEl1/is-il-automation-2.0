package util;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CommonActions {
    protected void toggleSelection(SelenideElement toggleButton, boolean state) {
        toggleButton.$(" button[value = '" + state + "']").scrollIntoView(false).click();
    }

    protected void clearAndFillTextField(SelenideElement textField, String value) {
        textField.scrollIntoView(false);
        do {
            textField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        } while (!Objects.requireNonNull(textField.getValue()).isEmpty());

        actions()
                .click(textField)
                .pause(500)
                .sendKeys(textField, value)
                .pause(300)
                .build()
                .perform();
    }

    protected void selectValueFromDropdown(SelenideElement dropDownField, String value) {
        clearAndFillTextField(dropDownField, value);

        actions()
                .pause(500)
                .sendKeys(dropDownField, Keys.ARROW_UP)
                .build()
                .perform();

        actions()
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        // Click somewhere else in the page to confirm selection.
        // Confirming selection via pressing Enter seems to be
        // quite buggy.
        SelenideElement logo = $("img[alt='logo']");
        actions()
                .click(logo)
                .build()
                .perform();
    }

    protected void clearInputField(SelenideElement field) {
        field.scrollIntoView(true);
        actions()
                .sendKeys(field, Keys.LEFT_CONTROL, "A")
                .pause(500)
                .sendKeys(field, Keys.BACK_SPACE)
                .build()
                .perform();
    }
}
