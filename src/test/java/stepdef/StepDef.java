package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class StepDef {

    WebDriver driver;

    @Given("User is on the SauceDemo login page")
    public void user_is_on_the_sauce_demo_login_page() {
        System.out.println("Inside Step - user is on login page");

        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opt = new FirefoxOptions();

        driver = new FirefoxDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        System.out.println("Inside Step - user enters valid username and password");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User clicks the login button")
    public void user_clicks_the_login_button() throws InterruptedException {
        System.out.println("Inside Step - user clicks the login button");

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
    }

    @Then("User is logged in successfully")
    public void user_is_logged_in_successfully() throws InterruptedException {
        System.out.println("Inside Step - user is logged in succesfully");

        Thread.sleep(2000);
        driver.close();
    }

    @And("User adds a product to the cart")
    public void user_adds_a_product_to_the_cart() {
        System.out.println("Inside Step - user adds a product to the cart");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("User's cart should contain the added product")
    public void user_s_cart_should_contain_the_added_product() throws InterruptedException {
        System.out.println("Inside Step - user's cart should contain the added products");

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);
        driver.close();
    }

    @When("User removes the product from the cart")
    public void user_removes_the_product_from_the_cart() throws InterruptedException {
        System.out.println("Inside Step - user removes the product from the cart");

        driver.findElement(By.name("remove-sauce-labs-backpack")).click();
        Thread.sleep(2000);
    }

    @Then("User's cart should be empty")
    public void user_s_cart_should_be_empty() throws InterruptedException {
        System.out.println("Inside Step - user's cart should be empty");

        Thread.sleep(2000);
        driver.close();
    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        System.out.println("Inside Step - user proceeds to checkout");

        driver.findElement(By.name("checkout")).click();
    }

    @Then("User reaches the checkout page")
    public void user_reaches_the_checkout_page() throws InterruptedException {
        System.out.println("Inside Step - user reaches the checkout page");

        Thread.sleep(2000);
        driver.close();
    }

    @When("User enters locked out username and password")
    public void user_enters_locked_out_username_and_password() {
        System.out.println("Inside Step - user enters locked out username and password");

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("password_sauce");
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() throws InterruptedException {
        System.out.println("Inside Step - user should see an error message");

        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        Thread.sleep(2000);
        driver.close();
    }
}