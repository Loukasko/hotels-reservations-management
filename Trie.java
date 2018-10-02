package project1;
import java.util.*;
public class Trie {
	public static TrieNode tRoot;

	public Trie() {
		tRoot=new TrieNode();
	}
	public static void insert(String word,String hotelName,Reservations reserves) {
		
        TrieNode p = tRoot;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;
                p = temp;
            }else{
                p=p.arr[index];
            }
        }
        p.isEnd=true;
        p.getHotelName().add(hotelName);
        p.getNameList().add(reserves);
    }
	
	public static ArrayList<Reservations> search(String word) {
        TrieNode p = searchNode(word);
        if(p==null){
            return null;
        }else{
            if(p.isEnd)
                return p.getNameList();
            	
        }
 
        return null;
    }
	public static ArrayList<String> search(String word,int x) {
        TrieNode p = searchNode(word);
        if(p==null){
            return null;
        }else{
            if(p.isEnd)
                return p.getHotelName();
            	
        }
 
        return null;
    }
	

	 public static TrieNode searchNode(String s){
	        TrieNode p = tRoot;
	        for(int i=0; i<s.length(); i++){
	            char c= s.charAt(i);
	            int index = c-'a';
	            if(p.arr[index]!=null){
	                p = p.arr[index];
	            }else{
	                return null;
	            }
	        }
	 
	        if(p==tRoot)
	            return null;
	 
	        return p;
	    }
}
