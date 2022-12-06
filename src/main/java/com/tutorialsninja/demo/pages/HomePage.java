package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By selectMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By selectComponents = By.linkText("Components");
    By verifyTextComponent = By.xpath("//h2[contains(text(),'Components')]");

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(selectMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(selectMenu);
        }
    }
    public void selectComponents(){
        mouseHoverToElementAndClick(selectComponents);
        selectMenu("Show All Components");
    }
    public String verifyTextComponents(){
        return getTextFromElement(verifyTextComponent);
    }


}
