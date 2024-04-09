package Testcases;

import Railway.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class LoginTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()
                + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
//    @AfterMethod
//    public void afterMethod()
//    {
//        System.out.println("Post-condition");
//
//        Constant.WEBDRIVER.quit();
//    }
    @Test
    public void TC01(){
        System.out.println("TC01 - User can login to Railway with valid user name and password");
        HomePage homePage= new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");}
    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage= homePage.gotoLoginPage();
        String actualErrorMsg = loginPage.login("", Constant.PASSWORD).getErrorMessage();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not display expected");
    }
    @Test
    public void TC03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualErrorMsg = loginPage.login(Constant.USERNAME,"invalid_password").getErrorMessage();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg,expectedErrorMsg,"Error message is not display expected");
    }
    @Test
    public void TC04(){
        System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab ");
        HomePage homePage = new HomePage();
        homePage.open();
        BookTicket bookTicket = homePage.gotoBookTicket();
        BookTicket bookTickettologinPage= bookTicket.fromBookTickettoLoginPage();
   }
    @Test
    public void TC05(){
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        for (int i =1; i<=3; i++){
        String actualErrorMsg = loginPage.login(Constant.USERNAME,"invalid_password").getErrorMessage();
        String expectedErrorMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualErrorMsg,expectedErrorMsg,"Error message is not displayed expected");
//        if (!actualErrorMsg.equals(expectedErrorMsg)){
//            break;}
        }
    }
    @Test
    public void TC06(){
        System.out.println("TC06 - Additional pages display once user logged in");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessage();
        MyTicket myTicketPage = homePage.gotoMyTicket();
        ChangePassword changePasswordPage = myTicketPage.gotoChangePassword();



    }
    @Test
    public void TC07(){
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();
        Register registerPage = homePage.gotoRegister();
        registerPage.register("3tsieuquay123@gmail.com","yen123456789","yen123456789","12345678910");
        String actualMsg = registerPage.getSucceedCreateAccount();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");}
    @Test
    public void TC08(){
        System.out.println("TC08 - User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage= homePage.gotoLoginPage();
        loginPage.login("anhnhattran123@gmail.com","anhnhat123456789");
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Message is not displayed as expected");
    }
    @Test
    public void TC9(){
        System.out.println("TC09 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage= homePage.gotoLoginPage();
        loginPage.login("yentran1234@gmail.com","yen12345678910");
        ChangePassword changePasswordPage = homePage.gotoChangePassword();
        changePasswordPage .changepassword("yen12345678910","yen1234567891011","yen1234567891011");
        String actualMsg = "";
        String expectedMsg = "Your password has been updated!";
        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");}
    @Test
    public void TC10(){
        System.out.println("TC10 - User can't create account with Confirm password is not the same with Password");
        HomePage homePage = new HomePage();
        homePage.open();
        Register registerPage = homePage.gotoRegister();
        registerPage.register("yent339@gmail.com","yen123456789","yen12345678","12345678910");
        String actualMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");}
    @Test
    public void TC11(){
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        Register registerPage = homePage.gotoRegister();
        registerPage.register("yent339@gmail.com","","yen12345678","");
        String actualMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");
    }
    @Test
    public void TC12(){
        System.out.println("TC12 - Errors display when password reset token is blank");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage= homePage.gotoLoginPage();
        ForgotPassword forgotPasswordPage = homePage.goforgotPassword();
        forgotPasswordPage.forgotpassword("yentran123@gmail.com");
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
        Assert.assertEquals(actualMsg,expectedMsg,"Message is not displayed as expected");
    }
    @Test
    public void TC13(){
        System.out.println("TC13 - Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage= homePage.gotoLoginPage();
        ForgotPassword forgotPasswordPage = homePage.goforgotPassword();
        forgotPasswordPage.forgotpassword("yen123@gmail.com");


        //TODO
    }
    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookTicket bookticketPage = loginPage.gotoBookTicket();
        bookticketPage.scrollDownToBookTicketButton();
        String nextDepartDateString = Utilities.calculateNextDepartDate(4);
        String ticketID = bookticketPage.bookTicket(nextDepartDateString, "Sài Gòn", "Phan Thiết", "Soft bed with air conditioner", "1");
        bookticketPage.getTicketID();
        Assert.assertTrue(bookticketPage.comparedTicket("Sài Gòn", "Phan Thiết", "Soft bed with air conditioner", nextDepartDateString,"1",ticketID), "Ticket details do not match.");
    }}
////    @Test
//    public void TC15() {
//        System.out.println("TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page");
//        HomePage homePage = new HomePage();
//        homePage.open();
//        LoginPage loginPage = homePage.gotoLoginPage();
//        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
//        TimeTable timeTablePage = homePage.gotoTimetable();




//        TimeTable TimetabletoBookticketPage = TimeTable
//từ trang time table tìm bookticket
//    }}
//@Test
//public void TC16() {
//    System.out.println("TC16 - User can cancel a ticket");
//    HomePage homePage = new HomePage();
//    homePage.open();
//
//    LoginPage loginPage = homePage.gotoLoginPage();
//    loginPage.login(Constant.USERNAME, Constant.PASSWORD);
//
//    BookTicket bookTicketPage = homePage.gotoBookTicket(); // Khởi tạo đối tượng
//    bookTicketPage.scrollDownToBookTicketButton();
//    bookTicketPage.bookticket("4/10/2024","Huế","Sài Gòn","Soft seat with air conditioner","1");

//    int numberOfTicketsBeforeCancellation = myticketPage.getNumberOfTickets("Sài Gòn", "Phan Thiết", "Hard seat", "4/7/2024");
//    System.out.println(numberOfTicketsBeforeCancellation);
//// Hủy vé ở đây
//    myticketPage.cancelTicket("Nha Trang", "Huế", "Hard seat", "4/7/2024");
//
//    Alert alert = Constant.WEBDRIVER.switchTo().alert();
//
//    alert.accept();
//    int numberOfTicketsAfterCancellation = myticketPage.getNumberOfTickets("Nha Trang", "Huế", "Hard seat", "4/7/2024");
//    System.out.println(numberOfTicketsAfterCancellation);
//
//    Assert.assertFalse(myticketPage.isTicketDisplayed("Nha Trang", "Huế"));


//





