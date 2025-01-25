package tests.web;

import com.github.javafaker.Faker;
import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.ConfermMailSmsPage;
import core.pages.web.LoginPage;
import core.pages.web.RecoveryByMailPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AnonymRecoveryByMailTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByMailPage recoveryByMailPage;
    private static ConfermMailSmsPage confermMailSmsPage;
    private static Faker faker;

    @BeforeEach
    public void prePage() {
        step("Переходим на страницу", () -> {
            open(baseUrl);
        });

        loginPage = new LoginPage();
        faker = new Faker();

        step("Вводим логин и пароль", () -> {
            loginPage.setLogin(faker.name().username());
        });

        for (int i = 0; i < 3; i++) {
            loginPage.setPassword("1234");
            loginPage.clickToLoginButton();
        }
        loginPage.gotoRecovery();
    }

    @Test
    public void positiveRecoveryByMailTest() {
        String actualMail = faker.internet().emailAddress();
        anonymRecoveryPage = new AnonymRecoveryPage();
        step("Переходим на страницу восстановления пароля", () -> {
            anonymRecoveryPage.gotoRecoveryByPoneButton();
        });

        recoveryByMailPage = new RecoveryByMailPage();
        step("Вводим почту", () -> {
            recoveryByMailPage.setMail(actualMail);
        });
        step("Жмем кнопку Отправить", () -> {
            recoveryByMailPage.submitEmail();
        });
        confermMailSmsPage = new ConfermMailSmsPage();
        step("Проверяем текст ошибки", () -> {
            confermMailSmsPage.checkHeaderTextMessageAndEmail(actualMail);
        });
    }

    @ParameterizedTest
    @CsvSource({"user@.com", "user@domain", "user@domain.", "user@domain..com",
            "user@domain.c", "user@domain.co-m", "user@domain.com-",
            "user@domain..com", "user@domain.c_om"
    })
    public void checkErrorMessageTest(String email) {
        anonymRecoveryPage = new AnonymRecoveryPage();
        step("Переходим на страницу восстановления пароля", () -> {
            anonymRecoveryPage.gotoRecoveryByPoneButton();
        });
        recoveryByMailPage = new RecoveryByMailPage();
        step("Вводим почту", () -> {
            recoveryByMailPage.setMail(email);
        });
        step("Жмем кнопку Отправить", () -> {
            recoveryByMailPage.submitEmail();
        });
        step("Проверяем текст ошибки", () -> {
            recoveryByMailPage.checkIncorrectMailFormatMessage();
        });
    }

    @ParameterizedTest
    @CsvSource({"1", "123", " 2345 "})
    public void checkErrorCodeMessageTest(String emailCode) {
        String actualMail = faker.internet().emailAddress();
        anonymRecoveryPage = new AnonymRecoveryPage();
        step("Переходим на страницу восстановления пароля", () -> {
            anonymRecoveryPage.gotoRecoveryByPoneButton();
        });

        recoveryByMailPage = new RecoveryByMailPage();
        step("Вводим почту", () -> {
            recoveryByMailPage.setMail(actualMail);
        });
        step("Жмем кнопку Отправить", () -> {
            recoveryByMailPage.submitEmail();
        });

        confermMailSmsPage = new ConfermMailSmsPage();
        step("Вводим некорректный код подтверждения", () -> {
            confermMailSmsPage.setEmailCode(emailCode);
        });
        step("Жмем кнопку Подтвердить", () -> {
            confermMailSmsPage.submitEmailCode();
        });
        step("Проверяем текст ошибки", () -> {
            confermMailSmsPage.checkIncorrectSmsCodeByMailMessage();
        });
    }

}
