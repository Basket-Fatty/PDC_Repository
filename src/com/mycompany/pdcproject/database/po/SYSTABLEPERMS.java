package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSTABLEPERMS {

	private String TABLEPERMSID;
	private String TABLEID;
	private String INSERTPRIV;
	private String SELECTPRIV;
	private String REFERENCESPRIV;
	private String UPDATEPRIV;
	private String GRANTEE;
	private String DELETEPRIV;
	private String TRIGGERPRIV;
	private String GRANTOR;


	public String getTABLEPERMSID(){
		return TABLEPERMSID;
	}
	public String getTABLEID(){
		return TABLEID;
	}
	public String getINSERTPRIV(){
		return INSERTPRIV;
	}
	public String getSELECTPRIV(){
		return SELECTPRIV;
	}
	public String getREFERENCESPRIV(){
		return REFERENCESPRIV;
	}
	public String getUPDATEPRIV(){
		return UPDATEPRIV;
	}
	public String getGRANTEE(){
		return GRANTEE;
	}
	public String getDELETEPRIV(){
		return DELETEPRIV;
	}
	public String getTRIGGERPRIV(){
		return TRIGGERPRIV;
	}
	public String getGRANTOR(){
		return GRANTOR;
	}
	public void setTABLEPERMSID(String TABLEPERMSID){
		this.TABLEPERMSID=TABLEPERMSID;
	}
	public void setTABLEID(String TABLEID){
		this.TABLEID=TABLEID;
	}
	public void setINSERTPRIV(String INSERTPRIV){
		this.INSERTPRIV=INSERTPRIV;
	}
	public void setSELECTPRIV(String SELECTPRIV){
		this.SELECTPRIV=SELECTPRIV;
	}
	public void setREFERENCESPRIV(String REFERENCESPRIV){
		this.REFERENCESPRIV=REFERENCESPRIV;
	}
	public void setUPDATEPRIV(String UPDATEPRIV){
		this.UPDATEPRIV=UPDATEPRIV;
	}
	public void setGRANTEE(String GRANTEE){
		this.GRANTEE=GRANTEE;
	}
	public void setDELETEPRIV(String DELETEPRIV){
		this.DELETEPRIV=DELETEPRIV;
	}
	public void setTRIGGERPRIV(String TRIGGERPRIV){
		this.TRIGGERPRIV=TRIGGERPRIV;
	}
	public void setGRANTOR(String GRANTOR){
		this.GRANTOR=GRANTOR;
	}
}
