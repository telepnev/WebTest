package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryByMailPage extends BasePage {

    protected SelenideElement fieldEmail = $("#field_email");
    protected SelenideElement submitSmsCodeByMail = $("[data-l='t,submit']");
    protected SelenideElement incorrectMailFormatMessage = $x("//div[text()='Неправильный формат почты']");


    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице")
    private void verifyPageElements() {
        fieldEmail.shouldBe(visible);
        submitSmsCodeByMail.shouldBe(visible);
    }

    @Step("Вводим почту")
    public void setMail(String mail) {
        fieldEmail.shouldBe(visible);
        fieldEmail.clear();
        fieldEmail.setValue(mail);
    }

    @Step("Нажимаем кнопку 'Получить код'")
    public void submitEmail() {
        submitSmsCodeByMail.shouldBe(visible);
        submitSmsCodeByMail.click();
    }

    @Step("Проверяем сообщение 'Неправильный формат почты'")
    public void checkIncorrectMailFormatMessage() {
        incorrectMailFormatMessage.shouldBe(exist);
        incorrectMailFormatMessage.shouldBe(visible);
    }

}
