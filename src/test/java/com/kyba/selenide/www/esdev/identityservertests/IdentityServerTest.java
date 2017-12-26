package com.kyba.selenide.www.esdev.identityservertests;

import com.kyba.selenide.www.esdev.identityservertests.pagefactory.IdentityServerPage;
import com.kyba.selenide.www.esdev.logintests.pagefactory.LoginPage;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static com.codeborne.selenide.Selenide.$;

public class IdentityServerTest extends IdentityServerPage {

    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void addCompany() throws InterruptedException {

        goToIdentityServer();

        companiesAndStoreLocationsClick();
        Thread.sleep(2000);
        addNewCompanyClick();

        fillFieldCompName(UniqueCompanyName);
        clickButtonSave();

        assertAppearsNewCompanyInList(UniqueCompanyName);
    }

//    @Severity(SeverityLevel.CRITICAL)
//    @Test
//    public void editCompany() throws InterruptedException {
//        openEs3dev();
//        logPage.loginToES("admin", "password");
//        logPage.buttonLoginClick();
//
//        idServerPage.goToIdentityServer();
//
//        idServerPage.companiesAndStoreLocationsClick();
//        Thread.sleep(2000);
//        $x(".//td[2]/div[.='Evogence']").hover().findElementByXPath("//td[4]/div/a[1]/img").click();
//        Thread.sleep(5000);
//    }

    String unique = "" + System.currentTimeMillis();
    String UniqueCompanyName = "WWW" + unique;

    LoginPage logPage = new LoginPage();
}
