package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSUSERS {

	private String PASSWORD;
	private java.sql.Timestamp LASTMODIFIED;
	private String USERNAME;
	private String HASHINGSCHEME;


	public String getPASSWORD(){
		return PASSWORD;
	}
	public java.sql.Timestamp getLASTMODIFIED(){
		return LASTMODIFIED;
	}
	public String getUSERNAME(){
		return USERNAME;
	}
	public String getHASHINGSCHEME(){
		return HASHINGSCHEME;
	}
	public void setPASSWORD(String PASSWORD){
		this.PASSWORD=PASSWORD;
	}
	public void setLASTMODIFIED(java.sql.Timestamp LASTMODIFIED){
		this.LASTMODIFIED=LASTMODIFIED;
	}
	public void setUSERNAME(String USERNAME){
		this.USERNAME=USERNAME;
	}
	public void setHASHINGSCHEME(String HASHINGSCHEME){
		this.HASHINGSCHEME=HASHINGSCHEME;
	}
}
