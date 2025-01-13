package core.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryByPhonePage extends BasePage {

    protected SelenideElement setPhoneField = $("#field_phone");
    protected SelenideElement setCountry = $("[data-l='t,country']");
    protected SelenideElement submitSmsCodeButton = $("[data-l='t,submit']");
    protected SelenideElement missingDigitsMessage = $x("//div[contains(text(),'Осталось ввести')]");
    protected SelenideElement incorrectPhoneNumberMessage = $x("//div[contains(text(),'Неправильный номер телефона.')]");
    protected SelenideElement extraNumbersMessage = $x("//div[contains(text(),'лишних цифр')]");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице")
    private void verifyPageElements() {
        setPhoneField.shouldBe(visible);
      //  setCountry.shouldBe(visible);
        submitSmsCodeButton.shouldBe(visible);
    }

    @Step("Вводим номер телефона")
    public void setPhoneNumber(String phone) {
        setPhoneField.shouldBe(visible).click();
        setPhoneField.clear();
        setPhoneField.setValue(phone);
    }

    @Step("Выбираем страну")
    public void setCountry(String country) {
        setCountry.shouldBe(visible);
        setCountry.clear();
        setCountry.selectOption(country);
    }

    @Step("Нажимаем на кнопку Получить код")
    public void clickGetSmsButton() {
        submitSmsCodeButton.shouldBe(visible);
        submitSmsCodeButton.click();
    }

    @Step("Проверяем сообщение ошибки о нехватки цифр в номере телефона")
    public void checkingMessageAboutMissingDigits() {
        missingDigitsMessage.shouldBe(exist);
        missingDigitsMessage.shouldBe(visible);
    }

    @Step("Проверяем сообщение ошибки о лишних цифрах в номере телефона")
    public void checkingMessageAboutExtraNumbers() {
        extraNumbersMessage.shouldBe(exist);
        extraNumbersMessage.shouldBe(visible);
    }

    @Step("Проверяем сообщение: Неправильный номер телефона.")
    public void checkingMessageIncorrectPhoneNumber() {
        incorrectPhoneNumberMessage.shouldBe(exist);
        incorrectPhoneNumberMessage.shouldBe(visible);
    }
}
