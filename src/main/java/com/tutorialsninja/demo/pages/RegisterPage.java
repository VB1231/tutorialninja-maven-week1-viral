package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {
    By firstName = By.id("input-payment-firstname");
    By lastName = By.id("input-payment-lastname");
    By emailField = By.id("input-payment-email");
    By telephoneNumber = By.id("input-payment-telephone");
    By company = By.id("input-payment-company");
    By addressField = By.id("input-payment-address-1");
    By cityField = By.id("input-payment-city");
    By postCode = By.id("input-payment-postcode");
    By countryField = By.id("input-payment-country");
    By zone = By.xpath("//select[@name='zone_id']");
    By acceptTerms =By.xpath("//input[@name='agree']");
    By clickContinue = By.id("button-register");
    By registerFirstName = By.id("input-firstname");
    By registerLastName = By.id("input-lastname");
    By registerEmailField = By.id("input-email");
    By registerTelephone = By.id("input-telephone");
    By registerPassword = By.id("input-password");
    By registerConfirmPassword = By.id("input-confirm");
    By registerAcceptTerms = By.xpath("//input[@type='checkbox']");
    By registerClickContinue = By.xpath("//input[@value='Continue']");

    public void mandatoryField(){
        driver.findElement(firstName).clear();
        sendTextToElement(firstName,"Prime");
        sendTextToElement(lastName,"Testing");
        driver.findElement(emailField).clear();
        sendTextToElement(emailField,randomEmail());
        sendTextToElement(telephoneNumber,"01923 630 555");
        sendTextToElement(company,"adsf");
        sendTextToElement(addressField,"14 The Avenue");
        sendTextToElement(postCode,"WD23 7AB");
        selectByVisibleTextFromDropDown(countryField,"United Kingdom");
        selectByVisibleTextFromDropDown(zone,"Aberdeen");
        clickOnElement(acceptTerms);
        clickOnElement(clickContinue);
    }
    public void registerField(){
        driver.findElement(registerFirstName).clear();
        sendTextToElement(registerFirstName,"Prime");
        driver.findElement(registerLastName).clear();
        sendTextToElement(registerLastName,"Testing");
        driver.findElement(registerEmailField).clear();
        sendTextToElement(registerEmailField,randomEmail());
        sendTextToElement(registerTelephone,"01923 630 555");
        sendTextToElement(registerPassword,"Welcome123");
        sendTextToElement(registerConfirmPassword,"Welcome123");
       clickOnElement(registerAcceptTerms);
       clickOnElement(registerClickContinue);

    }
}
