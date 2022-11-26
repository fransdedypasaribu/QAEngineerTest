package BookStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookSteps {
    WebDriver driver;

    private static String title;
    private static String author;
    private static String publisher;

    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getPublisher(){
        return this.publisher;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }



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
    @And("User click book {string}")
    public void userClickBook(String bookTitle) {

        String title1 = driver.findElement(By.linkText(bookTitle)).getText();
        String author1 = driver.findElement(By.xpath("(//div[contains(@role,'gridcell')])[3]")).getText();
        String publisher1 = driver.findElement(By.xpath("(//div[contains(@role,'gridcell')])[4]")).getText();

        BookSteps bookSteps2 = new BookSteps();
        bookSteps2.setTitle(title1);
        bookSteps2.setAuthor(author1);
        bookSteps2.setPublisher(publisher1);

        driver.findElement(By.linkText(bookTitle)).click();
    }

    @Then("User see {string}")
    public void userSee(String information) {
        driver.findElement(By.xpath("//label[contains(@id, 'userName-value') and text() = '" + information + "']")).isDisplayed();

        String title2 = driver.findElement(By.xpath("(//label[contains(@id,'userName-value')])[2]")).getText();
        String author2 = driver.findElement(By.xpath("(//label[contains(@id,'userName-value')])[4]")).getText();
        String publisher2 = driver.findElement(By.xpath("(//label[contains(@id,'userName-value')])[5]")).getText();

        BookSteps bookSteps = new BookSteps();

        System.out.println("Title, Author, nad Publisher before click : ");
        System.out.println(bookSteps.getTitle());
        System.out.println(bookSteps.getAuthor());
        System.out.println(bookSteps.getPublisher());

        System.out.println("Title, Author, nad Publisher after clicked : ");
        System.out.println(title2);
        System.out.println(author2);
        System.out.println(publisher2);

        Assert.assertEquals(bookSteps.getTitle(), title2);
        Assert.assertEquals(bookSteps.getAuthor(), author2);
        Assert.assertEquals(bookSteps.getPublisher(), publisher2);
    }
}
