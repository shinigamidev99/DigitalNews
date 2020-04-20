/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Administrator
 */
public class Config {
    
    // get value of config by name
    public String getConfigValue(String name) throws NamingException {
        InitialContext init = new InitialContext();
        Context cont = (Context) init.lookup("java:/comp/env");
        return (String) cont.lookup(name);
    }
}
