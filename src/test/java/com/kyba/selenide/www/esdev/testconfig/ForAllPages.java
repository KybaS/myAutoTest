package com.kyba.selenide.www.esdev.testconfig;

import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

public class ForAllPages extends BaseTest{

    @Step
    protected void checkTitleOfBrowserTab(String text){
        assertEquals(text, title());
    }

    @Step
    public void assertFooterCopyright(String text) {
        $("#page-footer").shouldHave(exactText(text));
    }

    @Step
    public void assertDateTimeBlock() {
        $(".current_date").shouldBe(visible);
    }
}
