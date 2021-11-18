package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class Record {

	private Integer distance;
	private Integer score;
	private String name;


	public Integer getDistance(){
		return distance;
	}
	public Integer getScore(){
		return score;
	}
	public String getName(){
		return name;
	}
	public void setDistance(Integer distance){
		this.distance=distance;
	}
	public void setScore(Integer score){
		this.score=score;
	}
	public void setName(String name){
		this.name=name;
	}
}
