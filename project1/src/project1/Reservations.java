package project1;

import java.util.*;
import java.text.*;


public class Reservations {
	private String name1;
	private Date checkInDate;
	private int stayDays;

	public Reservations(String name1,Date checkInDate,int stayDays){
		this.name1=name1;
		this.checkInDate=checkInDate;
		this.stayDays=stayDays;
	}
	
	public void setName1(String name1){
		this.name1=name1;
	}
	
	public String getName1(){
		return name1;
	}
	
	public void setCheckInDate(Date checkInDate){
		this.checkInDate=checkInDate;
	}
	
	public String getCheckInDate(){
		return (new SimpleDateFormat("dd/MM/yyyy").format(checkInDate));
	}
	
	public void setStayDays(int stayDays){
		this.stayDays=stayDays;
	}
	
	public int getStayDays(){
		return stayDays;
	}
	
}
