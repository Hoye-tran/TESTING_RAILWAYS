package Railway;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ForgotPassword extends GeneralPage{
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _btnSendInstructions = By.xpath("//input[@value='Send Instructions']");

    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getBtnSendInstructions(){
        return Constant.WEBDRIVER.findElement(_btnSendInstructions);
    }
    public HomePage forgotpassword(String Email)
    {
        //Submit login credentials
        this.getTxtEmail().sendKeys(Email);
        this.scrollDownToSendEmailButton();
        this.getBtnSendInstructions().click();
//        this.getLblLoginErrorMsg();
        //Land on Home Page
        return new HomePage();
    }
    public void scrollDownToSendEmailButton() {
        WebElement SendemailButton = Constant.WEBDRIVER.findElement(_btnSendInstructions);

        // Scroll to the "Book Ticket" button
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", SendemailButton);
    }
}
