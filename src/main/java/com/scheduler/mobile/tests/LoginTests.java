package com.scheduler.mobile.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
     public void testLogin(){
      app.fillLoginForm("adkogan@gmail.com", "5605105zxC");
      app.confirmLogin();
    }
}
