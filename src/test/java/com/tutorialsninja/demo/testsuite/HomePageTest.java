package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        desktopPage.selectDesktopPage();
        Assert.assertEquals(desktopPage.verifyDesktopNavigation(),"Desktops","Not verify");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        laptopsAndNotebooksPage.selectLaptopAndNotebookPage();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyLaptopsAndNotebooksText(),"Laptops & Notebooks","not verify");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homePage.selectComponents();
        Assert.assertEquals(homePage.verifyTextComponents(),"Components","Not verify");

    }

}
