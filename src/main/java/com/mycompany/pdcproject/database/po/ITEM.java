package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class ITEM {

	private Integer PRICE;
	private Double BONUS;
	private String NAME;


	public Integer getPRICE(){
		return PRICE;
	}
	public Double getBONUS(){
		return BONUS;
	}
	public String getNAME(){
		return NAME;
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
