package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPage extends BasePage {


    protected SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    protected SelenideElement recoveryEmailButton = $("[data-l='t,email']");
    protected SelenideElement goToSupportButton = $("[data-l='t,support']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку вотсанновления через Телефон")
    public void gotoRecoveryByPoneButton() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку вотсанновления через Почту")
    public void gotoRecoveryEmailButton() {
        recoveryEmailButton.shouldBe(visible).click();
    }

    @Step("Переходим к технической поддержке")
    public void gotoSupportButton() {
        goToSupportButton.shouldBe(visible).click();
    }
}

