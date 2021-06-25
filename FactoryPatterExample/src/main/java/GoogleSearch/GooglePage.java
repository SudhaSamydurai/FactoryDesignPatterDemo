package GoogleSearch;

public abstract class GooglePage {

	public abstract void launchPage();

	public abstract void search(String keyword);

	public abstract int getResultsCount();

}
