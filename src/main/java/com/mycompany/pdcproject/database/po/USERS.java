package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class USERS {

	private Integer MONEY;
	private Boolean ISWEARED;
	private Double BONUS;
	private String ITEMS;
	private String PWD;
	private String NAME;


	public Integer getMONEY(){
		return MONEY;
	}
	public Boolean getISWEARED(){
		return ISWEARED;
	}
	public Double getBONUS(){
		return BONUS;
	}
	public String getITEMS(){
		return ITEMS;
	}
	public String getPWD(){
		return PWD;
	}
	public String getNAME(){
		return NAME;
	}
	public void setMONEY(Integer MONEY){
		this.MONEY=MONEY;
	}
	public void setISWEARED(Boolean ISWEARED){
		this.ISWEARED=ISWEARED;
	}
	public void setBONUS(Double BONUS){
		this.BONUS=BONUS;
	}
	public void setITEMS(String ITEMS){
		this.ITEMS=ITEMS;
	}
	public void setPWD(String PWD){
		this.PWD=PWD;
	}
	public void setNAME(String NAME){
		this.NAME=NAME;
	}
}
