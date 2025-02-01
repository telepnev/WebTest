package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByMailPage extends MobileBaseTest {
    protected SelenideElement toolbarActions = $("nav .toolbar_actions-w");
    protected SelenideElement fieldEmail = $("#field_email");
    protected SelenideElement regEmailButton = $("#reg_email_button");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов на странице")
    private void verifyPageElements() {
        toolbarActions.shouldBe(visible);
        fieldEmail.shouldBe(visible);
        regEmailButton.shouldBe(visible);
    }
}
