package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;
import java.time.Duration;

public class Login extends CommonMethods {

    @When("user leaves username field empty and enters correct password")
    public void user_leaves_username_field_empty_and_enters_correct_password() throws IOException {
        //username field is empty on purpose
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }
    @Then("error message {string} is displayed")
    public void error_message_is_displayed(String string) {
        WebElement errorMsg  = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualMsg = errorMsg.getText();

        Assert.assertEquals(actualMsg, "Username cannot be empty");
    }

    @When("user leaves password field empty and enters correct username")
    public void user_leaves_password_field_empty_and_enters_correct_username() throws IOException {
        sendText(ConfigReader.read("userName"),loginPage.usernameField);
    }

    @Then("error message {string} is shown")
    public void error_message_is_shown(String string) {
        WebElement errorMsg  = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualMsg = errorMsg.getText();

        Assert.assertEquals(actualMsg, "Password is Empty");
    }

    @When("user enters incorrect username and correct password")
    public void user_enters_incorrect_username_and_correct_password() throws IOException {
        loginPage.usernameField.sendKeys("julia");
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @Then("{string} error message is visible")
    public void error_message_is_visible(String string) {
        WebElement errorMsg  = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualMsg = errorMsg.getText();

        Assert.assertEquals(actualMsg, "Invalid credentials");
    }

    @Then("user enters correct username and password")
    public void user_enters_correct_username_and_password() throws IOException {
        sendText(ConfigReader.read("userName"),loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @Then("user is able to see {string}")
    public void user_is_able_to_see(String string) {
        WebElement actualMsg = driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualMessage = actualMsg.getText();

        Assert.assertEquals(actualMessage, "Welcome Admin");
    }



}
