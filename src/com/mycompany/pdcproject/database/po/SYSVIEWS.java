package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSVIEWS {

	private String COMPILATIONSCHEMAID;
	private null VIEWDEFINITION;
	private String TABLEID;
	private String CHECKOPTION;


	public String getCOMPILATIONSCHEMAID(){
		return COMPILATIONSCHEMAID;
	}
	public null getVIEWDEFINITION(){
		return VIEWDEFINITION;
	}
	public String getTABLEID(){
		return TABLEID;
	}
	public String getCHECKOPTION(){
		return CHECKOPTION;
	}
	public void setCOMPILATIONSCHEMAID(String COMPILATIONSCHEMAID){
		this.COMPILATIONSCHEMAID=COMPILATIONSCHEMAID;
	}
	public void setVIEWDEFINITION(null VIEWDEFINITION){
		this.VIEWDEFINITION=VIEWDEFINITION;
	}
	public void setTABLEID(String TABLEID){
		this.TABLEID=TABLEID;
	}
	public void setCHECKOPTION(String CHECKOPTION){
		this.CHECKOPTION=CHECKOPTION;
	}
}
