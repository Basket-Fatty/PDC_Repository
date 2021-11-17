package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSROUTINEPERMS {

	private String ALIASID;
	private String GRANTOPTION;
	private String GRANTEE;
	private String ROUTINEPERMSID;
	private String GRANTOR;


	public String getALIASID(){
		return ALIASID;
	}
	public String getGRANTOPTION(){
		return GRANTOPTION;
	}
	public String getGRANTEE(){
		return GRANTEE;
	}
	public String getROUTINEPERMSID(){
		return ROUTINEPERMSID;
	}
	public String getGRANTOR(){
		return GRANTOR;
	}
	public void setALIASID(String ALIASID){
		this.ALIASID=ALIASID;
	}
	public void setGRANTOPTION(String GRANTOPTION){
		this.GRANTOPTION=GRANTOPTION;
	}
	public void setGRANTEE(String GRANTEE){
		this.GRANTEE=GRANTEE;
	}
	public void setROUTINEPERMSID(String ROUTINEPERMSID){
		this.ROUTINEPERMSID=ROUTINEPERMSID;
	}
	public void setGRANTOR(String GRANTOR){
		this.GRANTOR=GRANTOR;
	}
}
