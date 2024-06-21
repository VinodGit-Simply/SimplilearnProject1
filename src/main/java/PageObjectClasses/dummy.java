package PageObjectClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class dummy {


     @FindBy (xpath="//*[@class='subtotal']") WebElement  SubTOTAL;
     @FindBy (xpath = "//*[@class='display-supplement-value']") WebElement RHC;
     @FindBy (xpath="//div[@class='flex flex-col pt-15 bg-white']//span)[4]") WebElement Total_Tax;
@FindBy (xpath="//span[@class='amountdue']") WebElement Amount_Due;


}
