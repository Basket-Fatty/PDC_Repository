package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSCONGLOMERATES {

	private null DESCRIPTOR;
	private String TABLEID;
	private String CONGLOMERATENAME;
	private null ISCONSTRAINT;
	private null ISINDEX;
	private Long CONGLOMERATENUMBER;
	private String SCHEMAID;
	private String CONGLOMERATEID;


	public null getDESCRIPTOR(){
		return DESCRIPTOR;
	}
	public String getTABLEID(){
		return TABLEID;
	}
	public String getCONGLOMERATENAME(){
		return CONGLOMERATENAME;
	}
	public null getISCONSTRAINT(){
		return ISCONSTRAINT;
	}
	public null getISINDEX(){
		return ISINDEX;
	}
	public Long getCONGLOMERATENUMBER(){
		return CONGLOMERATENUMBER;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public String getCONGLOMERATEID(){
		return CONGLOMERATEID;
	}
	public void setDESCRIPTOR(null DESCRIPTOR){
		this.DESCRIPTOR=DESCRIPTOR;
	}
	public void setTABLEID(String TABLEID){
		this.TABLEID=TABLEID;
	}
	public void setCONGLOMERATENAME(String CONGLOMERATENAME){
		this.CONGLOMERATENAME=CONGLOMERATENAME;
	}
	public void setISCONSTRAINT(null ISCONSTRAINT){
		this.ISCONSTRAINT=ISCONSTRAINT;
	}
	public void setISINDEX(null ISINDEX){
		this.ISINDEX=ISINDEX;
	}
	public void setCONGLOMERATENUMBER(Long CONGLOMERATENUMBER){
		this.CONGLOMERATENUMBER=CONGLOMERATENUMBER;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
	public void setCONGLOMERATEID(String CONGLOMERATEID){
		this.CONGLOMERATEID=CONGLOMERATEID;
	}
}
