package delivery;
import orders.Order;
import orders.Trackable;

public class DeliveryManager implements Trackable {
    public void assignDelivery(Order order, String partnerName) {
        System.out.println("Order " + order.orderId + " assigned to " + partnerName);
    }
    @Override
    public void trackStatus(String orderId) {
        System.out.println("Tracking Order: " + orderId + " is out for delivery!");
    }
}
