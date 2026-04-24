package prac4;
import java.util.Scanner;
class vehicle {
	String v_name;
	int days;
	int rent;
	String model;
	
	vehicle(int rent, String v_name, String model, int days){
		this.rent=rent;
		this.v_name=v_name;
	    this.model=model;
	    this.days=days;
	}
	public int cal_rent() {
		int res=rent*days;
		return res;
	}
	
	public void display() {
		System.out.println("Vehicle Type: " + v_name);
        System.out.println("Rent per day: " + rent);
        System.out.println("Total Rent for " + days + " days: " + cal_rent());
	}
}	
	class car extends vehicle{
		int car_rent;
		car(int rent, String v_name, String model, int days){
		    super(rent,v_name,model,days);
	}
		public int cal_rent() {
			car_rent=1000;
			return car_rent*days;
		}
		
	}
	
	class truck extends vehicle{
		int truck_rent;
		truck(int rent, String v_name, String model, int days){
		    super(rent,v_name,model,days);
	}
		public int cal_rent() {
			truck_rent=2000;
			return truck_rent*days;
		}
		
	}
	class bike extends vehicle{
		int bike_rent;
		bike(int rent, String v_name, String model, int days){
		    super(rent,v_name,model,days);
	}
		public int cal_rent() {
			bike_rent=3000;
			return bike_rent*days;
		}
		
	}
public class vehicle_management_system{	
	public static void main(String[] args) {
		System.out.println("abc");
		Scanner sc=new Scanner(System.in);
		int choice, d;
		String m, b;
		do {
		System.out.println("--Vehicle rental system--");
		System.out.println("1)Car\n2)Truck\n3)Bike");
		
		System.out.println("\nEnter your choice from above menu: ");
		choice=sc.nextInt();

	    switch(choice) {
	       case 1: 
	    	   System.out.println("\nEnter brand of your vehicle: ");
	   		b =sc.next();
	   		System.out.println("\nEnter model of your vehicle: ");
	   		m =sc.next();
	   		System.out.println("\nEnter days: ");
	   	    d =sc.nextInt();
	   	 vehicle car = new car(1000,b,m,d);
	    	   car.cal_rent();
	    	   car.display();
	    	   break;
	    	   
	       case 2:
	    	   System.out.println("\nEnter brand of your vehicle: ");
	   		 b =sc.next();
	   		System.out.println("\nEnter model of your vehicle: ");
	   		 m =sc.next();
	   		System.out.println("\nEnter days: ");
	   	     d =sc.nextInt();
	   	  vehicle truck = new car(2000,b,m,d);
	    	   truck.cal_rent();
	    	   truck.display();
	    	   break;
	    	   
	       case 3:
	    	   System.out.println("\nEnter brand of your vehicle: ");
	   		 b =sc.next();
	   		System.out.println("\nEnter model of your vehicle: ");
	   		m =sc.next();
	   		System.out.println("\nEnter days: ");
	   	     d =sc.nextInt();
	   	  vehicle bike = new car(3000,b,m,d);
	    	   bike.cal_rent();
	    	   bike.display();
	    	   break;
	    	   
	       case 4:
	    	   System.out.println("Exiting program");
	    	default:
	    		System.out.println("Invalid choice");
	    		break;
	    
	    }
	}while(choice!=5);
	}
}
