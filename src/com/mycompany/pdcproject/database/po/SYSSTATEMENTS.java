package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSSTATEMENTS {

	private String COMPILATIONSCHEMAID;
	private String STMTID;
	private String STMTNAME;
	private null VALID;
	private null TEXT;
	private null USINGTEXT;
	private java.sql.Timestamp LASTCOMPILED;
	private String SCHEMAID;
	private String TYPE;


	public String getCOMPILATIONSCHEMAID(){
		return COMPILATIONSCHEMAID;
	}
	public String getSTMTID(){
		return STMTID;
	}
	public String getSTMTNAME(){
		return STMTNAME;
	}
	public null getVALID(){
		return VALID;
	}
	public null getTEXT(){
		return TEXT;
	}
	public null getUSINGTEXT(){
		return USINGTEXT;
	}
	public java.sql.Timestamp getLASTCOMPILED(){
		return LASTCOMPILED;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public String getTYPE(){
		return TYPE;
	}
	public void setCOMPILATIONSCHEMAID(String COMPILATIONSCHEMAID){
		this.COMPILATIONSCHEMAID=COMPILATIONSCHEMAID;
	}
	public void setSTMTID(String STMTID){
		this.STMTID=STMTID;
	}
	public void setSTMTNAME(String STMTNAME){
		this.STMTNAME=STMTNAME;
	}
	public void setVALID(null VALID){
		this.VALID=VALID;
	}
	public void setTEXT(null TEXT){
		this.TEXT=TEXT;
	}
	public void setUSINGTEXT(null USINGTEXT){
		this.USINGTEXT=USINGTEXT;
	}
	public void setLASTCOMPILED(java.sql.Timestamp LASTCOMPILED){
		this.LASTCOMPILED=LASTCOMPILED;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
	public void setTYPE(String TYPE){
		this.TYPE=TYPE;
	}
}
