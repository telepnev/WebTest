package tests.web;


import core.base.BaseTest;
import core.pages.web.LoginPage;
import core.pages.web.QrCodePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class QrCodeTest extends BaseTest {
    private static LoginPage loginPage;
    private static QrCodePage qrCodePage;


    @BeforeEach
    public void prePage() {
        step("Переходим на страницу", () -> {
            open(baseUrl);
        });
        loginPage = new LoginPage();
    }

    @Test
    public void qrCodeShouldBeVisible() {
        loginPage.loginWithQrCode();

        qrCodePage = new QrCodePage();
        qrCodePage.checkQrCodeImage();
        qrCodePage.checkCodeAuth();
    }
}
