package tests.mobile;

import core.base.MobileBaseTest;
import core.pages.mob.LoginPage;
import core.pages.mob.MainMobilePage;
import core.pages.mob.RecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TransferringRecoveryTest extends MobileBaseTest {
    private static LoginPage loginPage;
    private static RecoveryPage recovery;
    private static TransferringRecoveryTest recoveryByPhone;
    private static MainMobilePage mainMobilePage;

    @BeforeEach
    public void prePage() {
        step("Переходим на страницу", () -> {
            open(baseUrl);
        });
    }

    @Test
    public void checkingTransferringRecoveryByPhone() {
        mainMobilePage = new MainMobilePage();
        step("Жмем кнопку Войти", () -> {
            mainMobilePage.toSignIn();
        });

        loginPage = new LoginPage();
        step("Кликаем восстановить по 'Не получается войти?'", () -> {
            loginPage.toRecovery();
        });

        recovery = new RecoveryPage();
        step("Кликаем кнопку 'Телефон'", () -> {
            recovery.toRecoverByPhone();
        });

        step("Проверка видимости элементов", () -> {
            recoveryByPhone = new TransferringRecoveryTest();
        });
    }


    @Test
    public void checkingTransferringRecoveryByMail() {
        mainMobilePage = new MainMobilePage();
        step("Жмем кнопку Войти", () -> {
            mainMobilePage.toSignIn();
        });

        loginPage = new LoginPage();
        step("Кликаем восстановить по 'Не получается войти?'", () -> {
            loginPage.toRecovery();
        });

        recovery = new RecoveryPage();
        step("Кликаем кнопку 'Телефон'", () -> {
            recovery.toRecoverByMail();
        });

        step("Проверка видимости элементов", () -> {
            recoveryByPhone = new TransferringRecoveryTest();
        });
    }
}
