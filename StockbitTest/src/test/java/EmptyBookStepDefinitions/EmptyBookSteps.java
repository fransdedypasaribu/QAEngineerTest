package EmptyBookStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyBookSteps {
    WebDriver driver;
    @Given("User go to {string}")
    public void userGoTo(String url) throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(url);
        Thread.sleep(1000);
    }

    @When("User in {string} page")
    public void userInPage(String page) {
        driver.findElement(By.xpath("//div[contains(@class, 'main-header') and text() = '"+ page +"']")).isDisplayed();
    }

    @And("User search book {string}")
    public void userSearchBook(String booksName) {
        driver.findElement(By.xpath("//input[@id=\"searchBox\"]")).sendKeys(booksName);
    }

    @Then("User see {string}")
    public void userSee(String information) {
        driver.findElement(By.xpath("//div[contains(@class, 'rt-noData') and text() = 'No rows found']")).isDisplayed();
    }
}
