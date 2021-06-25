package GoogleSearch;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

public class GoogleFactory {

	private static final Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();
	private static final Function<WebDriver, GooglePage> ENG = (d) -> new GoogleEnglish(d);
	private static final Function<WebDriver, GooglePage> FRE = (d) -> new GoogleFrench(d);
	private static final Function<WebDriver, GooglePage> ES = (d) -> new GoogleES(d);
	private static final Function<WebDriver, GooglePage> AR = (d) -> new GoogleArabic(d);

	static {
		MAP.put("ENG", ENG);
		MAP.put("FRE", FRE);
		MAP.put("ES", ES);
		MAP.put("AR", AR);
	}

	public static GooglePage get(String language, WebDriver driver) {
		return MAP.get(language).apply(driver);
	}
}
