package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class RECORD {

	private Integer DISTANCE;
	private Integer SCORE;
	private String NAME;


	public Integer getDISTANCE(){
		return DISTANCE;
	}
	public Integer getSCORE(){
		return SCORE;
	}
	public String getNAME(){
		return NAME;
	}
	public void setDISTANCE(Integer DISTANCE){
		this.DISTANCE=DISTANCE;
	}
	public void setSCORE(Integer SCORE){
		this.SCORE=SCORE;
	}
	public void setNAME(String NAME){
		this.NAME=NAME;
	}
}
