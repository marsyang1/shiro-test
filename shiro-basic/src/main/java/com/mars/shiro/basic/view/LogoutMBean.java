/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.shiro.basic.view;

import com.mars.shiro.basic.service.LogoutService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author mars
 */
@Slf4j
@Named(value = "logoutMBean")
@RequestScoped
public class LogoutMBean {

    @EJB
    private LogoutService service;

    public LogoutMBean() {
    }

    public String logout() {
        service.logout();
        return "/index";
    }

}
