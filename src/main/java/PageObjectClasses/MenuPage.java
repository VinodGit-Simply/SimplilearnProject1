package PageObjectClasses;

import Hooks.Hooks;
import Util.utility;
import WaitManager.WaitManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class MenuPage {


    Hooks hk ;
    WaitManager wm ;
    //utility ul ;

    public static  WebDriver driver;
    public String amount_due;
    public Double amount_dueValue;
    public  utility ul ;

    @FindBy (xpath="//h2[@class='typography-2 capitalize my-20 mx-10 text-center heading-hr']") WebElement focus;

   @FindBy  (xpath="//div[@class='typography-4 list-item__name flex-1 px-10 pt-10'][text()='Chicken Sausage']") WebElement ChickenSaucage;

    @FindBy (xpath="(//button[@class='button button--md button--green flex-1 font-semibold'])[18]") WebElement  Add_Pizza;

    //**** Basket Elements *** //


   @FindBy (xpath="//*[contains(text(),'Your Basket')]")    WebElement basket ;
   @FindBy (xpath = "//*[contains(text(),'Personal Chicken Sausage')]")  WebElement basket_pizza ;


   @FindBy (xpath="//*[@class='subtotal']")  WebElement SubTOTAL ;
   @FindBy (xpath="//*[@class='display-supplement-value']") WebElement RHC;
   @FindBy (xpath="(//div[@class='flex flex-col pt-15 bg-white']//span)[4]") WebElement Total_Tax;
   @FindBy (xpath="//span[@class='amountdue']") WebElement Amount_Due;

   @FindBy (xpath = "//span[@class='bg-green-dark pl-5 pr-5 rounded']") WebElement Item_count;


    public  MenuPage(WebDriver driver){

        this.driver = driver;
        ul = new utility(driver);
        wm = new WaitManager(driver);
        PageFactory.initElements(driver,this);
    }



    //When ("^User select add button of any pizza from Recommended$")
    public void add_Pizza() throws InterruptedException {

        ul.ScrolltoElement(focus);
        wm.Sleep(1000);
                ul.ScrolltoElement(ChickenSaucage);

        ul.ScrolltoElement(Add_Pizza);
        Add_Pizza.click();
        //pizza.click();
    }

    //Then("^User see that the pizza is getting added under Your Basket$")
    public void validate_AddPizaa(){

        wm.wait_implicit(Duration.ofSeconds(2));

        ul.moveToElement(basket);
        ul.moveToElement(basket_pizza);
        System.out.println("Pizza added -->"+basket_pizza.isDisplayed());
        wm.wait_implicit(Duration.ofSeconds(2));
    }

    //And("^User validate pizza price plus Tax is checkout price$")
    public void validate_PizzaPrice(){

        ul.moveToElement(SubTOTAL);
        String subtotal = SubTOTAL.getText().toString();
        subtotal = subtotal.substring(1,subtotal.length());
        Double subtotal_value = Double.parseDouble(subtotal);
        // Double subtotal_value = (double) Integer.parseInt(subtotal);
        Double restaraunt_handling_charges;
        try {
            String rhc = RHC.getText().toString();
            rhc = rhc.substring(1, rhc.length());
            restaraunt_handling_charges = Double.parseDouble(rhc);
        }catch(Exception e){
            restaraunt_handling_charges = 0.0;
            System.out.println("restaurant handling carges are not present and hence it is made ZERO ..");
        }
        String total_tax = Total_Tax.getText().toString();
        total_tax = total_tax.substring(1,total_tax.length());
        Double tax =  Double.parseDouble(total_tax);

        Double total_due = (subtotal_value+restaraunt_handling_charges+tax);

        amount_due = Amount_Due.getText();
        amount_due = amount_due.substring(1,amount_due.length());
        amount_dueValue = Double.parseDouble(amount_due);

        System.out.println("AmountDue on the Web ->"+amount_dueValue+"  "+"Total Due Calculated -->"+total_due);



    }

    //Then ("^User validate checkout button contains Item count$")
    public  void  validate_checkout_Button_itemcount() throws InterruptedException {

        Item_count.isDisplayed();
        String itemcount1 = Item_count.getText().toString();
        System.out.println(" item count is displayed -->" + itemcount1.contains("item"));
        wm.Sleep(2000);
    }


    @FindBy (xpath="//span[@class='ml-auto text-right']/span")  WebElement Checkout_Price ;

   // @And ("^User validate checkout button contains total price count$")
    public void validate_checkout_totalPrice(){


        String CheckoutPrice = Checkout_Price.getText().toString();

        System.out.println( "CheckOut Button has value ->"+ CheckoutPrice + "total amount due calculated ->"+ amount_dueValue);


    }

    @FindBy (xpath="//button[@class='basket-upsell-carousel-scroll-btn basket-upsell-carousel-right-btn']") WebElement Scroll_Drink;

    //@Then ("^User clicks on Drinks option$")
    public void validate_clickDrink() throws InterruptedException {


        wm.wait_implicit(Duration.ofSeconds(1));
        Scroll_Drink.click();
        wm.Sleep(2000);
        driver.findElement(xpath("//button[@class='basket-upsell-carousel-scroll-btn basket-upsell-carousel-right-btn']")).click();
        wm.wait_implicit(Duration.ofSeconds(1));



    }

    @FindBy (xpath = "//*[@class='basket-upsell-carousel-container']") WebElement Pepsi_Hover;
    @FindBy (xpath="//*[contains(text(),'Pepsi - 475ml')]") WebElement Add_Pepsi;

    @FindBy (xpath="//*[contains(text(),'Your Basket')]") WebElement Basket;
    @FindBy (xpath = "//*[contains(text(),'Pepsi - 475ml')]") WebElement Pepsi_Refocus;
  //  @And ("^User select Pepsi option to add into the Basket$")
    public void select_Pepsi(){
        ul.moveToElement(Pepsi_Hover);
        wm.wait_implicit(Duration.ofSeconds(2));
        Add_Pepsi.click();

        wm.wait_implicit(Duration.ofSeconds(2));

        ul.moveToElement(Basket);
        wm.wait_implicit(Duration.ofSeconds(1));

        ul.ScrolltoElement(Pepsi_Refocus);
        wm.wait_implicit(Duration.ofSeconds(1));
        System.out.println("is Pepsi Displayed -->"+ Pepsi_Refocus.isDisplayed() + "value of item :"+ Pepsi_Refocus.getText());




    }

    @FindBy (xpath="//span[@class='bg-green-dark pl-5 pr-5 rounded']") WebElement items_verify;

   // @Then ("^User see 2 items are showing under checkout button$")
    public void validate_checkout_2Items(){



        if (items_verify.getText().toString().equals("2 items")){
            System.out.println("Checkout item Count :->" + items_verify.getText().toString());
        }


    }


    @FindBy (xpath="//span[@class='ml-auto text-right']/span") WebElement Checkout_Price2;

    //@And ("^User see total price is now more than before$")
    public void total_Price_MoreThan(){



        String CheckoutPrice2 = Checkout_Price2.getText().toString();
        CheckoutPrice2 = CheckoutPrice2.substring(1,CheckoutPrice2.length());

        Double CheckoutPrice2_Value = Double.parseDouble(CheckoutPrice2);

        if (CheckoutPrice2_Value > amount_dueValue) {
            System.out.println("CheckOut Button has new value ->" + CheckoutPrice2_Value + "total amount due calculated previously which was ->" + amount_dueValue);
        }

    }


    @FindBy ( xpath="//*[contains(text(),'Your Basket')]" ) WebElement Basket_Recheck;
    @FindBy ( xpath="//*[@class='basket-item-product-edit-button absolute inset-0 cursor-pointer screenreader-only']") WebElement pizza_recheck;

    @FindBy (xpath="(//button[@class='icon-close relative opacity-25 text-grey ml-10 p-10'])[1]") WebElement remove_pizza;

    //@Then ("^User remove the Pizza item from Basket$")
    public void Remove_PizzaItem() throws InterruptedException {

        wm.wait_implicit(Duration.ofSeconds(2));
        ul.moveToElement(Basket_Recheck);
        wm.Sleep(1000);

        ul.ScrolltoElement(pizza_recheck);

        ul.ScrolltoElement(remove_pizza);
        remove_pizza.click();
    }

    //@And ("^see Price tag got removed from the checkout button$")
    public void remove_PriceTage(){

        //WebElement Checkout_PriceTAg = driver.findElement(By.xpath("//span[@class='ml-auto text-right']/span"));
        wm.WaitforElementNotVisible(xpath("//span[@class='ml-auto text-right']/span"));

        //dm.wm.waitforInvisibility(Checkout_PriceTAg);
    }



  @FindBy (xpath="//span[@class='bg-green-dark pl-5 pr-5 rounded']")  WebElement item_count;
    //  @And ("^User see 1 item showing in checkout button$")
    public void validate_OneItem() throws InterruptedException {


        item_count.isDisplayed();
        String itemcount1 = item_count.getText().toString();
        System.out.println(" item count is displayed -->" + itemcount1.contains("1 item"));
        wm.Sleep(2000);

    }



    @FindBy (xpath="(//span[@class='absolute inset-0 flex-center']/span)[2]") WebElement Check_Out;

    //@Then ("^User Clicks on Checkout button$")
    public void click_Checkout(){
        Check_Out.click();
        wm.wait_implicit(Duration.ofSeconds(1));


    }


    @FindBy (xpath="//*[contains(text(),'minimum delivery spend')]") WebElement Order_error_message;
    //@And ("^User see minimum order required pop up is getting displayed$")
    public void min_OrderRequired(){

        wm.wait_implicit(Duration.ofSeconds(1));
        System.out.println("The order delivery error message upon clicking on CHECKOUT button"+Order_error_message);
    }




}
