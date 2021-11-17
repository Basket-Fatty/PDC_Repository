package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class ITEM {

	private java.sql.Blob IMAGE;
	private Integer PRICE;
	private Double BONUS;
	private String NAME;


	public java.sql.Blob getIMAGE(){
		return IMAGE;
	}
	public Integer getPRICE(){
		return PRICE;
	}
	public Double getBONUS(){
		return BONUS;
	}
	public String getNAME(){
		return NAME;
	}
	public void setIMAGE(java.sql.Blob IMAGE){
		this.IMAGE=IMAGE;
	}
	public void setPRICE(Integer PRICE){
		this.PRICE=PRICE;
	}
	public void setBONUS(Double BONUS){
		this.BONUS=BONUS;
	}
	public void setNAME(String NAME){
		this.NAME=NAME;
	}
}
