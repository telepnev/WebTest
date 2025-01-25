package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ConfermMailSmsPage extends BasePage {

    protected SelenideElement headerText = $x("//div[text()='Введите код (6 цифр), который мы отправили по адресу']");
    protected SelenideElement headerTextMail = $x("//div[@class='ext-registration_phone-number']");
 //   protected SelenideElement headerTextMail = $x("//label[text()='Введите код из письма']");
    protected SelenideElement errorCodeMassage = $x("//span[text()='Код введен неправильно. Проверьте код или запросите его еще раз']");

    protected SelenideElement emailCodeField = $("#emailCode");
    protected SelenideElement submitSmsCodeByMail = $("[data-l='t,submit']");


    @Step("Проверяем что указанная почта совпадает с отображаемой почтой на странице ")
    public void checkHeaderTextMessageAndEmail(String mail) {
        headerText.shouldBe(exist);
        headerText.shouldBe(visible);

        headerTextMail.shouldBe(exist);
        headerTextMail.shouldBe(visible);
        String email = headerTextMail.getText();
        Assertions.assertEquals(email, mail, "Почты не совпадают");
    }

    @Step("Проверяем сообщение о неверном введенном коде из письма")
    public void checkIncorrectSmsCodeByMailMessage() {
        errorCodeMassage.shouldBe(exist);
        errorCodeMassage.shouldBe(visible);
    }

    @Step("Вводим код из письма")
    public void setEmailCode(String code) {
        emailCodeField.shouldBe(visible);
        emailCodeField.clear();
        emailCodeField.setValue(code);
    }

    @Step("Вводим код из письма")
    public void submitEmailCode() {
        submitSmsCodeByMail.shouldBe(visible);
        submitSmsCodeByMail.click();

    }
}
