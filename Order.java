package orders;
class order
public class Order {
    public String orderId;
    public String foodItem;
    public String status = "Pending";
    
    public Order(String orderId, String foodItem) { // constuctor
        this.orderId = orderId;
        this.foodItem = foodItem;
    }
}
