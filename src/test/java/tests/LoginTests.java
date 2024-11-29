package tests;

import core.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends BaseTest {

    @Test
    public void loginTest() {
        open(baseUrl);
        login("privedMeded", "12345678");


        System.out.println("");

    }
}
