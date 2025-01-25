package core.pages.mob;

import com.codeborne.selenide.ElementsCollection;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class RecoveryPage extends BasePage {
    protected ElementsCollection recoveryByPhoneButton = $$(".content-card");
   protected ElementsCollection recoveryByMailButton = $$(".content-card");


    @Step("Кликаем восстановить по 'Телефону'")
    public void toRecoverByPhone() {
        recoveryByPhoneButton.first().click();
    }

    @Step("Кликаем восстановить по 'Электронная почта'")
    public void toRecoverByMail() {
        recoveryByMailButton.last().click();
    }
}



