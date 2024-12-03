package core.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    protected SelenideElement headerLogo = $("#nohook_logo_link");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkEcosystem = $("[data-module='VkEcosystem']");

    @Step("Открываем поле поиска и ищем по запросу: {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step("Открываем сервисы - Vk Ecosystem")
    public void openVkEcosystem() {
        vkEcosystem.shouldBe(visible).click();
    }

    @Step("Кликаем по лого ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }
}
