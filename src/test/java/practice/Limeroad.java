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
 System.out.println("..................................browser launching...............................");
 System.out.println("thread id for opera browser" +t + s1);
}

@BeforeMethod(groups="regression")
public void start() 
{
d=new Date();
System.out.println(d);
}

@Test(priority=6,groups="regression")
public void googletitleurl() 
{
		 //groups
		 //priority
System.out.println("...................google title & url..................");
System.out.println("google title: " + driver.getTitle());
System.out.println("google url : " + driver.getCurrentUrl());
}

@Parameters({"goo"})
@Test(priority=7,groups="regression")
public void searchlimeroad(@Optional("limeroad.com") String a) throws InterruptedException, IOException 
{ 
         //debug
	     //javascript
Thread.sleep(2000);
System.out.println("--------------------searching limeroad.com------------------------");
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
public void limeroadtitleurl() 
{
		 //groups
		 //priority
	     //exception
	     //screenshot
System.out.println("---------------------limeroad title & url----------------------");
System.out.println("limeroad title: " + driver.getTitle());
System.out.println("limeroad url : " + driver.getCurrentUrl());
   }

@Test(priority=8,groups="regression")
public void selectlanguage() throws InterruptedException, IOException 
{
Thread.sleep(3000);
System.out.println("--------------------select language----------------------");
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
//--------------------------------women---------------------------------
@Test(priority=9,groups="regression")
public void selectwomen() throws InterruptedException 
{
Thread.sleep(1000);
System.out.println("=============================================selecting women===========================================");
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
public void selectmen() throws InterruptedException 
{
Thread.sleep(3000);
System.out.println("==============================================selecitng men============================================");
for (int i = 0; i < 1; i++) 
{
 try
  {
	 driver.findElement(By.xpath("//span[text()='SHOP MEN']")).click();
  }
 catch(Exception e)
 {
 e.printStackTrace();
 }
}
}

@Test(priority=10,groups="regression")
public void menupage() throws InterruptedException, IOException
{
		 //screenshot
System.out.println("------------------------------------menu page-------------------------------------");
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
System.out.println("============================signin=============================");
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
	System.out.println("!!!! thank you successfully logout.............................");
driver.findElement(By.xpath("(//a[@class='dB p8 c3 tdN hcP'])[7]")).click();
driver.findElement(By.xpath("//a[text()='logout']")).click();
}

@Test(priority=12,groups="regression")
public void smartwatches() throws InterruptedException, AWTException, IOException 
{
Thread.sleep(3000);
System.out.println("............................searching smart watches................................");
System.out.println("----------------------------------searching smart watches for women----------------------------------");
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
	       //dataprovider
Thread.sleep(1000);
System.out.println("---------------------search product----------------------------------");
WebElement send = driver.findElement(By.xpath("//input[@type='search']"));
send.clear();
send.sendKeys(s1);
System.out.println("..................search products.....................");
System.out.println("i am searching the product with low price :" + s1);
}

@Parameters({"search"})
@Test(groups="regression",priority=16)
public void rightclick(String s) throws InterruptedException, AWTException, IOException 
{
	//webelement
	//actions
Thread.sleep(1000);
System.out.println("--------------------------checking rightclick----------------------------");
WebElement send = driver.findElement(By.xpath("//input[@type='search']"));
send.clear();
send.sendKeys(s);
System.out.println(s);
WebElement sub = driver.findElement(By.xpath("//div[@class='srcInpuSub dTc vT w60 pR hcurP']"));
sub.click();
Thread.sleep(2000);
WebElement low2= driver.findElement(By.xpath("//div[text()='Low Price']"));
boolean a = low2.isSelected();
System.out.println("radio button is selected : " + a);
  if(a==false)
   {
    Thread.sleep(1000);
    low2.click();
    boolean l= low2.isSelected();
    System.out.println("radio button is selected : " + l);
}
Thread.sleep(2000);
Actions n=new Actions(driver);
n.contextClick(low2).perform();
Thread.sleep(5000);
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

@Test(priority=19,groups="regression")
public void shoppingoffers() throws InterruptedException
{
Thread.sleep(8000);
System.out.println("........................shopping offers.........................");
   for (int i = 0; i < 5; i++) 
    {
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
System.out.println("..............................checking offer 60..................................");
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
public void checkoffer50() throws InterruptedException, IOException 
{
Thread.sleep(4000);
System.out.println("..............................checking offer 50..................................");
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
System.out.println("==================================product details====================================");
List<WebElement> l = driver.findElements(By.xpath("//img[@class='dB h412 w310 mA pR prdI gtm-p an-ll o0']"));
int d = l.size();
System.out.println("NO OF DRESSES : " + d);
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
      for (WebElement full : pageall)
       {
    	System.out.println("-----------------------deliver and product details------------------------");
        System.out.println(full.getText());	
       }
      
//dout----------------------   
WebElement like = driver.findElement(By.xpath("//div[@class='pR hbxs bgL br4 bxs dTc vT w48 h48 bxs vip_16975946']"));
like.click();
    TakesScreenshot t5=(TakesScreenshot)driver;
    File s8 = t5.getScreenshotAs(OutputType.FILE);
    File d8= new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\like.jpg");
    FileUtils.copyFile(s8,d8);
Thread.sleep(3000);
driver.navigate().back();
//dress size
List<WebElement> sizes = driver.findElements(By.xpath("//div[@class='br4 dIb m4 vT p12 fs16 bxs bs ttU taC wsN size  bd3 hcP hbxs']"));
for (int i = 0; i < sizes.size(); i++)
{
WebElement w = sizes.get(1);
w.click();
System.out.println("it is selected : " + w.isSelected());
System.out.println("it is diSplayed : " + w.isDisplayed());
}
String inch = driver.findElement(By.xpath("//div[@class='bgN bs c3 dN dT fs14 mb10 p12']")).getText();
System.out.println(inch);
//addtocart
Thread.sleep(3000);
driver.findElement(By.xpath("//div[text()='ADD TO CART']")).click();
Thread.sleep(9000);
    TakesScreenshot t=(TakesScreenshot)driver;
    File s1 = t.getScreenshotAs(OutputType.FILE);
    File d1= new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\addtocart.jpg");
    FileUtils.copyFile(s1,d1);
System.out.println("............summary..............");
Thread.sleep(3000);
String summary = driver.findElement(By.xpath("//div[@class='p12 bs mA mw460 fs14 c3']")).getText();
driver.findElement(By.xpath("//div[@class='bs mA mw460 p4']")).click();
    TakesScreenshot t1=(TakesScreenshot)driver;
    File s2 = t.getScreenshotAs(OutputType.FILE);
    File d2= new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\buynow.jpg");
    FileUtils.copyFile(s2,d2);
}

@Test(groups="regression",priority=27)
public void inside() throws InterruptedException, IOException, AWTException
{
	for (int i = 0; i < 2; i++) 
	{
		driver.navigate().back();
	}
JavascriptExecutor l=(JavascriptExecutor)driver;
System.out.println("......................checking inside product......................");
List<WebElement> inside = driver.findElements(By.xpath("//img[@class='dB w171 h227 pR prdI gtm-p an-ll o0 ']"));
int o = inside.size();
System.out.println("no of products in inside : " + o);
    for (int i = 0; i < inside.size(); i++) 
     {
       System.out.println("no of products inside product :" + i);	
       WebElement e1= inside.get(5);
       Actions k=new Actions(driver);
       k.click(e1);
       }
    
Thread.sleep(4000);
List<WebElement> under = driver.findElements(By.xpath("//a[@class='dB p8 c6 tdN']"));
int p = under.size();
System.out.println("....................lime road details..................");
    for (int i = 0; i < under.size(); i++)
     {
    	try
    	{
	 WebElement about = under.get(1);
	 l.executeScript("arguments[0].scrollIntoView(true)",about);
	 about.click();
	 Thread.sleep(3000);
	 String aboutus = driver.findElement(By.xpath("//div[@class='bs conW p16 bs']")).getText();
	 System.out.println("..................about us................");
	 System.out.println(aboutus);
     }
    catch(Exception e) {}
     }
Thread.sleep(5000);
    for (int i = 0; i < 1; i++) 
     {
	   driver.navigate().back();
     }
   // driver.findElement(By.xpath("(//img[@class='wp100 an-ll o0'])[3]")).click();
  //  Thread.sleep(4000);
    for (int i = 0; i < under.size(); i++) 
     {
    	try
    	{
	   WebElement t= under.get(7);
	   l.executeScript("arguments[0].scrollIntoView(true)",t);
	   Actions k=new Actions(driver);
       k.click(t);
       Thread.sleep(2000);
	   String termsuse = driver.findElement(By.xpath("//div[@class='bgF br4 bs bxs c6 fs15 mA mxw960 p16 taL']")).getText();
       System.out.println("................terms of use................");
       System.out.println(termsuse);
    	}
    	catch(Exception e) {}
 }
Thread.sleep(4000);
driver.navigate().back();
    for (int i = 0; i < under.size(); i++) 
      {
    	try
    	{
		WebElement privacy1 = under.get(8);
		l.executeScript("arguments[0].scrollIntoView(true)",privacy1);
		Actions k=new Actions(driver);
	    k.click(privacy1);
	    Thread.sleep(2000);
		String policy = driver.findElement(By.xpath("//div[@class='bgF br4 bs bxs c6 fs15 mA mxw960 p16 taL']")).getText();
		System.out.println(".................privacy policy...................");
		System.out.println(policy);
    	}
    	catch(Exception e) {}
	}
Thread.sleep(3000);
driver.navigate().back();
    for (int i = 0; i < under.size(); i++) 
      {
    	try
    	{
	    WebElement faq1 = under.get(4);
	    l.executeScript("arguments[0].scrollIntoView(true)",faq1);
	    Actions k=new Actions(driver);
	    k.click(faq1);
	    Thread.sleep(3000);
	    List<WebElement> related = driver.findElements(By.xpath("//div[@class='bdbE c3 dB fs15 has-sub p12 pR']"));
	 
	     for (int j = 0; j < related.size(); j++)
	      {
		    WebElement click = related.get(9);
		    Actions k1=new Actions(driver);
		    k.click(click);
	      }
    	}
    	catch(Exception e) {}
      }
Thread.sleep(5000);
	TakesScreenshot t5=(TakesScreenshot)driver;
	File s8 = t5.getScreenshotAs(OutputType.FILE);
	File d8= new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\Limeroadgoldrelated.jpg");
	FileUtils.copyFile(s8,d8);
	 
WebElement plus = driver.findElement(By.xpath("//div[text()='What is LimeRoad GOLD?']"));
Actions n=new Actions(driver);
n.contextClick(plus).perform();
Thread.sleep(5000);
   Robot r=new Robot();
   for (int i = 0; i <9; i++)
    {
	  r.keyPress(KeyEvent.VK_DOWN);
	  r.keyRelease(KeyEvent.VK_DOWN);
	}
      r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(9000);
System.out.println("................................saving as pdf.............................");
     TakesScreenshot t=(TakesScreenshot)driver;
	 File s1 = t.getScreenshotAs(OutputType.FILE);
	 File d = new File("C:\\Users\\91984\\Desktop\\clone\\collectionrepo\\limeroadscreenshot\\Pdf.jpg");
	 FileUtils.copyFile(s1,d);

    
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

@AfterMethod(groups="regression")
public void end()
{
d=new Date();
System.out.println(d);
}
}
