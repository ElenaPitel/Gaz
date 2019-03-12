import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class TargetPage {

    private ChromeDriver driver;

    public TargetPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        JavascriptExecutor js = driver;
        return "complete".equals(js.executeScript("return document.readyState"));
    }
}
