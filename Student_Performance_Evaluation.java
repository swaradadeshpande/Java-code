import java.util.Scanner;

class std{
	private int id;
	private String name;
    private double ppl, se, dm, dbms, os;
    double avg;
	
	public void setID(int std_id){  //set method
		id = std_id;
	}	
	public void setName(String n){
		name = n;
	}	
	public void set1(double p){
		ppl=p;
	}
	public void set2(double s){
		se = s;
	}
	public void set3(double d){
		dm = d;
	}
	public void set4(double db){
		dbms = db;
	}
	public void set5(double o){
		os = o;
	}
	public int getID(){   //get method
		return id;
	}
	public String getName(){
		return name;
	}	
	public double get1(){
		return ppl;
	}	
	public double get2(){
		return se;
	}	
	public double get3(){
		return dm;
	}
	public double get4(){
		return dbms;
	}
	public double get5(){
		return os;
	}
	public double Average(){		
		avg = ppl+se+dm+dbms+os;		
		avg = avg/5;
		return avg;
	}	
	public void display() {
		System.out.println("Average:"+Average());
	}	
	public void result(){
		if(ppl< 40 || se<40 || dm<40 || dbms<40 || os<40){
			System.out.println("Fail");
		} 
		else{
			System.out.println("Pass");
		}
	}	
}

class Student_Performance_Evaluation{
		//function call
	public static void main(String args[]){
		System.out.println("Welcome to Student Performance Evaluation System");
		std s = new std();
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter your name : ");
		String name = obj.nextLine();
		s.setName(name);
		
		System.out.print("Enter your id : ");
		int id = obj.nextInt();
		s.setID(id);		
		System.out.println("\nEnter Marks for each subject : \n");		
		System.out.print("Principles of Programming language: ");
		double ppl = obj.nextDouble();
		s.set1(ppl);	
		System.out.print("Software Engineering: ");
		double se = obj.nextDouble();
		s.set2(se);	
		System.out.print("Digital Marketing: ");
		double dm = obj.nextDouble();
		s.set3(dm);		
		System.out.print("Database Management Systems: ");
		double dbms = obj.nextDouble();
		s.set4(dbms);	
		System.out.print("Operating System: ");
		double os = obj.nextDouble();
		s.set5(os);	
		System.out.println();			
		System.out.println("Name : "+s.getName());
		System.out.println("ID : "+s.getID());	
		System.out.println("Marks of Principles of Programming language: "+s.get1());	
		System.out.println("Marks of Software Engineering: "+s.get2());		
		System.out.println("Marks of Digital Marketing: "+s.get3());			
		System.out.println("Marks of Database Management Systems: "+s.get4());		
		System.out.println("Marks of Operating System: "+s.get5());
	    System.out.print("\nResult is: \n");
		s.display();
		s.result();
		obj.close();
	}
}

