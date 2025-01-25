package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HelpDescPage extends BasePage {
    protected SelenideElement supportButton = $(".support-link_item-text");
    protected SelenideElement qrCodeInfo = $(".qr_code_info");
    protected SelenideElement phoneButton = $("[data-l='t,phone']");
    protected SelenideElement emailButton = $("[data-l='t,email']");
    protected SelenideElement supportChatWindow = $("[data-bundle-name='support-chat']");
    protected SelenideElement closeSupportChatButton = $x("//button[@title='Закрыть чат со службой поддержки']");
    protected SelenideElement yesButton = $x("//span[text()='Да']");
    protected SelenideElement notButton = $x("//span[text()='Нет']");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов на странице")
    private void verifyPageElements() {
        supportButton.shouldBe(visible);
        qrCodeInfo.shouldBe(visible);
        phoneButton.shouldBe(visible);
        emailButton.shouldBe(visible);
    }

    @Step("Нажимает 'Обратиться в службу поддержки'")
    public void gotoSupport() {
        supportButton.click();
    }

    @Step("Проверяем отображение чата поддержки")
    public void checkSupportChatShouldBeVisible() {
        supportChatWindow.shouldBe(visible);
    }

    @Step("Закрываем чат поддержки")
    public void closeSupportChat() {
        closeSupportChatButton.click();
    }

    @Step("Ваш вопрос точно был решён? Нажимаем 'ДА'")
    public void confirmYes() {
        yesButton.click();
    }

    @Step("Ваш вопрос точно был решён? Нажимаем 'НЕТ'")
    public void confirmNot() {
        notButton.click();
    }
}

