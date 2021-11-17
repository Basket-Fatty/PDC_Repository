package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSSTATISTICS {

	private String TABLEID;
	private null STATISTICS;
	private null VALID;
	private String REFERENCEID;
	private java.sql.Timestamp CREATIONTIMESTAMP;
	private String TYPE;
	private String STATID;
	private Integer COLCOUNT;


	public String getTABLEID(){
		return TABLEID;
	}
	public null getSTATISTICS(){
		return STATISTICS;
	}
	public null getVALID(){
		return VALID;
	}
	public String getREFERENCEID(){
		return REFERENCEID;
	}
	public java.sql.Timestamp getCREATIONTIMESTAMP(){
		return CREATIONTIMESTAMP;
	}
	public String getTYPE(){
		return TYPE;
	}
	public String getSTATID(){
		return STATID;
	}
	public Integer getCOLCOUNT(){
		return COLCOUNT;
	}
	public void setTABLEID(String TABLEID){
		this.TABLEID=TABLEID;
	}
	public void setSTATISTICS(null STATISTICS){
		this.STATISTICS=STATISTICS;
	}
	public void setVALID(null VALID){
		this.VALID=VALID;
	}
	public void setREFERENCEID(String REFERENCEID){
		this.REFERENCEID=REFERENCEID;
	}
	public void setCREATIONTIMESTAMP(java.sql.Timestamp CREATIONTIMESTAMP){
		this.CREATIONTIMESTAMP=CREATIONTIMESTAMP;
	}
	public void setTYPE(String TYPE){
		this.TYPE=TYPE;
	}
	public void setSTATID(String STATID){
		this.STATID=STATID;
	}
	public void setCOLCOUNT(Integer COLCOUNT){
		this.COLCOUNT=COLCOUNT;
	}
}
