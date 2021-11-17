package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSFILES {

	private Long GENERATIONID;
	private String FILEID;
	private String SCHEMAID;
	private String FILENAME;


	public Long getGENERATIONID(){
		return GENERATIONID;
	}
	public String getFILEID(){
		return FILEID;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public String getFILENAME(){
		return FILENAME;
	}
	public void setGENERATIONID(Long GENERATIONID){
		this.GENERATIONID=GENERATIONID;
	}
	public void setFILEID(String FILEID){
		this.FILEID=FILEID;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
	public void setFILENAME(String FILENAME){
		this.FILENAME=FILENAME;
	}
}
