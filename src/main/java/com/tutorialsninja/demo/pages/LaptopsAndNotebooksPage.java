package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    HomePage homePage = new HomePage();

    By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    By verifyLaptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By priceSelect = By.xpath("//p[@class ='price']");
    By priceHighToLow = By.id("input-sort");
    By selectMacBook = By.linkText("MacBook");
    By verifyTextMacBook = By.xpath("//h1[contains(text(),'MacBook')]");
    By clickOnAddToCart = By.id("button-cart");
    By verifySuccessFullyAddedToCart = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By clickOnShoppingCartInToSuccessMessage = By.xpath("//a[contains(text(),'shopping cart')]");
    By verifyTextMacBookShopping = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By changeQty = By.xpath("//input[contains(@name, 'quantity')]");
    By clickOnUpdate = By.xpath("//button[contains(@data-original-title, 'Update')]");
    By verifyTextUpdate = By.xpath("//body/div[@id='checkout-cart']/div[1]");
    By verifyTotalPrice = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    By clickOnCheckOut = By.xpath("//a[contains(text(),'Checkout')]");
    By verifyClickOnCheckout = By.xpath("//h1[contains(text(),'Checkout')]");
    By verifyNewCustomer = By.xpath("//h2[normalize-space()='New Customer']");
    By selectGuestCheckOut = By.xpath("//h2[contains(text(),'New Customer')]");
    By clickContinueAsGuest = By.id("button-account");

    public void selectLaptopAndNotebookPage() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
        homePage.selectMenu("Show All Laptops & Notebooks");
    }

    public String verifyLaptopsAndNotebooksText() {
        return getTextFromElement(verifyLaptopsAndNotebooksText);
    }

    public List<Double> beforePriceSort() {
        List<WebElement> products = driver.findElements(priceSelect);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        // Collections.sort(originalProductsPrice, Collections.reverseOrder());
        return originalProductsPrice;
    }

    public List<Double> afterPriceSort() {
        List<WebElement> products = driver.findElements(priceSelect);
        selectByVisibleTextFromDropDown(priceHighToLow, "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(priceSelect);
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return afterSortByPrice;
    }

    public void selectPriceSortHighToLow() {
        selectByVisibleTextFromDropDown(priceHighToLow, "Price (Low > High)");
    }

    public void clickOnMacBook() {
        clickOnElement(selectMacBook);
    }

    public String verifyTextMacBook() {
        return getTextFromElement(verifyTextMacBook);
    }

    public void clickOnAddToCart() {
        clickOnElement(clickOnAddToCart);
    }

    public String verifySuccessFullyAddedToCart() {
        return getTextFromElement(verifySuccessFullyAddedToCart);
    }

    public void clickOnShoppingCartInToSuccessMessage() {
        clickOnElement(clickOnShoppingCartInToSuccessMessage);
    }

    public String verifyTextMacBookInShopping() {
        return getTextFromElement(verifyTextMacBookShopping);
    }

    public void changeQty() {
        driver.findElement(changeQty).clear();
        sendTextToElement(changeQty, "2");
        clickOnElement(clickOnUpdate);
    }

    public String verifyUpdatedMessage() {
        return getTextFromElement(verifyTextUpdate);
    }

    public String verifyTotalPrice() {
        return getTextFromElement(verifyTotalPrice);
    }

    public void clickOnCheckOut() {
        clickOnElement(clickOnCheckOut);
    }

    public String verifyTextClickOnCheckOut() {
        return getTextFromElement(verifyClickOnCheckout);
    }

    public String verifyNewCustomer() {
        return getTextFromElement(verifyNewCustomer);
    }

    public void selectGuestCheckOut() {
        clickOnElement(selectGuestCheckOut);
        clickOnElement(clickContinueAsGuest);
    }
}
