package project1;
import java.util.*;

public class TrieNode {
	TrieNode[] arr;
    boolean isEnd;
    public ArrayList<Reservations> nameList;
    public ArrayList<String> hotelName;
    
    public ArrayList<String> getHotelName() {
		return hotelName;
	}
    

	public void setHotelName(ArrayList<String> hotelName) {
		this.hotelName = hotelName;
	}

	public ArrayList<Reservations> getNameList() {
		return this.nameList;
		
	}
	
    public TrieNode() {
        this.arr = new TrieNode[26];
        nameList =new ArrayList<Reservations>();
        hotelName=new ArrayList<String>();
        for(int i=0;i<26;i++){
        	arr[i]=null;
        }
    }
}
