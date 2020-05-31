package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Limeroad
{
public static  WebDriver driver  ;
static JavascriptExecutor j;
static Actions a;
Date d;
@Parameters({"brow"})	
@BeforeClass
@Test(priority=4,groups="regression")
public void launch(String s1) 
{
		 //parameter
		 //thread id
 String operaDriver="C:\\Testng\\newie3.4.0\\operadriver.exe";
 System.setProperty("webdriver.opera.driver",operaDriver);
 driver = new OperaDriver();
 driver.get("https://www.google.com/");
 driver.manage().window().maximize();
 long t = Thread.currentThread().getId();
 System.out.println("thread id for opera browser" +t + s1);
}

@Test(priority=6,groups="regression")
public void pagetitleurlgoogle() 
{
		 //groups
		 //priority
System.out.println("google title: " + driver.getTitle());
System.out.println("google url : " + driver.getCurrentUrl());
}

@Parameters({"goo"})
@Test(priority=7,groups="regression")
public void Lime(@Optional("limeroad.com") String a) throws InterruptedException, IOException 
{
Thread.sleep(2000);
WebElement lime = driver.findElement(By.xpath("//input[@title='Search']"));
lime.sendKeys(a);
Thread.sleep(3000);
    TakesScreenshot t=(TakesScreenshot)driver;
    File s = t.getScreenshotAs(OutputType.FILE);
    File d = new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\topicsingoogle.jpg");
    FileUtils.copyFile(s,d);
Thread.sleep(1000);
JavascriptExecutor f=(JavascriptExecutor)driver;
WebElement click = driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
f.executeScript("arguments[0].click()",click);	
Thread.sleep(2000);
driver.findElement(By.xpath("(//h3[@class='LC20lb DKV0Md'])[1]")).click();
}

@Test(priority=8,groups="regression")
public void pagetitleurllimeroad() 
{
		 //groups
		 //priority
System.out.println("limeroad title: " + driver.getTitle());
System.out.println("limeroad url : " + driver.getCurrentUrl());
   }

@Test(priority=8,groups="regression")
public void selectlanguage() throws InterruptedException, IOException 
{
Thread.sleep(3000);
for (int i = 0; i < 1; i++) 
  {
   try 
    {
      driver.findElement(By.xpath("//div[@class='bgL br20 br8 c3 dTc p8 vM']")).click();
    }
  catch(Exception e)
    {
	e.printStackTrace();
   }
}
   TakesScreenshot t=(TakesScreenshot)driver;
   File s = t.getScreenshotAs(OutputType.FILE);
   File d = new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\shopwomen.jpg");
   FileUtils.copyFile(s,d);
}

@Test(priority=9,groups="regression")
public void selectwomen() throws InterruptedException 
{
Thread.sleep(1000);
for (int i = 0; i < 1; i++) 
  {
   try
    {
       WebElement women = driver.findElement(By.xpath("//span[text()='SHOP WOMEN']"));
       women.click();	
    }
   catch(Exception e)
   {
   e.printStackTrace();
   }
  }
}

@Test(priority=10,groups="sang")             
public void selectmen() 
{
driver.findElement(By.xpath("//span[text()='SHOP MEN']")).click();
}

@Test(priority=10,groups="regression")
public void menupage() throws InterruptedException, IOException
{
		 //screenshot
Thread.sleep(2000);
for (int i = 0; i < 2; i++) 
{
  try
    {
       WebElement click = driver.findElement(By.xpath("//a[@class='tdN pA t0 l12 w24 h24 m128 z8 navBtn dN an-menu']"));
       JavascriptExecutor f=(JavascriptExecutor)driver;
       f.executeScript("arguments[0].click()",click);
    }
  catch(Exception e) {}
}
    TakesScreenshot t=(TakesScreenshot)driver;
    File s = t.getScreenshotAs(OutputType.FILE);
    File d1 = new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\menu.jpg");
    FileUtils.copyFile(s,d1);
}

@Test(priority=10,groups="regression")
public void signin() throws InterruptedException, IOException 
{
		 //navigate
Thread.sleep(2000);
for (int i = 0; i < 1; i++) 
{
  try 
   {	
	  WebElement sign= driver.findElement(By.xpath("//a[text()='sign in']"));
	  sign.click();
	  Thread.sleep(3000);
	  WebElement mob2 = driver.findElement(By.xpath("//input[@type='number']"));
	  mob2.sendKeys("7358408116");
	  System.out.println(mob2.getAttribute("value"));
   }
  catch(Exception e) {}
}
Thread.sleep(2000);
WebElement f = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click()",f);
Thread.sleep(4000);
WebElement otp = driver.findElement(By.xpath("//input[@id='otp']"));
otp.sendKeys("0805");
System.out.println("otp : " + otp.getAttribute("value"));
   TakesScreenshot t=(TakesScreenshot)driver;
   File s = t.getScreenshotAs(OutputType.FILE);
   File d = new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\signin.jpg");
   FileUtils.copyFile(s,d);
Thread.sleep(7000);
driver.navigate().refresh();
driver.navigate().back();
WebElement c1 = driver.findElement(By.xpath("//a[@class='tdN pA t0 l12 w24 h24 m128 z8 navBtn dN an-menu']"));
c1.click();
Thread.sleep(2000);
String change = driver.findElement(By.xpath("//div[text()='change language']")).getText();
System.out.println(change);
	 }

@Test(priority=12,groups="reg")
public void logout()
{
driver.findElement(By.xpath("(//a[@class='dB p8 c3 tdN hcP'])[7]")).click();
driver.findElement(By.xpath("//a[text()='logout']")).click();
}

@Test(priority=12,groups="regression")
public void smartwatches() throws InterruptedException, AWTException, IOException 
{
Thread.sleep(3000);
driver.findElement(By.xpath("//a[@class='tdN pA t0 l12 w24 h24 m128 z8 navBtn dN an-menu']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("(//div[@class='pR has-sub c0 pr36 p8 dB hcP pl12'])[27]")).click();
driver.findElement(By.xpath("//a[text()='Smart Watches']")).click();
Thread.sleep(3000);
    TakesScreenshot t=(TakesScreenshot)driver;
    File s = t.getScreenshotAs(OutputType.FILE);
    File d = new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\smartwatches.jpg");
    FileUtils.copyFile(s,d);
driver.findElement(By.xpath("//a[@class='pA t0 r60 m128 w24 h24 srch z5 dN an-srch']")).click(); 	
}

@Test(groups="regression",priority=14,invocationCount=10,dataProvider="search",dataProviderClass=Maintaing.class)
private void searchproduct(String s1) throws InterruptedException
{
Thread.sleep(1000);
WebElement send = driver.findElement(By.xpath("//input[@type='search']"));
send.clear();
send.sendKeys(s1);
System.out.println("..................search products.....................");
System.out.println("i am searching the product with low price :" + s1);
}

@Parameters({"search"})
@Test(groups="regression",priority=16)
public void addtocart(String s) throws InterruptedException, AWTException, IOException 
{
Thread.sleep(1000);
WebElement send = driver.findElement(By.xpath("//input[@type='search']"));
send.clear();
send.sendKeys(s);
System.out.println(s);
WebElement sub = driver.findElement(By.xpath("//div[@class='srcInpuSub dTc vT w60 pR hcurP']"));
sub.click();
Thread.sleep(2000);
WebElement low2= driver.findElement(By.xpath("//div[text()='Low Price']"));
low2.click();
boolean l= low2.isSelected();
System.out.println("radio button is selected : " + l);
Thread.sleep(2000);
Actions n=new Actions(driver);
n.contextClick(low2).perform();
   Robot r=new Robot();
   for (int i = 0; i <9; i++)
    {
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);
	}
      r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(9000);
     TakesScreenshot t=(TakesScreenshot)driver;
	 File s1 = t.getScreenshotAs(OutputType.FILE);
	 File d = new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\printpage.jpg");
	 FileUtils.copyFile(s1,d);
}

@Test(priority=19,groups="regress")
public void notification() throws InterruptedException
{
Thread.sleep(6000);
Alert e=driver.switchTo().alert();
e.dismiss();
}

@Test(priority=19,groups="regression")
public void shoppingoffers() throws InterruptedException
{
Thread.sleep(8000);
for (int i = 0; i < 5; i++) {
	driver.navigate().back();
}
driver.navigate().to("https://www.limeroad.com");
Thread.sleep(1000);
//driver.findElement(By.xpath("//span[text()='SHOP WOMEN']")).click();
Thread.sleep(2000);
WebElement shop = driver.findElement(By.xpath("//span[text()='shop']"));
Actions n=new Actions(driver);
n.click(shop).perform();
Thread.sleep(2000);
JavascriptExecutor s=(JavascriptExecutor)driver;
Thread.sleep(3000);
WebElement off1 = driver.findElement(By.xpath("(//img[@class='wp100 an-ll o0'])[4]"));
Thread.sleep(1000);
s.executeScript("arguments[0].scrollIntoView(true)",off1);
System.out.println("......................OFFERS....................");
System.out.println("FLAT 50% OFF");
System.out.println("FLAT 60% OFF");
System.out.println("FLAT 70% OFF");
System.out.println("UNDER 399");
System.out.println("UNDER 699");
System.out.println("UNDER 999");
}

@Test(groups="regression",priority=23)
public void checkoffer60() throws InterruptedException 
{
Thread.sleep(1000);
System.out.println("...................1st checking under falt 60% off..............");
driver.findElement(By.xpath("//img[@src='//img0.junaroad.com/catalogues/2390963/5ebc046c22c15.jpg']")).click();
System.out.println("trending");
Thread.sleep(3000);
WebElement products = driver.findElement(By.xpath("//div[@class='dT wp100 tlF h48']"));
System.out.println(products.getText());
Thread.sleep(3000);
//driver.findElement(By.xpath("//img[@src='//img0.junaroad.com/uiproducts/16299207/pri_175_p-1558437317.jpg']")).click();
 
}

@Test(groups="regression",priority=25)
public void checkoutoffer70() throws InterruptedException 
{
Thread.sleep(4000);
driver.navigate().back();
//driver.navigate().to("https://www.limeroad.com/");
WebElement shop = driver.findElement(By.xpath("//span[text()='shop']"));
Actions n=new Actions(driver);
n.click(shop).perform();
Thread.sleep(2000);
JavascriptExecutor s=(JavascriptExecutor)driver;
Thread.sleep(3000);
WebElement off1 = driver.findElement(By.xpath("(//img[@class='wp100 an-ll o0'])[4]"));
Thread.sleep(1000);
s.executeScript("arguments[0].scrollIntoView(true)",off1);
System.out.println("......................OFFERS....................");
Thread.sleep(7000);
driver.findElement(By.xpath("(//img[@class='wp100 an-ll o0'])[3]")).click();
Thread.sleep(4000);
//dout
System.out.println("==================================product details====================================");
List<WebElement> l = driver.findElements(By.xpath("//img[@class='dB h412 w310 mA pR prdI gtm-p an-ll o0']"));
int d = l.size();
System.out.println("no of dresses : " + d);
System.out.println("-------------------GOLD PRINT KURTA PANT SET----------------------");
for (int i = 0; i < d; i++) 
{
  try
   {
     WebElement t = l.get(2);
     t.click();
   }
  catch(Exception e) {}
 }   

Thread.sleep(1000);
System.out.println("--------------------------size-----------------------");
WebElement size = driver.findElement(By.xpath("//div[@class='bs fs14 p12 pR wp100 shk']"));
System.out.println(size.getText());
List<WebElement> pageall = driver.findElements(By.xpath("//div[@class='bs fs14 p12 pR']"));
//highlight1("blue",pageall,driver);
      for (WebElement full : pageall)
       {
    	//highlight("green",full,driver);
    	System.out.println("-----------------------deliver and product details");
        System.out.println(full.getText());	
       }
}
@Parameters({"str","web","dr"})
@Test
public static void highlight(String s1, WebElement s2, WebDriver driver2)
{
j.executeScript("arguments[0].style.backgroundColor='"+s1+"'",s2);
  try
   {
     Thread.sleep(8000);
   }
  catch(Exception e)
   {}
}

@Parameters({"str","web","dr"})
@Test
public static void highlight1(String s1, List<WebElement> s2, WebDriver driver2)
{
j.executeScript("arguments[0].style.backgroundColor='"+s1+"'",s2);
  try
   {
     Thread.sleep(8000);
   }
  catch(Exception e)
   {}
}

@BeforeMethod(groups="regression")
public void start() 
{
d=new Date();
System.out.println("start execution time: " +d);
}

@AfterMethod(groups="regression")
public void end()
{
d=new Date();
System.out.println("end execution time: " +d);
}
}
