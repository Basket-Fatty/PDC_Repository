package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSSEQUENCES {

	private Long CURRENTVALUE;
	private Long INCREMENT;
	private String SEQUENCENAME;
	private Long MINIMUMVALUE;
	private String SEQUENCEID;
	private null SEQUENCEDATATYPE;
	private String CYCLEOPTION;
	private String SCHEMAID;
	private Long STARTVALUE;
	private Long MAXIMUMVALUE;


	public Long getCURRENTVALUE(){
		return CURRENTVALUE;
	}
	public Long getINCREMENT(){
		return INCREMENT;
	}
	public String getSEQUENCENAME(){
		return SEQUENCENAME;
	}
	public Long getMINIMUMVALUE(){
		return MINIMUMVALUE;
	}
	public String getSEQUENCEID(){
		return SEQUENCEID;
	}
	public null getSEQUENCEDATATYPE(){
		return SEQUENCEDATATYPE;
	}
	public String getCYCLEOPTION(){
		return CYCLEOPTION;
	}
	public String getSCHEMAID(){
		return SCHEMAID;
	}
	public Long getSTARTVALUE(){
		return STARTVALUE;
	}
	public Long getMAXIMUMVALUE(){
		return MAXIMUMVALUE;
	}
	public void setCURRENTVALUE(Long CURRENTVALUE){
		this.CURRENTVALUE=CURRENTVALUE;
	}
	public void setINCREMENT(Long INCREMENT){
		this.INCREMENT=INCREMENT;
	}
	public void setSEQUENCENAME(String SEQUENCENAME){
		this.SEQUENCENAME=SEQUENCENAME;
	}
	public void setMINIMUMVALUE(Long MINIMUMVALUE){
		this.MINIMUMVALUE=MINIMUMVALUE;
	}
	public void setSEQUENCEID(String SEQUENCEID){
		this.SEQUENCEID=SEQUENCEID;
	}
	public void setSEQUENCEDATATYPE(null SEQUENCEDATATYPE){
		this.SEQUENCEDATATYPE=SEQUENCEDATATYPE;
	}
	public void setCYCLEOPTION(String CYCLEOPTION){
		this.CYCLEOPTION=CYCLEOPTION;
	}
	public void setSCHEMAID(String SCHEMAID){
		this.SCHEMAID=SCHEMAID;
	}
	public void setSTARTVALUE(Long STARTVALUE){
		this.STARTVALUE=STARTVALUE;
	}
	public void setMAXIMUMVALUE(Long MAXIMUMVALUE){
		this.MAXIMUMVALUE=MAXIMUMVALUE;
	}
}
