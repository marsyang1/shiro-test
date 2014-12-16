/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.shiro.basic.service;

import javax.ejb.Stateless;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author mars
 */
@Slf4j
@Stateless
public class LogoutServiceImpl implements LogoutService {

    @Override
    public void logout() {
        String userId = SecurityUtils.getSubject().getPrincipal().toString();
        SecurityUtils.getSubject().logout();
        log.info("User " + userId + " has logout");
    }

}
