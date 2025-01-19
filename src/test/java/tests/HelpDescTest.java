package tests;

import core.base.BaseTest;
import core.pages.HelpDescPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HelpDescTest extends BaseTest {

    private static LoginPage loginPage;
    private static HelpDescPage helpDescPage;


    @BeforeEach
    public void prePage() {
        step("Переходим на страницу", () -> {
            open(baseUrl);
        });
        loginPage = new LoginPage();
    }

    @Test
    public void helpDescTest() {
        loginPage.gotoHelpDesc();
        helpDescPage = new HelpDescPage();

        helpDescPage.gotoSupport();
        helpDescPage.checkSupportChatShouldBeVisible();
        helpDescPage.closeSupportChat();
        helpDescPage.confirmYes();
    }
}

