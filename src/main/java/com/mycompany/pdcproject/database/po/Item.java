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
public class Item {
    private String name;
    private float bonus;
    private Image image;

    public Item(String name, float bonus, Image image) {
        this.name = name;
        this.bonus = bonus;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public float getBonus() {
        return bonus;
    }

    public Image getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    
}
