package com.onlinebankingsystem.Banking.genericlibrary;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class Webdriver_Utilities {
	/**
	 * This method is used to wait for page load implicitly
	 * @author Admin
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait for page load explicitly
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisisble(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method is used to wait page load explicitly
	 * @param driver
	 * @param element
	 */
	public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element)
	    { 
		      WebDriverWait wait = new WebDriverWait(driver,20);
		      wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	public void waitForElemnetTogettitle(WebDriver driver, WebElement element,String title)
    { 
	      WebDriverWait wait = new WebDriverWait(driver,20);
	      wait.until(ExpectedConditions.titleContains(title));//elementToBeClickable(element));
	}

	/**
	 * This method is used to handle dropdown using value
	 * @param value
	 * @param element
	 */
	public void select(String value, WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	/**
	 * This method is used to handle dropdown using Index
	 * @param element
	 * @param Index
	 */
	public void select(WebElement element ,int Index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(Index);
	}
	/**
	 * This method is used to handle dropdown using vsible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element ,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method is used to perform mousehover
	 * @param driver
	 * @param ele
	 */
	
	public void mouseHover(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	/**
	 * This method is used to perform doubleclick
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to do doubleclick on web pages
	 * @param driver
	 */
	public void doubleClickOnWebPages(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	/**
	 * This method is used to perform rightclick
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method is use to do drag and drop
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dst).perform();
	}
	
	/** 
	 * This method is used to press the enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method is used to press the key
	 * @param driver
	 * @throws AWTException
	 */
	public void enterKey(WebDriver driver) throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws AWTException
	 */
	public void enterKeyRelease(WebDriver driver) throws AWTException
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to handle accept popup
	 * @param driver
	 */
	public void alertPopupAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to dismiss the popup
	 * @param driver
	 */
	public void alertPopupDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to swithchtoframe
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver, int Index)
	{
		driver.switchTo().frame(Index);
	}
	
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	public void switchToFrame(WebDriver driver, String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}
	/**
	 * This method is used to switchbacktoframe
	 * @param driver
	 */
	public void switchBackToFrame(WebDriver driver) 
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to switch tabs
	 * @param driver
	 */
	public void switchTabs(WebDriver driver) 
	{
		Set<String> child = driver.getWindowHandles();
		for( String b:child) {
			driver.switchTo().window(b);
		}
	}
	
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
	
	
	/**
	 * This method will scroll untill specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0].scrollIntoView()", element);
	}

	public void scrollByAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int x = element.getLocation().getX();
		jse.executeScript("window.scrollBy("+x+",0)");
	}
	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 File dest=new File("./photo/"+screenshotName+".PNG");
		 FileUtils.copyFile(src, dest);
		 }
	
	/**
	 * This method is used to switch to window
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
		 Set<String> window = driver.getWindowHandles();
		 //driver.switchTo().newWindow(WindowType.WINDOW);
		 Iterator<String> it = window.iterator();
		 while (it.hasNext()) {
		 String wID = it.next();
		 driver.switchTo().window(wID);
		 String currentWindowTitle = driver.getTitle();
		 if(currentWindowTitle.contains(partialWindowTitle)) {
		 break;
		 
		 
		 }
		 }
		}
	
	

}
