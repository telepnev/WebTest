package core.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    protected SelenideElement headerLogo = $("#nohook_logo_link");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkEcosystem = $("[data-module='VkEcosystem']");
/*
    // login
    protected SelenideElement loginField = $("[name='st.email']");
    protected SelenideElement passwordField = $("[name='st.password']");
    protected SelenideElement signInButton = $("[name='t,sign_in']");
    // login
    public void login(String login, String password) {
        loginField.shouldBe(visible).setValue(login);
        passwordField.shouldBe(visible).setValue(password);
        signInButton.click();
    }
 */

    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    public void openVkEcosystem() {
        vkEcosystem.shouldBe(visible).click();
    }

    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }
}
