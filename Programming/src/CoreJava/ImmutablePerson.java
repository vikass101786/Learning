package CoreJava;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public final class ImmutablePerson {
	
	private int id;
	
	private  String name;
	
	private  Date birthDay;
	
	private HashMap<String, Integer> detailsMap;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDay() {
		return (Date) birthDay.clone();
	}

	public HashMap<String, Integer> getDetailsMap() {
		 return (HashMap<String, Integer>) detailsMap.clone(); 
	}
	
	
	
	
	public ImmutablePerson(int id, String name, Date bd, HashMap<String, Integer> map) {
		this.id = id;
		this.name = name;
		this.birthDay = new Date(bd.getTime());
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		Iterator<String> it = map.keySet().iterator();
		String key;
		while (it.hasNext()) {
			key = it.next();
			hMap.put(key, map.get(key));
		}
		this.detailsMap = hMap;
	}
	 
	
	
	/*
	 * public ImmutablePerson(int id , String name , Date bd , HashMap<String,
	 * Integer> map) { this.id = id; this.name = name; this.birthDay = bd;
	 * this.detailsMap = map; }
	 */
	
	public static void main(String[] args) {
		HashMap<String, Integer> h1 = new HashMap<String,Integer>();
		h1.put("1", 1);
		h1.put("2", 2);
		
		String s = "original";
		
		Date d1 = new Date();
		
		int i=10;
		
		ImmutablePerson ce = new ImmutablePerson(i,s,d1,h1);
		
		//Lets see whether its copy by field or reference
		
		System.out.println(" ============= Lets see whether its copy by field or reference ================");
		
		System.out.println(s==ce.getName());
		System.out.println(h1 == ce.getDetailsMap());
		//print the ce values
		System.out.println("ce id:"+ce.getId());
		System.out.println("ce name:"+ce.getName());
		System.out.println("ce date : " + ce.getBirthDay());
		System.out.println("ce testMap:"+ce.getDetailsMap());
		//change the local variable values
		
		System.out.println(" =========== change the local variable values ================ ");
		
		i=20;
		s="modified";
		h1.put("3", 3);
		d1.setDate(100);
		//print the values again
		
		System.out.println(" ============= print the values again =================== ");
		
		System.out.println("ce id after local variable change:"+ce.getId());
		System.out.println("ce name after local variable change:"+ce.getName());
		System.out.println("ce testMap after local variable change:"+ce.getDetailsMap());
		System.out.println(" Date " + ce.getBirthDay());
		
		HashMap<String, Integer> hmTest = ce.getDetailsMap();
		hmTest.put("4", 4);
		
		System.out.println("ce testMap after changing variable from accessor methods:"+ce.getDetailsMap());
	}

}
