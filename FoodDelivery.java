class OrderProcessing extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Processing customer orders...");
        
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Processing order " + i);
        }
    }
}

class DeliveryTracking extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Tracking delivery locations...");
        
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Tracking delivery " + i);
        }
    }
}

class Notification extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Sending order-status notifications...");
        
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Sending notification " + i);
        }
    }
}

public class FoodDelivery {
    public static void main(String[] args) {

        OrderProcessing order = new OrderProcessing();
        DeliveryTracking delivery = new DeliveryTracking();
        Notification notification = new Notification();

        order.setName("OrderProcessing");
        delivery.setName("DeliveryTracking");
        notification.setName("Notification");

        // Assign priorities
        order.setPriority(Thread.MAX_PRIORITY);       // 10
        delivery.setPriority(Thread.NORM_PRIORITY);   // 5
        notification.setPriority(Thread.MIN_PRIORITY); // 1

        // Start all threads
        order.start();
        delivery.start();
        notification.start();
    }
}
