/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author binod
 */
@Component
public class Service {
    private static final Logger logger=LoggerFactory.getLogger(Service.class);
  
    @LoggedInBy(id="#user.userId")
    public void printId(User user) {
    	logger.info("Excuting Custom annotation for Id");
    } 
    @LoggedInBy(name="#user.name")
    public void printName(User user) {
    	logger.info("Excuting Custom annotation for Name");
    } 
}
