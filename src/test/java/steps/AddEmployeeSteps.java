package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;

public class AddEmployeeSteps extends CommonMethods {
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() throws IOException {
        sendText(ConfigReader.read("userName"),loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimOption.click();
    }
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployee = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployee.click();
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {

        sendText("Nathan", addEmployeePage.firstnameLocator);
        sendText("Smith", addEmployeePage.lastnameLocator);

    }
    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        addEmployeePage.saveButton.click();
    }
    @Then("employee added successfully")
    public void employee_added_successfully() throws InterruptedException {

        WebElement EmpNameLocator = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
        String addedName = EmpNameLocator.getAttribute("value");
        Assert.assertEquals(addedName, "Nathan");


    }

    @When("user enters employee ID")
    public void user_enters_employee_id() {
        WebElement empIdLocator = driver.findElement(By.xpath("//input[@id='employeeId']"));
        empIdLocator.clear();
        empIdLocator.sendKeys("11112229");

    }

    @Then("employee with employee id is added successfully")
    public void employee_with_employee_id_is_added_successfully() {
        WebElement EmpIDLocator = driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']"));
        String addedID = EmpIDLocator.getAttribute("value");
        Assert.assertEquals(addedID, "11112229");

    }

    @When("user enters firstname and and leaves lastname field empty")
    public void user_enters_firstname_and_and_leaves_lastname_field_empty() {
        sendText("Kevin", addEmployeePage.firstnameLocator);
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        WebElement errorText = driver.findElement(By.xpath("//span[text()='Required']"));
        String actualError = errorText.getText();
        Assert.assertEquals(actualError, "Required");
    }

    @When("user enters lastname and and leaves firstname field empty")
    public void user_enters_lastname_and_and_leaves_firstname_field_empty() {
        sendText("Bond", addEmployeePage.lastnameLocator);
    }


}
