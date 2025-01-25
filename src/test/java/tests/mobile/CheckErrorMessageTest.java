package tests.mobile;

import core.base.MobileBaseTest;

import core.pages.mob.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckErrorMessageTest extends MobileBaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prePage() {
        step("Переходим на страницу", () -> {
            open(baseUrl);
        });
        loginPage = new LoginPage();
    }

    @Test
    public void checkLoginErrorMessage() {
        step("Жмем кнопку Войти", () -> {
        loginPage.toSignIn();
        });
        step("Вводим только пароль и нажимаем Войт", () -> {
        loginPage.toLoginWithoutLogin("123324");
        });
        step("Проверяем текст сообщения", () -> {
        loginPage.checkLoginErrorMessage();
        });
    }

    @Test
    public void checkLoginErrorPasswordMessage() {
        step("Жмем кнопку Войти", () -> {
            loginPage.toSignIn();
        });
        step("Вводим только пароль и нажимаем Войт", () -> {
            loginPage.toLoginWithoutPassword("samLogin");
        });
        step("Проверяем текст сообщения", () -> {
            loginPage.checkPasswordErrorMessage();
        });
    }
}
