package com.mycompany.pdcproject.database.po;

import java.sql.*;
import java.util.*;

public class SYSDEPENDS {

	private String DEPENDENTID;
	private String PROVIDERID;
	private null DEPENDENTFINDER;
	private null PROVIDERFINDER;


	public String getDEPENDENTID(){
		return DEPENDENTID;
	}
	public String getPROVIDERID(){
		return PROVIDERID;
	}
	public null getDEPENDENTFINDER(){
		return DEPENDENTFINDER;
	}
	public null getPROVIDERFINDER(){
		return PROVIDERFINDER;
	}
	public void setDEPENDENTID(String DEPENDENTID){
		this.DEPENDENTID=DEPENDENTID;
	}
	public void setPROVIDERID(String PROVIDERID){
		this.PROVIDERID=PROVIDERID;
	}
	public void setDEPENDENTFINDER(null DEPENDENTFINDER){
		this.DEPENDENTFINDER=DEPENDENTFINDER;
	}
	public void setPROVIDERFINDER(null PROVIDERFINDER){
		this.PROVIDERFINDER=PROVIDERFINDER;
	}
}
