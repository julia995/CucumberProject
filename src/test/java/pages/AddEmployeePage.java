package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class  AddEmployeePage extends CommonMethods {
    @FindBy(id = "firstName")
    public WebElement firstnameLocator;

    @FindBy(id = "middleName")
    public WebElement middlenameLocator;

    @FindBy(id = "lastName")
    public WebElement lastnameLocator;

    @FindBy(xpath = "//input[@name='employeeId']")
    public WebElement employeeID;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@for='firstName']")
    public WebElement firstNameErrorMsg;

    @FindBy(xpath = "//span[@for='lastName']")
    public WebElement lastNameErrorMsg;

    @FindBy(xpath = "//span[@for='user_name']")
    public WebElement userNameErrorMsg;

    @FindBy(xpath = "//span[@for='user_password']")
    public WebElement userPasswordErrorMsg;

    @FindBy(xpath = "//div[@class='message warning fadable']")
    public WebElement existingEmpIdErrorMsg;


    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    public String addEmployeeErrorMessage(String inputField) {

        String errorMessage = switch (inputField) {
            case "firstName" -> firstNameErrorMsg.getText();
            case "lastName" -> lastNameErrorMsg.getText();
            case "userName" -> userNameErrorMsg.getText();
            case "password" -> userPasswordErrorMsg.getText();
            default -> null;
        };
        return errorMessage;
    }
}
