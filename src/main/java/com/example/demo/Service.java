/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.stereotype.Component;

/**
 *
 * @author binod
 */
@Component
public class Service {
    @LogExecutionTime(value=3)
    public void serve() throws InterruptedException {
    	System.out.println("this is inside method");
        Thread.sleep(2000);
    } 
}
