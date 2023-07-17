//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package config;

import com.codeborne.selenide.Configuration;

public class WebDriverConfig {
    protected WebDriverConfig() {
    }

    static {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.fastSetValue = false;
        Configuration.timeout = 5000L;
    }
}