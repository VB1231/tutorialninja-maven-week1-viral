package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    HomePage homePage = new HomePage();
    By deskTop = By.linkText("Desktops");
    By verifyDesktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By sortingList = By.xpath("//h4/a");
    By sortBy = By.id("input-sort");
    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By currencyDropDown = By.xpath("//ul[@class = 'dropdown-menu']/li");
    By selectHP = By.xpath("//a[contains(text(),'HP LP3065')]");
    By verifyTextHP = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By clickOnCalender = By.xpath("//div[@class = 'input-group date']//button");
    By getDefaultMonthYear = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By nextMonthYear = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    By selectDay = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By addToCart = By.id("button-cart");
    By verifySuccessfullyAdded = By.xpath("//div[contains(text(),'Success: You have added ')]");
    By clickOnShoppingCartLink = By.xpath("//span[contains(text(),'Shopping Cart')]");
    By clickOnAddToCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    By verifyTextShoppingCart = By.xpath("//div[@id='content']//h1");
    By verifyTextHpL = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By verifyDeliveryDate = By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]");
    By verifyModel = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By verifyTotalAmount = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");


    public void selectDesktopPage() {
        mouseHoverToElementAndClick(deskTop);
        homePage.selectMenu("Show All Desktops");
    }

    public String verifyDesktopNavigation() {
        return getTextFromElement(verifyDesktopText);
    }

    public ArrayList<String> beforeSort() {
        List<WebElement> products = driver.findElements(sortingList);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }

    public ArrayList<String> afterSort() {
        List<WebElement> products = driver.findElements(sortingList);
        selectByVisibleTextFromDropDown(sortBy, "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(sortingList);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        return afterSortByZToAProductsName;
    }
    public void currencyChange(){
        clickOnElement(currency);
        List<WebElement> currencyList = driver.findElements(currencyDropDown);
        for (WebElement e:currencyList ) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")){
                e.click();
                break;
            }
        }
    }
    public void showAllDesktops(){
        currencyChange();
       selectDesktopPage();
       selectByVisibleTextFromDropDown(sortBy,"Name (A - Z)");
       }
       public String verifyTextHP(){
        clickOnElement(selectHP);
        return getTextFromElement(verifyTextHP);
       }
       public void setDate(){
           String year = "2022";
           String month = "November";
           String date = "30";
           clickOnElement(clickOnCalender);
           while (true) {
               String monthAndYear = driver.findElement(getDefaultMonthYear).getText();
               String[] arr = monthAndYear.split(" ");
               String mon = arr[0];
               String yer = arr[1];
               if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                   break;
               } else {
                   clickOnElement(nextMonthYear);
               }
           }
           List<WebElement> allDates = driver.findElements(selectDay);
           for (WebElement e : allDates) {
               if (e.getText().equalsIgnoreCase(date)) {
                   e.click();
                   break;
               }
           }
       }
       public void clickOnAddToCart(){
        clickOnElement(addToCart);
       }
       public String verifyYouSuccessfullyAdded(){
        return getTextFromElement(verifySuccessfullyAdded);
       }
       public void clickOnShoppingCartLink(){
        clickOnElement(clickOnShoppingCartLink);
       }
       public void clickOnAddToCartLink(){
        clickOnElement(clickOnAddToCartLink);
       }
       public String verifyTextShoppingCart(){
        return getTextFromElement(verifyTextShoppingCart);
       }
       public String verifyTextHpL(){
        return getTextFromElement(verifyTextHpL);
       }
       public String verifyDeliveryDate(){
        return getTextFromElement(verifyDeliveryDate);
       }
       public String verifyModel(){
        return getTextFromElement(verifyModel);
       }
       public String verifyTotalAmount(){
        return getTextFromElement(verifyTotalAmount);
       }
}
