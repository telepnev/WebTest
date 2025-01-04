package tests;

import com.github.javafaker.Faker;
import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.ConfermPhoneSmsPage;
import core.pages.LoginPage;
import core.pages.RecoveryByPhonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnonymRecoveryByPhoneTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByPhonePage recoveryByPhonePage;
    private static ConfermPhoneSmsPage confermSmsPage;
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
    public void checkingIncorrectSmsCodeMessageTest() {
        anonymRecoveryPage = new AnonymRecoveryPage();
        step("Переходим на страницу восстановления пароля", () -> {
            anonymRecoveryPage.gotoRecoveryByPoneButton();
        });

        recoveryByPhonePage = new RecoveryByPhonePage();
        step("Вводим номер телефона", () -> {
        recoveryByPhonePage.setPhoneNumber("79031112233");
        });
        step("Кликкаем по кнопке получить СмС", () -> {
        recoveryByPhonePage.clickGetSmsButton();
        });
        confermSmsPage = new ConfermPhoneSmsPage();
        step("Вводим полученный СмС", () -> {
        confermSmsPage.setSmsCode("1234");
        });
        step("Проверяем что сообщение ошибки появилось", () -> {
        confermSmsPage.checkingIncorrectSmsCodeMessage();
        });
    }

    @Test
    public void messageAboutMissingDigitsTest() {
        anonymRecoveryPage = new AnonymRecoveryPage();
        step("Переходим на страницу восстановления пароля", () -> {
            anonymRecoveryPage.gotoRecoveryByPoneButton();
        });

        recoveryByPhonePage = new RecoveryByPhonePage();
        step("Вводим номер телефона", () -> {
        recoveryByPhonePage.setPhoneNumber("7903111223");
        });
        step("Проверяем что сообщение ошибки появилось", () -> {
        recoveryByPhonePage.checkingMessageAboutMissingDigits();
        });
    }

    @Test
    public void messageAboutExtraNumbers() {
        anonymRecoveryPage = new AnonymRecoveryPage();
        step("Переходим на страницу восстановления пароля", () -> {
            anonymRecoveryPage.gotoRecoveryByPoneButton();
        });

        recoveryByPhonePage = new RecoveryByPhonePage();
        step("Вводим номер телефона", () -> {
        recoveryByPhonePage.setPhoneNumber("7903111223344");
        });
        step("Проверяем что сообщение ошибки появилось", () -> {
        recoveryByPhonePage.checkingMessageAboutExtraNumbers();
        });
    }

    @Test
    public void messageIncorrectPhoneNumberTest() {
        anonymRecoveryPage = new AnonymRecoveryPage();
        step("Переходим на страницу восстановления пароля", () -> {
        anonymRecoveryPage.gotoRecoveryByPoneButton();
        });

        recoveryByPhonePage = new RecoveryByPhonePage();
        step("Вводим номер телефона", () -> {
        recoveryByPhonePage.setPhoneNumber("790311122");
        });
        step("Жмем на кнопку получить Смс", () -> {
        recoveryByPhonePage.clickGetSmsButton();
        });
        step("Проверяем что сообщение ошибки появилось", () -> {
        recoveryByPhonePage.checkingMessageIncorrectPhoneNumber();
        });
    }
}
