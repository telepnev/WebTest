package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends MobileBaseTest {
    protected SelenideElement toSignInButton = $x("//input[@name='loginButton']");
    protected SelenideElement fieldLogin = $("#field_login");
    protected SelenideElement fieldPassword = $("#field_password");
    protected SelenideElement loginButton = $x("//input[@name='button_login']");

    protected SelenideElement toolbarActions = $("nav .toolbar_actions-w");

    // error message
    protected SelenideElement fieldErrorMessage = $(".field_error-descr");
    protected SelenideElement recoveryButton = $x("//a[text()='Не получается войти?']");

    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов на странице")
    private void verifyPageElements() {
        toolbarActions.shouldBe(visible);
    }

    @Step("Жмем кнопку авторизации")
    public void toSignIn() {
        toSignInButton.shouldBe(visible).click();
    }

    @Step("Жмем кнопку восстановления аккаунта")
    public void toRecovery() {
        recoveryButton.shouldBe(visible).click();
    }

    @Step("Авторизация пользователя с логином {login} и паролем {password}")
    public void toLogin(String login, String password) {
        fieldLogin.shouldBe(visible).setValue(login);
        fieldPassword.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }


    @Step("Вводим только логином {login} пользователя")
    public void toLoginWithoutPassword(String login) {
        fieldLogin.shouldBe(visible).setValue(login);
        fieldPassword.shouldBe(visible);
        loginButton.shouldBe(visible).click();
    }

    @Step("Вводим только пароль {password} пользователя")
    public void toLoginWithoutLogin(String password) {
        fieldLogin.shouldBe(visible).shouldBe(visible);
        fieldPassword.shouldBe(visible).setValue(password);
        ;
        loginButton.shouldBe(visible).click();
    }

    @Step("Проверяем текст ошибки 'Укажите логин'")
    public void checkLoginErrorMessage() {
        fieldErrorMessage.shouldBe(visible);
        fieldErrorMessage.shouldHave(text("Укажите логин"));
    }

    @Step("Проверяем текст ошибки 'Укажите пароль'")
    public void checkPasswordErrorMessage() {
        fieldErrorMessage.shouldBe(visible);
        fieldErrorMessage.shouldHave(text("Укажите пароль"));
    }

}
