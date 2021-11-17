package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class RECORD {

	private Integer SOCRE;
	private String NAME;


	public Integer getSOCRE(){
		return SOCRE;
	}
	public String getNAME(){
		return NAME;
	}
	public void setSOCRE(Integer SOCRE){
		this.SOCRE=SOCRE;
	}
	public void setNAME(String NAME){
		this.NAME=NAME;
	}
}
