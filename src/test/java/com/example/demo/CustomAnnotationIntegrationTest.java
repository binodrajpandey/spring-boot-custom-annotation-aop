/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author binod
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomAnnotationIntegrationTest {
      @Autowired
    private Service service;
      
    @Test
    public void shouldApplyCustomAnnotationAndPrintBinod()  {
        User user = new User();
        user.setUserId(1L);
        user.setName("Binod");
		service.printName(user);
}
    @Test
    public void shouldApplyCustomAnnotationAndShouldPrintOne(){
        User user = new User();
        user.setUserId(1L);
        user.setName("Binod");
		service.printId(user);
}
}
