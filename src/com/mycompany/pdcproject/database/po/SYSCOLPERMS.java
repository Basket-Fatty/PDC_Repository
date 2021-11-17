package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSCOLPERMS {

	private String TABLEID;
	private String COLPERMSID;
	private null COLUMNS;
	private String GRANTEE;
	private String TYPE;
	private String GRANTOR;


	public String getTABLEID(){
		return TABLEID;
	}
	public String getCOLPERMSID(){
		return COLPERMSID;
	}
	public null getCOLUMNS(){
		return COLUMNS;
	}
	public String getGRANTEE(){
		return GRANTEE;
	}
	public String getTYPE(){
		return TYPE;
	}
	public String getGRANTOR(){
		return GRANTOR;
	}
	public void setTABLEID(String TABLEID){
		this.TABLEID=TABLEID;
	}
	public void setCOLPERMSID(String COLPERMSID){
		this.COLPERMSID=COLPERMSID;
	}
	public void setCOLUMNS(null COLUMNS){
		this.COLUMNS=COLUMNS;
	}
	public void setGRANTEE(String GRANTEE){
		this.GRANTEE=GRANTEE;
	}
	public void setTYPE(String TYPE){
		this.TYPE=TYPE;
	}
	public void setGRANTOR(String GRANTOR){
		this.GRANTOR=GRANTOR;
	}
}
