package GoogleSearch;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public class GoogleEnglish extends GooglePage {

	protected WebDriver driver;

	protected WebDriverWait wait;

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(name = "btnK")
	private WebElement searchBtn;

	@FindBy(css = "div.rc")
	private List<WebElement> results;

	GoogleEnglish(final WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void launchPage() {
		driver.get("https://www.google.com");
	}

	@Override
	public void search(String keyword) {
		for (char ch : keyword.toCharArray()) {
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
			this.searchBox.sendKeys(ch + "");
		}
		this.wait.until((d) -> this.searchBtn.isDisplayed());
		this.searchBtn.click();
	}

	@Override
	public int getResultsCount() {
		this.wait.until((d) -> this.results.size() > 1);
		return this.results.size();
	}

}
