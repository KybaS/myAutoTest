package com.kyba.selenide.www.esdev.logintests.pagefactory;

import com.kyba.selenide.www.esdev.testconfig.ForAllPages;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends ForAllPages{

    @Step
    public void loginToES(String login, String password) {
        $("#login").setValue(login);
        $("#password").setValue(password);
    }

    @Step
    public void buttonLoginClick() {
        $(".button2").click();
    }

    @Step
    public void assertLogin(String available) {
        $(".logout").shouldHave(exactText(available));
    }

    @Step
    public void assertWrongLogin(String text) {
        $("#error_text").shouldHave(exactText(text));
    }

    @Step
    public void assertLogo() {
        $(".pt5.pb5.pl10>a>img").shouldBe(visible);
    }

}
