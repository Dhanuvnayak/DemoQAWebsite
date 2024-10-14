package Elements;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Text_Box {
    static WebDriver driver;
   static  JavascriptExecutor js ;
    public static void textBox() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        driver.findElement(By.id("item-0")).click();
        driver.findElement(By.id("userName")).sendKeys("dhanu");
        Thread.sleep(1000);
        driver.findElement(By.id("userEmail")).sendKeys("dhanu@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("currentAddress")).sendKeys("#123 abcd");
        Thread.sleep(1000);
        driver.findElement(By.id("permanentAddress")).sendKeys("908 gnbvh");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)","");
        driver.findElement(By.id("submit")).click();
    }
    public static void displayDetails(){
        List< WebElement> list  = driver.findElements(By.xpath("//*[@id=\"output\"]/div"));
        for(WebElement l:list)
            System.out.println(l.getText());
    }
    public static void checkBox() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)","");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        driver.findElement(By.id("item-1")).click();
        js.executeScript("window.scrollBy(0,300)","");
        Thread.sleep(2000);
      WebElement select = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
      select.click();
      select.sendKeys(Keys.ARROW_RIGHT);
      select.sendKeys(Keys.DOWN);
      WebElement chkBox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[1]"));
      if(chkBox.isSelected()==false)
          chkBox.click();
      chkBox.isEnabled();

    List<WebElement> list = driver.findElements(By.id("result"));
    for(WebElement w:list)
    System.out.println(w.getText());
    }
   public static void radiButton() throws InterruptedException {
       js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,-250)","");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        driver.findElement(By.id("item-2")).click();
       js.executeScript("window.scrollBy(0,300)","");
       Thread.sleep(2000);
       WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/label"));
       System.out.println(radio1.isDisplayed());
       System.out.println(radio1.isEnabled());
       WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(radio1)).click();
       List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/p"));
               for(WebElement w:list)
                   System.out.println(w.getText());
    }
    public static void webTableAdd() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)","");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        driver.findElement(By.id("item-3")).click();
        js.executeScript("window.scrollBy(0,300)","");
        driver.findElement(By.id("addNewRecordButton")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div")));
        driver.findElement(By.cssSelector("[placeholder=\"First Name\"][id=\"firstName\"]")).sendKeys("Mary");
        driver.findElement(By.cssSelector("[placeholder=\"Last Name\"][id=\"lastName\"]")).sendKeys("Jorge");
        driver.findElement(By.cssSelector("[placeholder=\"name@example.com\"][id=\"userEmail\"]")).sendKeys("mary@gmail.com");
        driver.findElement(By.cssSelector("[placeholder=\"Age\"][id=\"age\"]")).sendKeys("35");
        driver.findElement(By.cssSelector("[placeholder=\"Salary\"][id=\"salary\"]")).sendKeys("500");
        driver.findElement(By.cssSelector("[placeholder=\"Department\"][id=\"department\"]")).sendKeys("ABCD");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.submit();
        Thread.sleep(2000);
        List<WebElement> headers = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[1]/div/div"));
        for(WebElement h: headers)
            System.out.print(h.getText()+" ");
        System.out.println();
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div"));
        System.out.println("total no of rows: " + rows.size());
        Random r = new Random();// to get random row data
        int i = r.nextInt(4);
        System.out.println(rows.get(i).getText()+" ");
        for (int x = 0; x<4;x++){
            System.out.println(rows.get(x).getText());
        }
    }
    public static void webTableEdit() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("salary")).sendKeys(Keys.CONTROL+"A");
        driver.findElement(By.id("salary")).sendKeys("1000");
        driver.findElement(By.id("submit")).submit();
    }
     public static void webTableDelete() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"delete-record-4\"]")).click();
    }
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/elements");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)","");
        textBox();
        displayDetails();
        checkBox();
        radiButton();
        webTableAdd();
        webTableEdit();
        webTableDelete();

    }
}
