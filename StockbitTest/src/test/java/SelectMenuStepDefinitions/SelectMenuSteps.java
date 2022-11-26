package SelectMenuStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectMenuSteps {
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

    @And("User choose select value {string}")
    public void userChooseSelectValue(String value) {
        driver.findElement(By.xpath("(//div[contains(@class, ' css-1wa3eu0-placeholder')])[1]")).click();

        List<WebElement> dropdownList = driver.findElements(By.xpath("//div[contains(@class, ' css-yt9ioa-option')]"));
        for(WebElement e : dropdownList){
            if(e.getText().equals(value)){
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,350)", "");
                e.click();
                break;
            }
        }
    }

    @And("User choose select one {string}")
    public void userChooseSelectOne(String title) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(@class, ' css-1wa3eu0-placeholder') and text() = 'Select Title']")).click();

        List<WebElement> dropdownList = driver.findElements(By.xpath("//div[contains(@class, ' css-yt9ioa-option')]"));
        for(WebElement e : dropdownList){
            if(e.getText().equals(title)){
                e.click();
                break;
            }
        }
    }

    @And("User choose old style select menu {string}")
    public void userChooseOldStyleSelectMenu(String color) {
        Select se = new Select(driver.findElement(By.xpath("//select[contains(@id, 'oldSelectMenu')]")));
        se.selectByVisibleText(color);
    }

    @And("User choose multi select drop down all color")
    public void userChooseMultiSelectDropDownAllColor() {
        driver.findElement(By.xpath("//div[contains(@class, ' css-1wa3eu0-placeholder') and text() = 'Select...']")).click();

        List<WebElement> dropdownList = driver.findElements(By.xpath("//div[contains(@id, 'react-select-4-option')]"));
        for(WebElement e : dropdownList){
            e.click();
        }
    }

    @Then("User success input all select menu")
    public void userSuccessInputAllSelectMenu() {
        driver.findElement(By.xpath("//div[contains(@class, ' css-1gl4k7y') and (text()= 'No options')]")).isDisplayed();
    }
}
