package com.kyba.selenide.www.esdev.abouttests;

import com.kyba.selenide.www.esdev.abouttests.pagefactory.AboutPage;
import com.kyba.selenide.www.esdev.logintests.pagefactory.LoginPage;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class AboutTest extends AboutPage {

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void aboutPopup() {

        clickToAbout();
        assertCopyrightAndWarningMessage("Warning!\n" +
                "This computer system is protected by copyright law and international treaties. Unauthorized reproduction or distribution of this system, or any portion of it, may result in severe civil and criminal penalties, and will be prosecuted to the maximum extent possible under the law.\n" +
                "© Copyright 2009 – 2017 Evogence ® , All Rights Reserved");
        assertFields("Version:", "Check For Update", "Serial Number:", "System ID:", "OS:", "Model:", "Edition:", "Max. Number of Registered Appliances:", "Registered Appliances Number:", "Max. Number of Registered Mobile Appliances:", "Registered Mobile Appliances Number:", "Uptime:", "Motherboard:", "Storage Capacity:", "RAM:", "CPU Load:", "HDD Utilization:");
        buttonClosePopupClick();
    }

    LoginPage pageLogin = new LoginPage();
}
