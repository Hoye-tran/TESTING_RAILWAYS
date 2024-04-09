package Railway;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;


public class BookTicket extends GeneralPage {

    // Locators
    private final By _selectDate = By.xpath("//select[@name='Date']");
    private final By _selectDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By _selectArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By _selectSeatType = By.xpath("//select[@name='SeatType']");
    private final By _selectTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By _txtBookTickettoLoginPage = By.xpath("//a[@href='/Account/Login.cshtml']");

    // Methods
    public WebElement getSelectDate() {
        return Constant.WEBDRIVER.findElement(_selectDate);
    }

    public WebElement getSelectDepartStation() {
        return Constant.WEBDRIVER.findElement(_selectDepartStation);
    }

    public WebElement getSelectArriveStation() {
        return Constant.WEBDRIVER.findElement(_selectArriveStation);
    }

    public WebElement getSelectSeatType() {
        return Constant.WEBDRIVER.findElement(_selectSeatType);
    }

    public WebElement getSelectTicketAmount() {
        return Constant.WEBDRIVER.findElement(_selectTicketAmount);
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(_btnBookTicket);
    }

    public WebElement getBookTickettoLoginPage(){return Constant.WEBDRIVER.findElement(_txtBookTickettoLoginPage);}
    public HomePage bookticket(String date, String departStation, String arriveStation, String seatType, String ticketAmount) {
        // Selecting options
        Select selectDate = new Select(getSelectDate());
        selectDate.selectByVisibleText(date);

        Select selectDepartStation = new Select(getSelectDepartStation());
        selectDepartStation.selectByVisibleText(departStation);

        Select selectArriveStation = new Select(getSelectArriveStation());
        selectArriveStation.selectByVisibleText(arriveStation);

        Select selectSeatType = new Select(getSelectSeatType());
        selectSeatType.selectByVisibleText(seatType);

        Select selectTicketAmount = new Select(getSelectTicketAmount());
        selectTicketAmount.selectByVisibleText(ticketAmount);

        // Clicking on the book ticket button
        getBtnBookTicket().click();

        return new HomePage();
    }
    public LoginPage bookTickettologinPage(){
        return new LoginPage();
    }
    public void scrollDownToBookTicketButton() {
        WebElement bookTicketButton = Constant.WEBDRIVER.findElement(_btnBookTicket);

        // Scroll to the "Book Ticket" button
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", bookTicketButton);
    }

    public String bookTicket(String selectDepartDate, String selectDepartFrom, String selectArriveAt, String seatType, String ticketAmount) {
        selectDepartDate(selectDepartDate);
        selectDepartFrom(selectDepartFrom);
        selectArriveAt(selectArriveAt);
        selectSeatType(seatType);
        selectTicketAmount(ticketAmount);
        submitTicket();
        // Lưu trữ ID của vé
        setTicketID(Constant.WEBDRIVER.getCurrentUrl());
        return getTicketID();
    }

    private void submitTicket() {

    }

    private void selectTicketAmount(String ticketAmount) {
    }

    private void selectSeatType(String seatType) {
    }

    private void selectArriveAt(String selectArriveAt) {
    }

    private void selectDepartFrom(String selectDepartFrom) {
    }

    private void selectDepartDate(String selectDepartDate) {
    }

    public boolean comparedTicket(String departStation, String arriveStation, String seatType, String departDate, String amount, String ticketID) {
        WebElement table = Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']"));
        WebElement row = table.findElement(By.xpath("//tr[@class='OddRow']")); // Assuming there's only one row for simplicity

        String actualDepartStation = row.findElement(By.xpath("//td[1]")).getText();
        String actualArriveStation = row.findElement(By.xpath("//td[2]")).getText();
        String actualSeatType = row.findElement(By.xpath("//td[3]")).getText();
        String actualDepartDate = row.findElement(By.xpath("//td[4]")).getText();
        String actualAmount = row.findElement(By.xpath("//td[7]")).getText();
        // Assuming ID is in the first column
        String idInRow = row.findElement(By.xpath("//td[1]")).getText();
        return actualDepartStation.equals(departStation)
                && actualArriveStation.equals(arriveStation)
                && actualSeatType.equals(seatType)
                && actualDepartDate.equals(departDate)
                && actualAmount.equals(amount)
                && idInRow.equals(ticketID);
    }
    private String getIDFromUrl(String currentUrl) throws MalformedURLException {
        URL url = new URL(currentUrl);
        String query = url.getQuery();
        String[] params = query.split("&");
        for (String param : params) {
            String[] keyValue = param.split("=");
            if (keyValue.length == 4 && keyValue[0].equals("id")) {
                return keyValue[1];
            }
        }
        return null;
    }
    // Lưu trữ ID của vé
    private String ticketID;

    // Phương thức để lấy ID từ URL
    public void setTicketID(String currentUrl) {
        try {
            ticketID = getIDFromUrl(currentUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để lấy ID của vé
    public String getTicketID() {
        return ticketID;
    }

    //

}


