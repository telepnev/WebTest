package core.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends BasePage{
    protected ElementsCollection listSearchItems = $$("div .ucard-v");
    protected SelenideElement searchText = $("div .ucard-v");

    @Step("Проверяем что текст найден {text}")
    public void checkingThatTextWasFound(String text) {
        listSearchItems.shouldHave(sizeGreaterThan(0));
        searchText.shouldHave(text(text));
    }












}
