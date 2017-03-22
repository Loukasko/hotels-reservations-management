package project1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class RunProgramRun {
	static int size;
	static ArrayList<Hotel> hotelList=new ArrayList<Hotel>();
	static RbTree rbtree=new RbTree();
	static Trie trie=new Trie();
	Reservations res;
	static int save=0;
	public static void main(String[] args){
		menu();
		
	}
		
	static public void menu(){
		
		while(true){
		
		System.out.println("1.Load Hotels and Reservations from file");
		System.out.println("2.Save Hotels and Reservations to file");
		System.out.println("3.Add a Hotel with reservations");
		System.out.println("4.Search and Display a Hotel by id");
		System.out.println("5.Display all Hotels of specific stars category and number of reservations");
		System.out.println("6.Display Reservations by surname search");
		System.out.println("7.Exit");
		Scanner sc = new Scanner(System.in);
	    int k = sc.nextInt();
	    
	    switch(k){
	    	case 1:
	    		loadHotels();
	    		System.out.println(hotelList.size());
	    		
	    		break;
	    	case 2:
	    		saveHotels();
	    		break;
	    	case 3:
	    		addHotel();
	    		break;
	    	case 4:
	    		System.out.println("type id");
	    		int id=sc.nextInt();
	    		System.out.println("choose search method");
	    		System.out.println("1.linear");
	    		System.out.println("2.Interpolation");
	    		System.out.println("3.Binary");
	    		System.out.println("4.Red Black Tree");
	    		int z=sc.nextInt();
	    		
	    		
	    		

	    		
	    		switch (z){
	    		
	    			case 1:
	    				
	    				if(linearSearch(id)==null){
	    					System.out.println("not found");
	    				}
	    				else{
	    					long startTime = System.nanoTime();
	    					linearSearch(id);
	    					long endTime = System.nanoTime();
	    					long duration = (endTime - startTime);
	    					System.out.println(linearSearch(id).getName());
	    					System.out.println(duration +"ns duration of search");
	    				}
	    				break;
	    			case 2:
	    				if(interSearch(id)==null){
	    					System.out.println("not found");
	    				}
	    				else{
	    					long startTime = System.nanoTime();
	    					interSearch(id);
	    					long endTime = System.nanoTime();
	    					long duration = (endTime - startTime);
	    					System.out.println(linearSearch(id).getName());
	    					System.out.println(duration+"ns duration of search");
	    				}
	    				break;
	    			case 3:
	    				if(binSearch(id)==null){
	    					System.out.println("not found");
	    				}
	    				else{
	    					long startTime = System.nanoTime();
	    					binSearch(id);
	    					long endTime = System.nanoTime();
	    					long duration = (endTime - startTime);
	    					System.out.println(binSearch(id).getName());
	    					System.out.println(duration+"ns duration of search");
	    				}
	    				break;
	    			case 4:
	    				if(rbtree.search(id)==null){
	    					System.out.println("not found");
	    				}
	    				else{
	    					long startTime = System.nanoTime();
	    					rbtree.search(id);
	    					long endTime = System.nanoTime();
	    					long duration = (endTime - startTime);
	    					System.out.println(rbtree.search(id).getName());
	    					System.out.println(duration+"ns duration of search");
	    				}
	    				
	    				
	    		}
	    		break;
	    		
	    	case 5:
	    		System.out.println("type stars");
	    		int stars=sc.nextInt();
	    		printStarHotel(stars);
	    		break;
	    	case 6:
	    		System.out.println("type name");
	    		String name2=sc.next();
	    		System.out.println("choose search method");
	    		System.out.println("1.linear");
	    		System.out.println("2.Trie");
	    		int y=sc.nextInt();
	    		
	    		switch (y){
	    		
    			case 1:
    				printResByName(name2);
    			break;
    			case 2:
    				if(trie.search(name2)==null){
    					System.out.println("paketo");
    				}else{
    					for(int kl=0;kl<trie.search(name2).size();kl++){
    						System.out.println(trie.search(name2,1).get(kl)+"  " + trie.search(name2).get(kl).getCheckInDate()+ "  " +trie.search(name2).get(kl).getStayDays());
    					}
    				}
	    		}	
	    		break;
	    	case 7:
	    		sc.close();
	    		System.exit(1);
	    	
	    	}
	    }
	}
	

	public static void loadHotels(){
		try{
			String filePath="C:/Users/loukas/Desktop/data.csv";
			File file=new File(filePath);
			Scanner scan = new Scanner(file);
			scan.useDelimiter(";");
			size=Integer.parseInt(scan.next());
			
			String name;
			int id;
			int stars;
			int numOfRooms;
			
			String name1;
			int stayDays=0;
			String csvDate;
			scan.nextLine();
			
			for (int i=0;i<1000;i++){
				ArrayList<Reservations> reseList=new ArrayList<Reservations>();
				String line = scan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(";");
				
				id=Integer.parseInt(lineScan.next());
				name=lineScan.next();
				stars=Integer.parseInt(lineScan.next());
				numOfRooms=Integer.parseInt(lineScan.next());
				int j=1;
				//System.out.println(j+"prin to while kala");
				while(lineScan.hasNext()){
					
					//System.out.println(j+"п сежесвЁ");
					name1=lineScan.next();
					csvDate=lineScan.next();
					
					Date checkInDate = new SimpleDateFormat("dd/MM/yyyy").parse(csvDate);
					//System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(checkInDate));
					if (lineScan.hasNextInt()){
						stayDays=lineScan.nextInt();
					}
					
					Reservations reserve=new Reservations(name1,checkInDate,stayDays);
					j++;
					reseList.add(reserve);
					trie.insert(reserve.getName1().toLowerCase(),name,reserve);
					
				}
				Hotel hotel=new Hotel(id,name,stars,numOfRooms,reseList);
				hotelList.add(hotel);
				rbtree.insert(hotel);
				/*for(int k=1;k<reseList.size()-1;k++){
					Trie.insert(reseList.get(i).getName1());
				}*/
				
				
				//System.out.println(hotel.getId()+ " " + hotel.getName() + " " + hotel.getStars()+" "+hotel.getNumOfRooms());
				//System.out.println(reseList.get(i).getName()+ " " + reseList.get(i).getCheckInDate()+ " " + reseList.get(i).getStayDays());
				lineScan.close();
			}
			scan.close();
			
		}
		catch (FileNotFoundException e){
			System.out.println("file not found");
			System.exit(1);
		}
		catch (ParseException e) {
			System.out.println("me to parse");
		}
		catch (Exception e){
			System.out.println("sth went wrong");
		}
		

		
	}
	
	public static void addHotel(){
		try{
			Scanner sca = new Scanner(System.in);
			System.out.println("type id");
			int id = sca.nextInt();
			while (checkId(id)==true){
				System.out.println("there is already this id , type another");
				id = sca.nextInt();
			}
			System.out.println("type name");
			String name=sca.next();
			System.out.println("type stars");
			int stars = sca.nextInt();
			System.out.println("type number of rooms");
			int numOfRooms = sca.nextInt();
			System.out.println("first reservation");
			int p=0;
			ArrayList<Reservations> reseList;
			do{
				reseList=new ArrayList();
				System.out.println("type name");
				String name1=sca.next();
				System.out.println("type date");
				String csv=sca.next();
				Date checkInDate = new SimpleDateFormat("dd/MM/yyyy").parse(csv);
				System.out.println("type number of stay duration days");
				int stayDays = sca.nextInt();
				System.out.println("if you want to add another reservation , type 0 , otherwise type any other number");
				p=sca.nextInt();
				Reservations res=new Reservations(name1,checkInDate,stayDays);
				reseList.add(res);
			}while(p==0);
			Hotel hotel=new Hotel(id,name,stars,numOfRooms,reseList);
			hotelList.add(hotel);
			save++;
		}
		catch (Exception e){
			System.out.println("something went wrong with data you gave");
			System.exit(1);
		}
		
	}
	
	
	public static Hotel linearSearch(int id){
		if (hotelList.size()==0){
			return null;
		}
		else{
			for (int i=0;i<hotelList.size();i++){
				if (hotelList.get(i).getId()==id){
					return hotelList.get(i);
				}
			} 
			
		}
		return null;
	}
	
	public static void printStarHotel(int stars){
		for (int i=0;i<hotelList.size();i++){
			if (hotelList.get(i).getStars()==stars){
				System.out.println(hotelList.get(i).getName()+"   number of reservations - "+hotelList.get(i).getReseList().size());
			}
		}
	}	
	public static void printResByName(String name2){
		boolean found=false;
		for (int i=0;i<hotelList.size();i++){
			for(int j=0;j<hotelList.get(i).getReseList().size();j++){
				if (hotelList.get(i).getReseList().get(j).getName1().equals(name2)){
					System.out.println(hotelList.get(i).getName()+" "+hotelList.get(i).getReseList().get(j).getName1()+" "+hotelList.get(i).getReseList().get(j).getCheckInDate()+"  stay duration days: "+ hotelList.get(i).getReseList().get(j).getStayDays());
					found=true;
				}
				
			}
				
		}
		if (found==false){
			System.out.println("no data found");
		}
	
	}
	public static boolean checkId(int x){
		for (int i=0;i<hotelList.size();i++){
			if (hotelList.get(i).getId()==x){
				return true;
			}
		}
		return false;
	}
	
	public static Hotel interSearch(int id){
		 int low = 0;
		 int high = hotelList.size()-1;
		 int mid;
	     while (hotelList.get(low).getId() <= id && hotelList.get(high).getId() >= id) 
	     {	
	    	 if (hotelList.get(high).getId() - hotelList.get(low).getId() == 0)
	                return hotelList.get((low + high)/2);
	    	 
	         mid = low + ((id - hotelList.get(low).getId()) * (high - low)) / (hotelList.get(high).getId() - hotelList.get(low).getId());  
	 
	         if (hotelList.get(mid).getId() < id)
	        	 low = mid + 1;
	         else if (hotelList.get(mid).getId() > id)
	             high = mid - 1;
	         else
	             return hotelList.get(mid);
	     }
	     if (hotelList.get(low).getId() == id)
	     {    return hotelList.get(low);
	     } 
	     return null;
	     
		
	}
	
	public static void saveHotels(){
		try{
		
			int x=hotelList.size()-save;
			while (save>0){
				FileWriter pw = new FileWriter("C:/Users/loukas/Desktop/data.csv", true);
				
				pw.append(String.valueOf(hotelList.get(x).getId()));
				pw.append(';');
				pw.append(hotelList.get(x).getName());
				pw.append(';');
				pw.append(String.valueOf(hotelList.get(x).getStars()));
				pw.append(';');
				pw.append(String.valueOf(hotelList.get(x).getNumOfRooms()));
				pw.append(';');
				
				for(int j=0;j<hotelList.get(x).getReseList().size();j++){
					pw.append(hotelList.get(x).getReseList().get(j).getName1());
					pw.append(';');
					pw.append(hotelList.get(x).getReseList().get(j).getCheckInDate());
					pw.append(';');
					pw.append(String.valueOf(hotelList.get(x).getReseList().get(j).getStayDays()));
					pw.append(';');
				}
				pw.append('\n');
				
				pw.close();
				x++;
				save--;
			}
		}catch(FileNotFoundException e){
			System.out.println("file not found");
			System.exit(1);
		}catch(Exception e){
			System.out.println("error in csvfilewriter");
		}
		
	}

    public static Hotel binSearch(int id) 
    { 
    	
        int low = 0;
        int high = hotelList.size() - 1;
        int mid;
        while(high >= low) {
        	mid = (low + high) / 2;
            if(hotelList.get(mid).getId() == id) {
                return hotelList.get(mid);
            }
            if(hotelList.get(mid).getId()< id) {
                low = mid + 1;
            }
            if(hotelList.get(mid).getId()> id) {
                high = mid - 1;
            }
        }
        return null;
    }
}
