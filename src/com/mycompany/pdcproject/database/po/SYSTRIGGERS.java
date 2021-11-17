package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSTRIGGERS {

	private String ACTIONSTMTID;
	private String NEWREFERENCINGNAME;
	private String FIRINGTIME;
	private String STATE;
	private java.sql.Timestamp CREATIONTIMESTAMP;
	private String TRIGGERNAME;
	private String SCHEMAID;
	private String EVENT;
	private null REFERENCEDCOLUMNS;
	private String WHENSTMTID;
	private null WHENCLAUSETEXT;
	private String TABLEID;
	private String OLDREFERENCINGNAME;
	private null REFERENCINGOLD;
	private String TYPE;
	private null TRIGGERDEFINITION;
	private null REFERENCINGNEW;
	private String TRIGGERID;


	public String getACTIONSTMTID(){
		return ACTIONSTMTID;
	}
	public String getNEWREFERENCINGNAME(){
		return NEWREFERENCINGNAME;
	}
	public String getFIRINGTIME(){
		return FIRINGTIME;
	}
	public String getSTATE(){
		return STATE;
	}
	public java.sql.Timestamp getCREATIONTIMESTAMP(){
		return CREATIONTIMESTAMP;
	}
	public String getTRIGGERNAME(){
		return TRIGGERNAME;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public String getEVENT(){
		return EVENT;
	}
	public null getREFERENCEDCOLUMNS(){
		return REFERENCEDCOLUMNS;
	}
	public String getWHENSTMTID(){
		return WHENSTMTID;
	}
	public null getWHENCLAUSETEXT(){
		return WHENCLAUSETEXT;
	}
	public String getTABLEID(){
		return TABLEID;
	}
	public String getOLDREFERENCINGNAME(){
		return OLDREFERENCINGNAME;
	}
	public null getREFERENCINGOLD(){
		return REFERENCINGOLD;
	}
	public String getTYPE(){
		return TYPE;
	}
	public null getTRIGGERDEFINITION(){
		return TRIGGERDEFINITION;
	}
	public null getREFERENCINGNEW(){
		return REFERENCINGNEW;
	}
	public String getTRIGGERID(){
		return TRIGGERID;
	}
	public void setACTIONSTMTID(String ACTIONSTMTID){
		this.ACTIONSTMTID=ACTIONSTMTID;
	}
	public void setNEWREFERENCINGNAME(String NEWREFERENCINGNAME){
		this.NEWREFERENCINGNAME=NEWREFERENCINGNAME;
	}
	public void setFIRINGTIME(String FIRINGTIME){
		this.FIRINGTIME=FIRINGTIME;
	}
	public void setSTATE(String STATE){
		this.STATE=STATE;
	}
	public void setCREATIONTIMESTAMP(java.sql.Timestamp CREATIONTIMESTAMP){
		this.CREATIONTIMESTAMP=CREATIONTIMESTAMP;
	}
	public void setTRIGGERNAME(String TRIGGERNAME){
		this.TRIGGERNAME=TRIGGERNAME;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
	public void setEVENT(String EVENT){
		this.EVENT=EVENT;
	}
	public void setREFERENCEDCOLUMNS(null REFERENCEDCOLUMNS){
		this.REFERENCEDCOLUMNS=REFERENCEDCOLUMNS;
	}
	public void setWHENSTMTID(String WHENSTMTID){
		this.WHENSTMTID=WHENSTMTID;
	}
	public void setWHENCLAUSETEXT(null WHENCLAUSETEXT){
		this.WHENCLAUSETEXT=WHENCLAUSETEXT;
	}
	public void setTABLEID(String TABLEID){
		this.TABLEID=TABLEID;
	}
	public void setOLDREFERENCINGNAME(String OLDREFERENCINGNAME){
		this.OLDREFERENCINGNAME=OLDREFERENCINGNAME;
	}
	public void setREFERENCINGOLD(null REFERENCINGOLD){
		this.REFERENCINGOLD=REFERENCINGOLD;
	}
	public void setTYPE(String TYPE){
		this.TYPE=TYPE;
	}
	public void setTRIGGERDEFINITION(null TRIGGERDEFINITION){
		this.TRIGGERDEFINITION=TRIGGERDEFINITION;
	}
	public void setREFERENCINGNEW(null REFERENCINGNEW){
		this.REFERENCINGNEW=REFERENCINGNEW;
	}
	public void setTRIGGERID(String TRIGGERID){
		this.TRIGGERID=TRIGGERID;
	}
}
