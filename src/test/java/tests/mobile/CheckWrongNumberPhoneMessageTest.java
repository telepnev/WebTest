package tests.mobile;

import core.base.MobileBaseTest;
import core.pages.mob.LoginPage;
import core.pages.mob.RecoveryByPhonePage;
import core.pages.mob.RecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckWrongNumberPhoneMessageTest extends MobileBaseTest {
    private static LoginPage loginPage;
    private static RecoveryPage recovery;
    private static RecoveryByPhonePage recoveryByPhone;

    @BeforeEach
    public void prePage() {
        step("Переходим на страницу", () -> {
            open(baseUrl);
        });
        loginPage = new LoginPage();
    }

    @Test
    public void checkWrongNumberPhoneMessage() {
        String country = "Антильские острова";
        String phoneNumber = "123";

        loginPage.toSignIn();
        loginPage.toRecovery();

        recovery = new RecoveryPage();
        recovery.toRecoverByPhone();

        recoveryByPhone = new RecoveryByPhonePage();
        recoveryByPhone.setCountry(country);
        recoveryByPhone.setPhone(phoneNumber);
        recoveryByPhone.getCode();
        recoveryByPhone.checkErrorTextShouldBeVisible();
    }

}
