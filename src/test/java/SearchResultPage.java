import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchResultPage {

    private ChromeDriver driver;

    public SearchResultPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public TargetPage goToTargetLink(String site) {
        List<WebElement> searchResults = driver.findElementsByClassName("path");
        for (WebElement element : searchResults) {
            if (element.getText().contains(site)) {
                element.click();
                return new TargetPage(driver);
            }
        }
        return null;
    }
}
