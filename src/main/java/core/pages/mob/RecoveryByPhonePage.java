package core.pages.mob;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RecoveryByPhonePage extends BasePage {

    protected SelenideElement getCodeButton = $("#getCode");
    protected SelenideElement countryNameButton = $("#countryName");
    protected SelenideElement fieldPhone = $("#field_phone");
    protected ElementsCollection listCountry = $$(".choose-list li a");
    protected SelenideElement errorText = $x("//label[text()='Введен неверный номер телефона']");


    @Step("Выбираем страну")
    public void setCountry(String country) {
        countryNameButton.click();
        listCountry.findBy(text(country)).click();
    }

    @Step("Указываем номер телефона")
    public void setPhone(String phoneNumber) {
        fieldPhone.shouldBe(visible).setValue(phoneNumber);
    }

    @Step("Кликаем 'Получить код' ")
    public void getCode() {
        getCodeButton.shouldBe(visible).click();
    }

    @Step("Проверяем что текст с ошибкой виден")
    public void checkErrorTextShouldBeVisible() {
        errorText.shouldBe(visible);
    }

}
