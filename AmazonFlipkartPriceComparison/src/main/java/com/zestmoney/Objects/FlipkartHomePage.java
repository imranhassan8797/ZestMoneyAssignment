package com.zestmoney.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartHomePage 
{
	WebDriver driver;
	By search = By.xpath("//input[@name='q']");
	By submitbutton = By.xpath("//button[@type='submit']");

	public FlipkartHomePage(WebDriver flipkartDriver) {

		this.driver = flipkartDriver;
	}

	

	public void typePhone() {
		driver.findElement(search).sendKeys("Apple iPhone XR (White, 64 GB)");
	}

	public void clickSubmit() {
		driver.findElement(submitbutton).click();
	}

}
