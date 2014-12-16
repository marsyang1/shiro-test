/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.shiro.basic.view;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.omnifaces.util.Messages;

/**
 *
 * @author mars
 */
@Slf4j
@Named(value = "loginMBean")
@RequestScoped
public class LoginMBean {

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private boolean rememberMe = false;

    /**
     * Creates a new instance of LoginMBean
     */
    public LoginMBean() {
    }

    public String authenticate() {
        UsernamePasswordToken token = new UsernamePasswordToken(userId, password, rememberMe);
        Subject currentUser = SecurityUtils.getSubject();

        log.info("Submitting login with username of " + userId
                + " and password of " + password);

        try {
            currentUser.login(token);
            log.info("User :" + currentUser.getPrincipal() + "has login");
            log.info("currentUser.isPermitted(\"create\")" + currentUser.isPermitted("create"));
        } catch (AuthenticationException e) {
            log.warn(e.getMessage());
            Messages.addFlashGlobalError("登入失敗 ,您輸入的帳號或密碼有誤。");
            return "/index";
        }
        return "/system/portal";
    }

}
