package core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class QrCodePage extends BasePage {
    protected SelenideElement qrCodeImage = $(".qr_code_image");
    protected SelenideElement qrCodeInfo = $(".qr_code_info");
    protected SelenideElement authCod = $(".qr_code_info_digest");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости блока QR-кода")
    private void verifyPageElements() {
        qrCodeInfo.shouldBe(visible);
    }

    @Step("Проверка видимости QR-кода")
    public void checkQrCodeImage() {
        qrCodeImage.shouldBe(visible);
    }

    @Step("Проверка видимости QR-кода")
    public void checkCodeAuth() {
        authCod.shouldNotBe(empty);
    }
}
