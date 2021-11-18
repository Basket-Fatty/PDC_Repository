package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class Users {

	private Integer money;
	private Boolean isweared;
	private Double bonus;
	private String items;
	private String pwd;
	private String name;


	public Integer getMoney(){
		return money;
	}
	public Boolean getIsweared(){
		return isweared;
	}
	public Double getBonus(){
		return bonus;
	}
	public String getItems(){
		return items;
	}
	public String getPwd(){
		return pwd;
	}
	public String getName(){
		return name;
	}
	public void setMoney(Integer money){
		this.money=money;
	}
	public void setIsweared(Boolean isweared){
		this.isweared=isweared;
	}
	public void setBonus(Double bonus){
		this.bonus=bonus;
	}
	public void setItems(String items){
		this.items=items;
	}
	public void setPwd(String pwd){
		this.pwd=pwd;
	}
	public void setName(String name){
		this.name=name;
	}
}
