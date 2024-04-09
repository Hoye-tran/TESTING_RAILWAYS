package Railway;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import Constant.Constant;
public class GeneralPage<BookTicket> {
    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessage = By.xpath("//p[@class = 'message error LoginForm']");
    private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    private final By txtForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");
    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private final By txtLinkBookTicket = By.xpath("//td[text()='Sài Gòn']/following-sibling::td/a[text()='book ticket']");
    private final By txtCreateSucceedAccount = By.xpath("//div[@id='content']");
    private final By txtSucceedCreateAccount = By.xpath("//div[@id ='content']");
    private final By txtBookTicketfromHuetoSGfromTabTimeTable = By.xpath("//tr[td[contains(text(),'Huế')] and td[contains(text(),'Sài Gòn')]]//a[contains(text(),'book ticket'");
      //Elements
    protected WebElement getTabLogin(){

        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabMyTicket(){
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }
    protected WebElement getTabChangePassword(){
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getTxtForgotPassword(){return Constant.WEBDRIVER.findElement(txtForgotPassword);}
    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getLblErrorMessage(){ return Constant.WEBDRIVER.findElement(lblErrorMessage);}
    protected WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    protected WebElement getTabTimeTable(){return Constant.WEBDRIVER.findElement(tabTimeTable);}
    protected WebElement getTxtLinkBookTicket(){return Constant.WEBDRIVER.findElement(txtLinkBookTicket);}
    protected WebElement getTxtCreateSucceedAccount(){return Constant.WEBDRIVER.findElement(txtCreateSucceedAccount);}
    protected WebElement getTxtBookTicketfromHuetoSGfromTabTimeTable(){

        return Constant.WEBDRIVER.findElement(txtBookTicketfromHuetoSGfromTabTimeTable);
    }

    //Methods
    public String getSucceedCreateAccount(){return this.getTxtCreateSucceedAccount().getText();}
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }
    public String getErrorMessage(){return this.getLblErrorMessage().getText();}

    public LoginPage gotoLoginPage()
    {
        this.getTabLogin().click();
        return new LoginPage();
    }
//    public BookTicket gotoBookTicket()
//    {
//        this.getTabBookTicket().click();
//        this.getTabLogin().click();
//        return new BookTicket();
//    }
    public MyTicket gotoMyTicket()
    {
        this.getTabMyTicket().click();
        return new MyTicket();
    }
    public ChangePassword gotoChangePassword()
    {
        this.getTabChangePassword().click();
        return new ChangePassword();
    }
    public Register gotoRegister()
    {
        this.getTabRegister().click();
        return new Register();
    }
    public ForgotPassword goforgotPassword()
    {
        this.getTxtForgotPassword().click();
        return new ForgotPassword();

    }
    public Railway.BookTicket gotoBookTicket()
    {
        this.getTabBookTicket().click();
        return new Railway.BookTicket();
    }

    public TimeTable gotoTimetable()
    {
        this.getTabTimeTable().click();
        return new TimeTable();
    }
    public Railway.BookTicket fromBookTickettoLoginPage()
    {
        this.getTabBookTicket().click();
        return new Railway.BookTicket();
    }
//    public String createaccount()
//    {
//        this.getTxtCreateAccount().getText();
//        return new
//    }
    public TimeTable clickbookticket()
    {
        this.getTxtBookTicketfromHuetoSGfromTabTimeTable().click();
        return new TimeTable();
    }

    public void getSelectDate(String formattedDepartDate) {

    }


}
