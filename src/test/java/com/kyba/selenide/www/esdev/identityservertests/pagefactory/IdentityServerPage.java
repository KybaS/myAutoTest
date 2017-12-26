package com.kyba.selenide.www.esdev.identityservertests.pagefactory;

import com.kyba.selenide.www.esdev.testconfig.ForAllPages;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IdentityServerPage extends ForAllPages {

    @Step
    public void goToIdentityServer() {
        $("#topmenu_93").click();
    }

    @Step
    public void companiesAndStoreLocationsClick() {
        $(".botbg>a[href=\"/idserver-idscompanies/\"]").click();
    }

    @Step
    public void addNewCompanyClick() {
        $(".add_link").click();
    }

    @Step
    public void assertAppearsNewCompanyInList(String companyName) {
        $$("#usersList").findBy(text(companyName)).shouldBe(visible);
    }

    @Step
    public void fillFieldCompName(String companyName) {
        $("#company_name").setValue(companyName).pressTab();
    }

    @Step
    public void clickButtonSave() {
        $(".button2[value=Save]").click();
    }
}

