package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSROLES {

	private String ISDEF;
	private String WITHADMINOPTION;
	private String ROLEID;
	private String UUID;
	private String GRANTEE;
	private String GRANTOR;


	public String getISDEF(){
		return ISDEF;
	}
	public String getWITHADMINOPTION(){
		return WITHADMINOPTION;
	}
	public String getROLEID(){
		return ROLEID;
	}
	public String getUUID(){
		return UUID;
	}
	public String getGRANTEE(){
		return GRANTEE;
	}
	public String getGRANTOR(){
		return GRANTOR;
	}
	public void setISDEF(String ISDEF){
		this.ISDEF=ISDEF;
	}
	public void setWITHADMINOPTION(String WITHADMINOPTION){
		this.WITHADMINOPTION=WITHADMINOPTION;
	}
	public void setROLEID(String ROLEID){
		this.ROLEID=ROLEID;
	}
	public void setUUID(String UUID){
		this.UUID=UUID;
	}
	public void setGRANTEE(String GRANTEE){
		this.GRANTEE=GRANTEE;
	}
	public void setGRANTOR(String GRANTOR){
		this.GRANTOR=GRANTOR;
	}
}
