package core.pages.mob;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RecoveryPage extends MobileBaseTest {
    protected ElementsCollection recoveryByPhoneButton = $$(".content-card");
    protected ElementsCollection recoveryByMailButton = $$(".content-card");
    protected SelenideElement toolbarActions = $("nav .toolbar_actions-w");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов на странице")
    private void verifyPageElements() {
        toolbarActions.shouldBe(visible);
    }


    @Step("Кликаем восстановить по 'Телефону'")
    public void toRecoverByPhone() {
        recoveryByPhoneButton.first().click();
    }

    @Step("Кликаем восстановить по 'Электронная почта'")
    public void toRecoverByMail() {
        recoveryByMailButton.last().click();
    }
}



