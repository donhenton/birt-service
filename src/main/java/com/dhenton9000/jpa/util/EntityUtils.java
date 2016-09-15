/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.util;

/**
 *
 * @author dhenton
 */
public class EntityUtils {
 
    public static String trimField(String f)
    {
        if (f != null) {
            return f.trim();
        } else {
            return null;
        }
    }
    
}
