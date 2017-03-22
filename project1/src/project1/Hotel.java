package project1;
import java.util.*;

public class Hotel {
	private int id;
	private String name;
	private int stars;
	private int numOfRooms;
	ArrayList<Reservations> reseList;
	
	
	public Hotel(int id,String name,int stars,int numOfRooms,ArrayList<Reservations> reseList){
		this.id=id;
		this.name=name;
		this.stars=stars;
		this.numOfRooms=numOfRooms;
		this.reseList=reseList;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setStars(int stars){
		this.stars=stars;
	}
	
	public int getStars(){
		return stars;
	}
	
	public void setNumOfRooms(int numOfRooms){
		this.numOfRooms=numOfRooms;
	}
	
	public int getNumOfRooms(){
		return numOfRooms;
	}
	
	public ArrayList<Reservations> getReseList(){
		return reseList;
	}
}
