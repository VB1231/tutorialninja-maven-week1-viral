package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage extends Utility {
    By selectMenu = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");
    By selectMyAccount = By.xpath("//span[contains(text(),'My Account')]");
    By verifyTextRegister= By.xpath("//h2[contains(text(),'Returning Customer')]");
    By verifyAccountTextCreated = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By clickOnContinueAccount = By.xpath("//a[contains(text(),'Continue')]");
    By verifyAccountLogOut = By.xpath("//h1[contains(text(),'Account Logout')]");


    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(selectMenu);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(selectMenu);
        }
    }
    public void clickOnMyAccount(String s){
        clickOnElement(selectMyAccount);
        selectMyAccountOptions(s);
        }
        public String verifyRegisterPage(){
        return getTextFromElement(verifyTextRegister);
        }
        public String verifyAccountCreatedText(){
        return getTextFromElement(verifyAccountTextCreated);
        }
        public void clickOnContinueAccount(){
        clickOnElement(clickOnContinueAccount);
        }
       public String verifyTextAccountLogOut(){
        return getTextFromElement(verifyAccountLogOut);
       }



}
