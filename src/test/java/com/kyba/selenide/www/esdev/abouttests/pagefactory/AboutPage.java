package com.kyba.selenide.www.esdev.abouttests.pagefactory;

import com.kyba.selenide.www.esdev.testconfig.BaseTest;
import com.kyba.selenide.www.esdev.testconfig.ForAllPages;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AboutPage extends ForAllPages {

    @Step
    public void clickToAbout() {
        $(".about_block").click();
    }

    @Step
    public void buttonClosePopupClick() {
        $(".popup_close").click();
    }

    @Step
    public void assertCopyrightAndWarningMessage(String text) {
        $(".bold.pt10").shouldHave(exactText(text));
    }

    @Step
    public void assertFields(String... texts) {
        $$(".alignR.gray_mix").shouldHave(exactTexts(texts));
    }
}
