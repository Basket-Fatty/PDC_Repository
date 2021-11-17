/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pdcproject.database.po;

/**
 *
 * @author Arthur
 */
public class RECORD {
    private String NAME;
    private int SCORE;

    public RECORD(){
        
    }

    public RECORD(String NAME, int SCORE) {
        this.NAME = NAME;
        this.SCORE = SCORE;
    }

    public String getNAME() {
        return NAME;
    }

    public int getSCORE() {
        return SCORE;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setSCORE(int SCORE) {
        this.SCORE = SCORE;
    }
    
}
