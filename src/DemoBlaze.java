
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

    public class DemoBlaze {
        public WebDriver driver;
        @Test(priority = 1)
        @Parameters({"url","browser"})
        public void browser(String url, String browser) {
            if (url.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\mongasourav\\Downloads\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get(browser);
                driver.manage().window().maximize();
            }
            else if(url.equalsIgnoreCase("opera") ){
                System.setProperty("webdriver.opera.driver", "C:\\Users\\mongasourav\\Downloads\\operadriver_win64\\operadriver.exe");
                driver = new OperaDriver();
                driver.get(browser);
                driver.manage().window().maximize();

            }
        }
        @Test(priority = 2)
        @Parameters({"usrid","paswd"})
        public void signIn(String usrid ,String paswd) throws InterruptedException{
            Thread.sleep(1000);
            WebElement signInButton= driver.findElement(By.id("login2"));
            signInButton.click();
            Thread.sleep(1000);
            WebElement userId= driver.findElement(By.id("loginusername"));
            userId.sendKeys(usrid);

            //JavascriptExecutor  js = (JavascriptExecutor)driver;
            // js.executeScript("arguments[0].scrollIntoView()",userId);

            WebElement password= driver.findElement(By.id("loginpassword"));
            password.sendKeys(paswd);
            WebElement loginButton= driver.findElement(By.xpath("//button[@onclick='logIn()']"));
            loginButton.click();

        }
        @Test(priority = 3)
        public void selectitem() throws InterruptedException{
            Thread.sleep(2000);
            WebElement deviceSelect=driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s6')]"));
            //  JavascriptExecutor  js = (JavascriptExecutor)driver;
            // js.executeScript("arguments[0].scrollIntoView()",deviceSelect);
            deviceSelect.click();
        }
        @Test(priority = 4)
        public void addToCart() throws InterruptedException{
            Thread.sleep(2000);
            WebElement addCartButton= driver.findElement(By.cssSelector("a[onclick='addToCart(1)']"));
            addCartButton.click();
            Thread.sleep(1000);
            driver.switchTo().alert().accept();
        }
        @Test(priority = 5)
        public void placeOrder() throws InterruptedException{
            WebElement cartButton= driver.findElement(By.id("cartur"));
            cartButton.click();
            Thread.sleep(1000);
            WebElement placeOrderbutton=driver.findElement(By.cssSelector("button[data-toggle='modal']"));
            placeOrderbutton.click();

        }
        @Test(priority = 6)
        @Parameters({"name","creditCrd"})

        public void customerDetails(String name,String creditCrd)throws InterruptedException{
            Thread.sleep(1000);
            WebElement customerName= driver.findElement(By.id("name"));
            customerName.sendKeys(name);
            WebElement creditCard=driver.findElement(By.id("card"));
            creditCard.sendKeys(creditCrd);
            WebElement purchaseButton= driver.findElement(By.cssSelector("button[onclick='purchaseOrder()']"));
            purchaseButton.click();
            Thread.sleep(1000);
            WebElement okButton= driver.findElement(By.cssSelector(".confirm.btn.btn-lg.btn-primary"));
            okButton.click();
        }
        @Test(priority = 7)
        public void logOut()throws InterruptedException{
            Thread.sleep(1000);
            WebElement logOutButton= driver.findElement(By.id("logout2"));
            logOutButton.click();
        }

    }

