import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YandexStartPage {

    private static final String URL = "https://yandex.ru/";

    private ChromeDriver driver;

    public YandexStartPage(ChromeDriver driver) {
        this.driver = driver;
        driver.get(URL);
    }

    public SearchResultPage search(String text) {
        WebElement search = driver.findElementByXPath("//*[@id=\"text\"]");
        search.sendKeys(text);
        driver.findElementByCssSelector("div.search2__button > button").click();
        return new SearchResultPage(driver);
            }
}
