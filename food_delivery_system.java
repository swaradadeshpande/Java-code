class Order { // order class
int orderId;
String foodItem;
String cust_name;

public Order(int orderId, String foodItem, String cust_name) {// constructor
   this.orderId = orderId;
   this.foodItem = foodItem;
   this.cust_name=cust_name;
}
}

class DeliveryAgent implements Runnable { // class delivery agent implements runnable
String agentName;
Order assignedOrder; // The agent receives an Order object

// We pass a specific Order object directly to the agent
public DeliveryAgent(String agentName, Order assignedOrder) {
   this.agentName = agentName;
   this.assignedOrder = assignedOrder;
}
public void run() { // run method
   System.out.println(agentName + " picked up Order #" + assignedOrder.orderId + " (" + assignedOrder.foodItem + ")");
   try {
       // Simulate the time it takes to deliver
       Thread.sleep(500); 
   } catch (InterruptedException e) {
       System.out.println("Delivery interrupted.");
   } 
   System.out.println(agentName + " successfully delivered Order #" + assignedOrder.orderId);
} 
}

public class food_delivery_system {
public static void main(String[] args) {
	System.out.println("--- Food Delivery System ---");
	System.out.println();
   System.out.println("--- Starting Deliveries ---");
   System.out.println();
   Order order1 = new Order(101, "Pizza", "Swarada");  // create separate Order objects
   Order order2 = new Order(102, "Burger", "Jidnyasa");
   Order order3 = new Order(103, "Pasta", "Asmi");
   // Create delivery agents and hand them their specific Order object
   Thread agent1 = new Thread(new DeliveryAgent("Agent 1", order1));
   Thread agent2 = new Thread(new DeliveryAgent("Agent 2", order2));
   Thread agent3 = new Thread(new DeliveryAgent("Agent 3", order3));

   agent1.start();  // Start threads simultaneously
   try {
       Thread.sleep(1000); 
   } catch (InterruptedException e) {
       e.printStackTrace();
   }
   agent2.start();
   try {
       Thread.sleep(1000); 
   } catch (InterruptedException e) {
       e.printStackTrace();
   }
   agent3.start();
   try {
       Thread.sleep(1000); 
   } catch (InterruptedException e) {
       e.printStackTrace();
   }
} 
}

