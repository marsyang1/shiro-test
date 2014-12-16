/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mars.shiro.basic.service;

import javax.ejb.Local;

/**
 *
 * @author mars
 */
@Local
public interface LogoutService {

    public void logout();

}
