package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends GeneralPage {
    //Locators
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPid = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//input[@value='Register']");
  //Elements
    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getTxtPid(){
        return Constant.WEBDRIVER.findElement(_txtPid);
    }
    public WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    public HomePage register(String email, String password, String confirmPassword,String pid ){
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPid().sendKeys(pid);
        this.getBtnRegister().click();
//        this.getLblLoginErrorMsg();
        //Land on Home Page
        return new HomePage();
    }
}
