package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.LoginPage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    MyAccountPage myAccountPage = new MyAccountPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        myAccountPage.clickOnMyAccount("Register");
        Assert.assertEquals(myAccountPage.verifyRegisterPage(),"Returning Customer","Not verify");
    }
    @Test
    public void  verifyThatUserRegisterAccountSuccessfully(){
        myAccountPage.clickOnMyAccount("Register");
        registerPage.registerField();
        Assert.assertEquals(myAccountPage.verifyAccountCreatedText(),"Your Account Has Been Created!","Not verify");
        myAccountPage.clickOnContinueAccount();
        myAccountPage.clickOnMyAccount("Logout");
        Assert.assertEquals(myAccountPage.verifyTextAccountLogOut(),"Account Logout","Not verify");
        myAccountPage.clickOnContinueAccount();
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccountPage.clickOnMyAccount("Login");
        loginPage.enterEmailAndPassword();
        Assert.assertEquals(loginPage.verifyTextMyAccountLogin(),"My Account","Not verify");
        myAccountPage.clickOnMyAccount("Logout");
        Assert.assertEquals(myAccountPage.verifyTextAccountLogOut(),"Account Logout","Not verify");
        myAccountPage.clickOnContinueAccount();


    }
}
