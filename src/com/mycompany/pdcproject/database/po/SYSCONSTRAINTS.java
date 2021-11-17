package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSCONSTRAINTS {

	private String CONSTRAINTID;
	private String TABLEID;
	private String STATE;
	private String SCHEMAID;
	private String TYPE;
	private String CONSTRAINTNAME;
	private Integer REFERENCECOUNT;


	public String getCONSTRAINTID(){
		return CONSTRAINTID;
	}
	public String getTABLEID(){
		return TABLEID;
	}
	public String getSTATE(){
		return STATE;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public String getTYPE(){
		return TYPE;
	}
	public String getCONSTRAINTNAME(){
		return CONSTRAINTNAME;
	}
	public Integer getREFERENCECOUNT(){
		return REFERENCECOUNT;
	}
	public void setCONSTRAINTID(String CONSTRAINTID){
		this.CONSTRAINTID=CONSTRAINTID;
	}
	public void setTABLEID(String TABLEID){
		this.TABLEID=TABLEID;
	}
	public void setSTATE(String STATE){
		this.STATE=STATE;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
	public void setTYPE(String TYPE){
		this.TYPE=TYPE;
	}
	public void setCONSTRAINTNAME(String CONSTRAINTNAME){
		this.CONSTRAINTNAME=CONSTRAINTNAME;
	}
	public void setREFERENCECOUNT(Integer REFERENCECOUNT){
		this.REFERENCECOUNT=REFERENCECOUNT;
	}
}
