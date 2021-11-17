package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class ITEM {

	private java.sql.Blob IMAGE;
	private Double BONUS;
	private String NAME;


	public java.sql.Blob getIMAGE(){
		return IMAGE;
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
	public void setBONUS(Double BONUS){
		this.BONUS=BONUS;
	}
	public void setNAME(String NAME){
		this.NAME=NAME;
	}
}
