package tests;

import com.github.javafaker.Faker;
import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWhitWrongCredential extends BaseTest {
    private static LoginPage loginPage;
    private static Faker faker;

    @BeforeEach
    public void prePage() {
        step("Переходим на страницу", () -> {
            open(baseUrl);
        });

        loginPage = new LoginPage();
        faker = new Faker();
    }

    @Test
    public void loginWhitWrongCredential() {
        step("Вводим логин и пароль", () -> {
            loginPage.login(faker.name().username(), faker.internet().password());
        });

        step("Проверяем что сообщение о ошибки появилось", () -> {
            assertTrue(loginPage.isErrorMessageVisible());
        });

        String expectErrorMessage = "Неправильно указан логин и/или пароль";
        String actualMessage = loginPage.getErrorMessageText();

        step("Проверяем что ожидаемое сообщение о ошибки совпадает с полученным", () -> {
            assertEquals(expectErrorMessage, actualMessage);
        });
    }

    @Test
    public void loginWithoutPassword() {
        step("Вводим логин и не указываем пароль", () -> {
            loginPage.authWithoutPassword(faker.name().username());
        });

        step("Проверяем что сообщение о ошибки появилось", () -> {
            assertTrue(loginPage.isErrorMessageVisible());
        });

        String expectErrorMessage = "Введите пароль";
        String actualMessage = loginPage.getErrorMessageText();

        step("Проверяем что ожидаемое сообщение о ошибки совпадает с полученным", () -> {
            assertEquals(expectErrorMessage, actualMessage);
        });
    }

    @Test
    public void loginWithoutLogin() {
        step("Вводим пароль и не указываем логин", () -> {
            loginPage.authWithoutLogin(faker.internet().password());
        });


        step("Проверяем что сообщение о ошибки появилось", () -> {
            assertTrue(loginPage.isErrorMessageVisible());
        });

        String expectErrorMessage = "Введите логин";
        String actualMessage = loginPage.getErrorMessageText();

        step("Проверяем что ожидаемое сообщение о ошибки совпадает с полученным", () -> {
            assertEquals(expectErrorMessage, actualMessage);
        });
    }

    @Test
    public void loginWithoutCredential() {
        step("Оставляем поля логин и пароль пустые и жмем кнопку 'Войти в Одноклассники' ", () -> {
            loginPage.clickToLoginButton();
        });

        step("Проверяем что сообщение о ошибки появилось", () -> {
            assertTrue(loginPage.isErrorMessageVisible());
        });

        String expectErrorMessage = "Введите логин";
        String actualMessage = loginPage.getErrorMessageText();

        step("Проверяем что ожидаемое сообщение о ошибки совпадает с полученным", () -> {
            assertEquals(expectErrorMessage, actualMessage);
        });
    }

}
