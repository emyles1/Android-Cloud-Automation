package testcases;

public class tuna {
	private String girlName;
	
	//constructor method. this assigns value to the variable above
	public tuna(String name){
		girlName=name;
	}
	
//	public void setName(String name){
//		girlName=name;
//	}
	public String getName(){
		return girlName;
	}
	public void saying(){
		System.out.printf("your first test was %s\n", getName());
	}
}
