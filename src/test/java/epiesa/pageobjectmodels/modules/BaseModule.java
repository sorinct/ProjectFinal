package epiesa.pageobjectmodels.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseModule {
    protected WebDriver driver;

    public BaseModule(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
