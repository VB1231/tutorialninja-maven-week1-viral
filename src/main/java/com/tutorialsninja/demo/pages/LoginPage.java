package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By clickLogin = By.xpath("//input[@value='Login']");
    By verifyTextFromMyAccountLogin = By.xpath("//h2[contains(text(),'My Account')]");
    public void enterEmailAndPassword(){
           sendTextToElement(emailField,"viral@gmail.com");
           sendTextToElement(passwordField,"Welcome123");
           clickOnElement(clickLogin);
    }
    public String verifyTextMyAccountLogin(){
        return getTextFromElement(verifyTextFromMyAccountLogin);
    }
}
