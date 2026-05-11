// Problem Statement: Design an Online Food Delivery Ecosystem where you can add Packages: restaurants, orders, delivery, users, payments. You should add Base class: User and Derived classes : Customer, DeliveryPartner, RestaurantOwner. Implement Interfaces: OrderProcessable and Trackable. Also add following Features: 1) Order placement & tracking 2) Restaurant menu management 3) Delivery assignment logic


// import all packages
import users.*;
import orders.*;
import restaurants.*;
import delivery.*;
import payments.*;

public class Main {
    public static void main(String[] args) {
        // Setup Ecosystem
        Customer customer = new Customer("Swarada");
        RestaurantOwner owner = new RestaurantOwner("Bob");
        Restaurant myRest = new Restaurant("Pizza Hut");
        DeliveryManager deliverySys = new DeliveryManager();
        Payment paymentSys = new Payment();

        //  Menu Management
        myRest.addMenuItem("Cheese Pizza");
        myRest.showMenu();

        //  Order Placement
        Order myOrder = new Order("ORD-101", "Cheese Pizza");
        System.out.println(customer.getName() + " placed order: " + myOrder.foodItem);
        paymentSys.processPayment(150.8);

        //  Delivery Assignment
        deliverySys.assignDelivery(myOrder, "Charlie (Delivery Partner)");
        deliverySys.trackStatus(myOrder.orderId);
    }
}
