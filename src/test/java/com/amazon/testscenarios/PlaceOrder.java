package com.amazon.testscenarios;

import org.testng.annotations.Test;

import com.amazon.pages.LoginPage;
import com.amazonbase.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PlaceOrder  extends TestBase{
	
  @Test
  public void loginTest() {
	  LoginPage loginPage = new LoginPage();
	  boolean actResult = loginPage.validateLogin("sushmapatil0731@gmail.com","Sushma@123");
	  Assert.assertTrue(actResult);
  }
  @Test
  public void searchProductTest() {
	  Assert.assertTrue(false);
  }
  @Test
  public void selectProductTest() {
	  Assert.assertTrue(false);
  }
  @Test
 
  public void addToCartTest() {
	  Assert.assertTrue(false);
  }
  @BeforeClass
  public void beforeClass() {
	  launchBrowser();
	  navigateToURL();
  }

  @AfterClass
  public void afterClass() {
  }

}
