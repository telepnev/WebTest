package core.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ConfermPhoneSmsPage extends BasePage{
    protected SelenideElement editPhoneButton = $("[data-l='t,edit_phone']");
    protected SelenideElement confirmCodeButton = $("[data-l='t,submit']");
    protected SelenideElement getNewSmsCodeButton = $("[data-l='t,get_code']");
    protected SelenideElement textResendSmsCode = $(".js-resend-sms-code_tx");
    protected SelenideElement smsCodeField = $("#smsCode");
    protected SelenideElement goToSupportButton = $("[data-l='t,support']");
    protected SelenideElement wrongCodeText = $x("//span[@class='input-e']");


    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице")
    private void verifyPageElements() {
        editPhoneButton.shouldBe(visible);
        confirmCodeButton.shouldBe(visible);
        smsCodeField.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
        textResendSmsCode.shouldBe(visible);
    }

    @Step("Вводим смс код")
    public void setSmsCode(String sms) {
        smsCodeField.shouldBe(visible);
        smsCodeField.clear();
        smsCodeField.setValue(sms);
        confirmCodeButton.shouldBe(visible);
        confirmCodeButton.click();

    }

    @Step("Вводим некорректный смс код")
    public void checkingIncorrectSmsCodeMessage() {
        wrongCodeText.shouldBe(visible);
    }
}
