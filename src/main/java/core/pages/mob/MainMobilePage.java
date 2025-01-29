package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class MainMobilePage extends MobileBaseTest {
    protected SelenideElement toSignInButton = $(".login");
    protected SelenideElement toSignUpButton = $(".register");
    protected SelenideElement title = $(".login-landing-promo_title");
    protected SelenideElement logo = $(".login-landing-promo_logo");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов на странице")
    private void verifyPageElements() {
        toSignInButton.shouldBe(visible);
        toSignUpButton.shouldBe(visible);
        title.shouldBe(visible);
        logo.shouldBe(visible);
    }

    @Step("Нажимаем 'Войти'")
    public void toSignIn() {
        toSignInButton.click();
    }
}
