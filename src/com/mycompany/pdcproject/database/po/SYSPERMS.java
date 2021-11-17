package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSPERMS {

	private String OBJECTID;
	private String PERMISSION;
	private String ISGRANTABLE;
	private String OBJECTTYPE;
	private String UUID;
	private String GRANTEE;
	private String GRANTOR;


	public String getOBJECTID(){
		return OBJECTID;
	}
	public String getPERMISSION(){
		return PERMISSION;
	}
	public String getISGRANTABLE(){
		return ISGRANTABLE;
	}
	public String getOBJECTTYPE(){
		return OBJECTTYPE;
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
	public void setOBJECTID(String OBJECTID){
		this.OBJECTID=OBJECTID;
	}
	public void setPERMISSION(String PERMISSION){
		this.PERMISSION=PERMISSION;
	}
	public void setISGRANTABLE(String ISGRANTABLE){
		this.ISGRANTABLE=ISGRANTABLE;
	}
	public void setOBJECTTYPE(String OBJECTTYPE){
		this.OBJECTTYPE=OBJECTTYPE;
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
