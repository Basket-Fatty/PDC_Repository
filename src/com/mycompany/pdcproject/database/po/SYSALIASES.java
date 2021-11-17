package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSALIASES {

	private String NAMESPACE;
	private null ALIASINFO;
	private String ALIASID;
	private null JAVACLASSNAME;
	private String ALIAS;
	private String SPECIFICNAME;
	private null SYSTEMALIAS;
	private String SCHEMAID;
	private String ALIASTYPE;


	public String getNAMESPACE(){
		return NAMESPACE;
	}
	public null getALIASINFO(){
		return ALIASINFO;
	}
	public String getALIASID(){
		return ALIASID;
	}
	public null getJAVACLASSNAME(){
		return JAVACLASSNAME;
	}
	public String getALIAS(){
		return ALIAS;
	}
	public String getSPECIFICNAME(){
		return SPECIFICNAME;
	}
	public null getSYSTEMALIAS(){
		return SYSTEMALIAS;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public String getALIASTYPE(){
		return ALIASTYPE;
	}
	public void setNAMESPACE(String NAMESPACE){
		this.NAMESPACE=NAMESPACE;
	}
	public void setALIASINFO(null ALIASINFO){
		this.ALIASINFO=ALIASINFO;
	}
	public void setALIASID(String ALIASID){
		this.ALIASID=ALIASID;
	}
	public void setJAVACLASSNAME(null JAVACLASSNAME){
		this.JAVACLASSNAME=JAVACLASSNAME;
	}
	public void setALIAS(String ALIAS){
		this.ALIAS=ALIAS;
	}
	public void setSPECIFICNAME(String SPECIFICNAME){
		this.SPECIFICNAME=SPECIFICNAME;
	}
	public void setSYSTEMALIAS(null SYSTEMALIAS){
		this.SYSTEMALIAS=SYSTEMALIAS;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
	public void setALIASTYPE(String ALIASTYPE){
		this.ALIASTYPE=ALIASTYPE;
	}
}
