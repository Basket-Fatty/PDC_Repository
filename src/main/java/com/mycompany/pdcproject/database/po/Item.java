package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class Item {

	private Integer price;
	private Double bonus;
	private String name;


	public Integer getPrice(){
		return price;
	}
	public Double getBonus(){
		return bonus;
	}
	public String getName(){
		return name;
	}
	public void setPrice(Integer price){
		this.price=price;
	}
	public void setBonus(Double bonus){
		this.bonus=bonus;
	}
	public void setName(String name){
		this.name=name;
	}
}
