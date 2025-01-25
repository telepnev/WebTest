package tests.web;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import core.pages.web.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTest extends BaseTest {
    private static LoginPage loginPage;
    private static SearchPage searchPage;


    @BeforeEach
    public void prePage() {
        step("Переходим на страницу", () -> {
            open(baseUrl);
        });
        loginPage = new LoginPage();
    }

    @Test
    public void searchQaTest() {
        step("Вводим в поиск 'тестировщик' и жмем Enter", () -> {
        loginPage.search("тестировщик");
        });
        searchPage = new SearchPage();
        step("Проверяем что текст 'тестировщик' найден", () -> {
        searchPage.checkingThatTextWasFound("тестировщик");
        });
    }
}
