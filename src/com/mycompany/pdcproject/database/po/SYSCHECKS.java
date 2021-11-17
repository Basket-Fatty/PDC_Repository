package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSCHECKS {

	private String CONSTRAINTID;
	private null CHECKDEFINITION;
	private null REFERENCEDCOLUMNS;


	public String getCONSTRAINTID(){
		return CONSTRAINTID;
	}
	public null getCHECKDEFINITION(){
		return CHECKDEFINITION;
	}
	public null getREFERENCEDCOLUMNS(){
		return REFERENCEDCOLUMNS;
	}
	public void setCONSTRAINTID(String CONSTRAINTID){
		this.CONSTRAINTID=CONSTRAINTID;
	}
	public void setCHECKDEFINITION(null CHECKDEFINITION){
		this.CHECKDEFINITION=CHECKDEFINITION;
	}
	public void setREFERENCEDCOLUMNS(null REFERENCEDCOLUMNS){
		this.REFERENCEDCOLUMNS=REFERENCEDCOLUMNS;
	}
}
