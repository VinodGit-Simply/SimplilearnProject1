package ExcelManger;

import Util.utility;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Util.utility.driver;

public class Excel {

    public static void main(String Args[]) throws IOException {

        ExcelManagerClass em = new ExcelManagerClass();


        em.getExcelTestData();

    }
}
