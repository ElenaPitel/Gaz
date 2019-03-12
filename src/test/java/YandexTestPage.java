import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class YandexTestPage {

    private static final String DRIVER_NAME = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "src\\test\\resources\\chromedriver.exe";
    private static final String TEXT = "Газинформсервис";
    private static final String SITE = "gaz-is.ru";
    private ChromeDriver driver;

    @Before
        public void init(){
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch(){
        YandexStartPage yandexStartPage = new YandexStartPage(driver);
        SearchResultPage searchResultPage = yandexStartPage.search(TEXT);
        TargetPage target = searchResultPage.goToTargetLink(SITE);
        assertNotNull(target);
        assertTrue(target.isLoaded());
    }
}