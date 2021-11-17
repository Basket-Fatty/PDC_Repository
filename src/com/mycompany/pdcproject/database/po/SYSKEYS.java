package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSKEYS {

	private String CONSTRAINTID;
	private String CONGLOMERATEID;


	public String getCONSTRAINTID(){
		return CONSTRAINTID;
	}
	public String getCONGLOMERATEID(){
		return CONGLOMERATEID;
	}
	public void setCONSTRAINTID(String CONSTRAINTID){
		this.CONSTRAINTID=CONSTRAINTID;
	}
	public void setCONGLOMERATEID(String CONGLOMERATEID){
		this.CONGLOMERATEID=CONGLOMERATEID;
	}
}
