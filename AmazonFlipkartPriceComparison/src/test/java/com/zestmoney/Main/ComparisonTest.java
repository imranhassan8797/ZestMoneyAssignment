package com.zestmoney.Main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zestmoney.Objects.AmazonHomepage;
import com.zestmoney.Objects.FlipkartHomePage;
import com.zestmoney.Objects.PriceFromAmaz;
import com.zestmoney.Objects.PriceFromFlip;

public class ComparisonTest 
{
	public static String priceFromAmazon;
	public static String priceFromFlipkart;
	static WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		//driver=new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void getPriceFromAmazon()
	{
		driver.get("https://www.amazon.in");
		AmazonHomepage az=new AmazonHomepage(driver);
		az.typePhone();
		az.clickSearch();
		PriceFromAmaz paz=new PriceFromAmaz(driver);
		priceFromAmazon=paz.getPrice();
		priceFromAmazon = priceFromAmazon.replace(",", "");
		System.out.println("Price of Apple iPhone XR (64GB) - White in amazon is " +priceFromAmazon);
		
	}
	@Test
	public void getPriceFromFlipkart()
	{
		driver.get("https://www.flipkart.com/");
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ESCAPE).build().perform();
		FlipkartHomePage fh=new FlipkartHomePage(driver);
		fh.typePhone();
		fh.clickSubmit();
		PriceFromFlip paf= new PriceFromFlip(driver);
		 priceFromFlipkart= paf.getPrice();
		 priceFromFlipkart=priceFromFlipkart.replace(",", "");
		 System.out.println("Price of Apple iPhone XR (64GB) - White in Flipkart is " +priceFromFlipkart);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@AfterClass
	public void comparePrices()
	{
		int amazon = Integer.parseInt(priceFromAmazon);
		int flipkart = Integer.parseInt(priceFromFlipkart);
         
		
		if (amazon==flipkart) {

			System.out.println("Price of Apple iPhone XR (64GB) - White is same in both websites");
		} 
		else if (amazon>flipkart) {
			
			System.out.println("Price of Apple iPhone XR (64GB) - White in Flipkart website is less");
			
		}
		else {
			
			System.out.println("Price of Apple iPhone XR (64GB) - White in Amazon website is less");
			
	}

	}
		
	}
	
	
