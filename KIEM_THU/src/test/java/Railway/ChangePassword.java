package Railway;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ChangePassword extends GeneralPage {
    //Locators
    private final By _txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By _txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");

    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");
    public WebElement getTxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }
    public WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }

    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getBtnChangePassword(){
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }
    public HomePage changepassword(String currentPassword, String newPassword, String confirmPassword)
    {
        //Submit login credentials
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
//        this.getLblLoginErrorMsg();
        //Land on Home Page
        return new HomePage();
    }
}
