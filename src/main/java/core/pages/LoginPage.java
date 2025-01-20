package core.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    // login form
    protected SelenideElement loginField = $("#field_email");
    protected SelenideElement passwordField = $("#field_password");
    protected SelenideElement signInButton = $x("//input[@type='submit']");

    //search input
    protected SelenideElement searchInput = $("[data-tsid='toolbar-search-input']");

    // buttons
    protected SelenideElement registrationButton = $x("//div[@class='external-oauth-login-footer']/a[@data-l='t,register']");
    protected SelenideElement enterByQrCodeButton = $(".qr-button-label");
    protected SelenideElement troubleLoggingInButton = $x("//a[@tsid='restore']");
    protected SelenideElement registrationByVk = $("[data-l='t,vkc']");
    protected SelenideElement registrationByMailru = $x("//a[@data-l='t,mailru']");
    protected SelenideElement registrationByYandex = $x("//a[@data-l='t,yandex']");

    // страница восстановления пароля
    protected SelenideElement recProfButton = $x("//div[@class='form-actions']/button[@tsid='restore']");
    protected SelenideElement returnToLoginPage = $x("//div[@class='form-actions']/a[@data-l='t,cancel']");

    // footer
    protected SelenideElement footerBloke = $x("//div[@id='footer']");

    // error message
    protected SelenideElement errorMessage = $x("//div[@class='input-e login_error']");


    // Блок инициализации метода verifyPageElements(), хитрый ...
    {
        verifyPageElements();
    }

    @Step("Проверка видимости элементов на странице")
    private void verifyPageElements() {
        loginField.shouldBe(visible);
        passwordField.shouldBe(visible);
        signInButton.shouldBe(visible);
        registrationButton.shouldBe(visible);
        enterByQrCodeButton.shouldBe(visible);
        troubleLoggingInButton.shouldBe(visible);
        registrationByVk.shouldBe(visible);
        registrationByMailru.shouldBe(visible);
        registrationByYandex.shouldBe(visible);
        footerBloke.shouldBe(visible).exists();
    }

    @Step("Авторизация пользователя с логином {login} и паролем {password}")
    public void login(String login, String password) {
        loginField.shouldBe(visible).click();
        loginField.shouldBe(visible).clear();
        loginField.shouldBe(visible).setValue(login);

        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).clear();
        passwordField.shouldBe(visible).setValue(password);
        signInButton.click();
    }

    @Step("Авторизация пользователя только по логину {login} и БЕЗ пароля")
    public void authWithoutPassword(String login) {
        loginField.shouldBe(visible).click();
        loginField.shouldBe(visible).clear();
        loginField.shouldBe(visible).setValue(login);
        signInButton.click();
    }

    @Step("Авторизация пользователя только по паролю {password} и БЕЗ логина")
    public void authWithoutLogin(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).clear();
        passwordField.shouldBe(visible).setValue(password);
        signInButton.click();
    }

    @Step("Вводим Логин пользователя")
    public void setLogin(String login) {
        loginField.shouldBe(visible).click();
        loginField.shouldBe(visible).clear();
        loginField.shouldBe(visible).setValue(login);
    }

    @Step("Вводим Пароль пользователя")
    public void setPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).clear();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Кликаем по кнопке 'Войти в Одноклассники'")
    public void clickToLoginButton() {
        signInButton.click();
    }

    @Step("Проверяем видимость ошибки авторизации")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения о ошибке")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Открываем страницу восстановления пароля")
    public void openForgotPasswordPage() {
        troubleLoggingInButton.shouldBe(visible).click();
    }

    @Step("Открываем страницу Регистрации нового пользователя")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    // social button

    @Step("Логинимся по QrCode")
    public void loginWithQrCode() {
        enterByQrCodeButton.shouldBe(visible).click();
    }

    @Step("Логинимся по ByVk")
    public void loginWithVk() {
        registrationByVk.shouldBe(visible).click();
    }

    @Step("Логинимся по Mailru")
    public void loginWithMailru() {
        registrationByMailru.shouldBe(visible).click();
    }

    @Step("Логинимся по Yandex")
    public void loginWithYandex() {
        registrationByYandex.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Восстановить профиль")
    public void gotoRecovery() {
        recProfButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Вернуться к авторизации")
    public void returnToLoginPage() {
        returnToLoginPage.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Не получается войти?")
    public void gotoHelpDesc() {
        troubleLoggingInButton.click();
    }

    @Step("Вводим в поле поиск данные и жмем 'Enter'")
    public void search(String search) {
        searchInput.setValue(search);
        searchInput.pressEnter();
    }
}
