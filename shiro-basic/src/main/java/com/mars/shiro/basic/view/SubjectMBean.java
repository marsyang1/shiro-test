/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.shiro.basic.view;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author mars
 */
@Named(value = "subjectMBean")
@RequestScoped
public class SubjectMBean {

    /**
     * Creates a new instance of SubjectMBean
     */
    public SubjectMBean() {
    }
    
    public String getId(){
        return SecurityUtils.getSubject().getPrincipal().toString();
    }
    
}
