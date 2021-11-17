/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.database.po;

import java.awt.Image;

/**
 *
 * @author Arthur
 */
public class ITEM {
    private String NAME;
    private float BONUS;
    private Image IMAGE;

    public ITEM(){
        
    }

    public ITEM(String NAME, float BONUS, Image IMAGE) {
        this.NAME = NAME;
        this.BONUS = BONUS;
        this.IMAGE = IMAGE;
    }

    public String getNAME() {
        return NAME;
    }

    public float getBONUS() {
        return BONUS;
    }

    public Image getIMAGE() {
        return IMAGE;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setBONUS(float BONUS) {
        this.BONUS = BONUS;
    }

    public void setIMAGE(Image IMAGE) {
        this.IMAGE = IMAGE;
    }

}
