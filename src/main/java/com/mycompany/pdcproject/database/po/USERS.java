/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.database.po;

import java.util.List;

/**
 *
 * @author Arthur
 */
public class USERS {
    private String NAME;
    private String PWD;

    public USERS(){
        
    }

    public USERS(String NAME, String PWD) {
        this.NAME = NAME;
        this.PWD = PWD;
    }

    public String getNAME() {
        return NAME;
    }

    public String getPWD() {
        return PWD;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }
   
}
