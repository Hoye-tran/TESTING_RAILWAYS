package Railway;

import Constant.Constant;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {
    //Locators
    //Elements
    //Methods
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }


}
