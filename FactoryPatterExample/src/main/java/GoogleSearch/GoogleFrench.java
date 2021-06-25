package GoogleSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleFrench extends GoogleEnglish {

	@FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
	private WebElement language;

	GoogleFrench(WebDriver driver) {
		super(driver);
	}

	@Override
	public void launchPage() {
		this.driver.get("https://www.google.fr");
		this.language.click();
	}
}
