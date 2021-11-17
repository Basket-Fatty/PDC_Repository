package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSFOREIGNKEYS {

	private String CONSTRAINTID;
	private String UPDATERULE;
	private String DELETERULE;
	private String KEYCONSTRAINTID;
	private String CONGLOMERATEID;


	public String getCONSTRAINTID(){
		return CONSTRAINTID;
	}
	public String getUPDATERULE(){
		return UPDATERULE;
	}
	public String getDELETERULE(){
		return DELETERULE;
	}
	public String getKEYCONSTRAINTID(){
		return KEYCONSTRAINTID;
	}
	public String getCONGLOMERATEID(){
		return CONGLOMERATEID;
	}
	public void setCONSTRAINTID(String CONSTRAINTID){
		this.CONSTRAINTID=CONSTRAINTID;
	}
	public void setUPDATERULE(String UPDATERULE){
		this.UPDATERULE=UPDATERULE;
	}
	public void setDELETERULE(String DELETERULE){
		this.DELETERULE=DELETERULE;
	}
	public void setKEYCONSTRAINTID(String KEYCONSTRAINTID){
		this.KEYCONSTRAINTID=KEYCONSTRAINTID;
	}
	public void setCONGLOMERATEID(String CONGLOMERATEID){
		this.CONGLOMERATEID=CONGLOMERATEID;
	}
}
