package com.zestmoney.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PriceFromAmaz 
{
	WebDriver driver;

	By price = By.xpath("//span[text()='Apple iPhone XR (64GB) - White']/../../../.././../../../div[2]/div/div/div/div/div/a");

	public PriceFromAmaz(WebDriver driver) {
		this.driver = driver;
	}

	public String getPrice() {
		return driver.findElement(price).getText().substring(1);
	}

}
