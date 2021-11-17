package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class USERS {

	private String PWD;
	private String NAME;


	public String getPWD(){
		return PWD;
	}
	public String getNAME(){
		return NAME;
	}
	public void setPWD(String PWD){
		this.PWD=PWD;
	}
	public void setNAME(String NAME){
		this.NAME=NAME;
	}
}
