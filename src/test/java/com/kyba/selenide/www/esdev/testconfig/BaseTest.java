package com.kyba.selenide.www.esdev.testconfig;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {

    String login = "admin";
    String password = "password";
    protected SelenideElement logout = $(".logout");

    @Before
    @Step
    public void openAndLoginToEs3dev() {
        open("https://es3dev.evogence.com/");
        if (!logout.exists()) {
            $("#login").setValue(login);
            $("#password").setValue(password);
            $(".button2").click();
        } else {
            $(".logout").click();
        }
    }

    @After
    public void clearLocalStorage() {
        Selenide.executeJavaScript("localStorage.clear()");
    }

    @After
    public void clearCache() {
        clearBrowserCache();
    }

    @After
    public void clearCookieTest() {
        clearBrowserCookies();
    }

    @After
    public void tearDown() throws IOException {
        File lastSelenideScreenshot = Screenshots.getLastScreenshot();
        if (lastSelenideScreenshot != null) {
            screenshot(Files.toByteArray(lastSelenideScreenshot));
        }
    }

    @Attachment(type = "image/png")
    public static byte[] screenshot(byte[] dataForScreenshot) {
        return dataForScreenshot;
    }

}
