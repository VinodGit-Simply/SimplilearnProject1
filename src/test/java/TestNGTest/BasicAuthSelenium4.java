package TestNGTest;




    public class BasicAuthSelenium4 {
/**
  driver.get(“https://the-internet.herokuapp.com/basic_auth”);
        ChromeDriver driver;


       // @BeforeTest


        public void setup() {


            // Setup Chrome driver


            WebDriverManager.chromedriver().setup();


            driver = new ChromeDriver();


            driver.manage().window().maximize();


            driver.manage().timeouts().implicitlyWait(30, SECONDS);


            // Authentication username & password


            String username = “admin”;


            String password = “admin”;


            // Get the devtools from the running driver and create a session


            DevTools devTools = driver.getDevTools();


            devTools.createSession();


            // Enable the Network domain of devtools


            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));


            String auth = username + “:” + password;


            // Encoding the username and password using Base64


            String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());


            System.out.println(“Encoded String: ” + encodeToString);


            // Pass the network header as Authorization : Basic <encoded String>


            Map<String, Object> headers = new HashMap<>();


            headers.put(“Authorization”, “Basic ” + encodeToString);


            devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));


        }


    //    @Test


        public void launch() {


            driver.get(“https://the-internet.herokuapp.com/basic_auth”);


            String text = driver.findElement(By.cssSelector(“div.example p”)).getText().trim();


            Assert.assertEquals(text, “Congratulations! You must have the proper credentials.”);


        }



     //   @AfterTest


        public void tearDown() {


            driver.quit();


        }



**/


}
