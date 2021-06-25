package DesignPattern.FactoryPatterExample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GoogleSearch.GoogleFactory;
import GoogleSearch.GooglePage;

public class GoogleSearchTest extends BaseTest {

	private GooglePage googlepage;

	@Test(dataProvider = "getData")
	public void searchTest(String language, String searchKeyword) {
		this.googlepage = GoogleFactory.get(language, this.driver);
		this.googlepage.launchPage();
		this.googlepage.search(searchKeyword);
		int resultCount = this.googlepage.getResultsCount();
		System.out.println("Result Count : " + resultCount);
	}

	@DataProvider(name = "getData")
	public Object[][] getData() {
		return new Object[][] { { "ENG", "Selenium" }, { "FRE", "Design Patters" }, { "ES", "Docker" },
				{ "AR", "Kubernates" } };
	}

}
