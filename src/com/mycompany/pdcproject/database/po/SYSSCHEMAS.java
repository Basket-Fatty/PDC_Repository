package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSSCHEMAS {

	private String SCHEMANAME;
	private String SCHEMAID;
	private String AUTHORIZATIONID;


	public String getSCHEMANAME(){
		return SCHEMANAME;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public String getAUTHORIZATIONID(){
		return AUTHORIZATIONID;
	}
	public void setSCHEMANAME(String SCHEMANAME){
		this.SCHEMANAME=SCHEMANAME;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
	public void setAUTHORIZATIONID(String AUTHORIZATIONID){
		this.AUTHORIZATIONID=AUTHORIZATIONID;
	}
}
