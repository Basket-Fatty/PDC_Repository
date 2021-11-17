package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSTABLES {

	private String TABLENAME;
	private String TABLEID;
	private String LOCKGRANULARITY;
	private String TABLETYPE;
	private String SCHEMAID;


	public String getTABLENAME(){
		return TABLENAME;
	}
	public String getTABLEID(){
		return TABLEID;
	}
	public String getLOCKGRANULARITY(){
		return LOCKGRANULARITY;
	}
	public String getTABLETYPE(){
		return TABLETYPE;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public void setTABLENAME(String TABLENAME){
		this.TABLENAME=TABLENAME;
	}
	public void setTABLEID(String TABLEID){
		this.TABLEID=TABLEID;
	}
	public void setLOCKGRANULARITY(String LOCKGRANULARITY){
		this.LOCKGRANULARITY=LOCKGRANULARITY;
	}
	public void setTABLETYPE(String TABLETYPE){
		this.TABLETYPE=TABLETYPE;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
}
