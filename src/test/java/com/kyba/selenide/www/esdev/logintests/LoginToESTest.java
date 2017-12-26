package com.kyba.selenide.www.esdev.logintests;

import com.kyba.selenide.www.esdev.logintests.pagefactory.LoginPage;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class LoginToESTest extends LoginPage {

    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkLoginPage() {

        logout.click();
        checkTitleOfBrowserTab("Login Page");
        loginToES("ksv", "454545");
        buttonLoginClick();
        assertWrongLogin("Invalid login or password");

        loginToES("", "");
        buttonLoginClick();
        assertWrongLogin("Login or Password field is Empty or Login contains illegal characters");

        loginToES("admin", "password");
        assertLogo();
        assertDateTimeBlock();
        assertFooterCopyright("© Copyright 2009 – 2017 Evogence ®, All Rights Reserved");
        buttonLoginClick();

        assertLogo();
        assertDateTimeBlock();
        assertFooterCopyright("© Copyright 2009 – 2017 Evogence ®, All Rights Reserved");
        assertLogin("Logout");
    }
}

