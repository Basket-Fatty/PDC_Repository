package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class USERS {

	private Integer MONEY;
	private String PWD;
	private String NAME;


	public Integer getMONEY(){
		return MONEY;
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
	public void setPWD(String PWD){
		this.PWD=PWD;
	}
	public void setNAME(String NAME){
		this.NAME=NAME;
	}
}
