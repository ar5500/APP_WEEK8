class EmergencyAlert extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Monitoring critical patient alerts...");
    }
}

class VitalMonitor extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Continuously checking vital signs...");
    }
}

class ReportGenerator extends Thread {
    public void run() {
        System.out.println(getName() + " - Priority: " + getPriority());
        System.out.println("Preparing routine reports...");
    }
}

public class HospitalMonitoring {
    public static void main(String[] args) {

        EmergencyAlert emergency = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        emergency.setName("EmergencyAlert");
        vital.setName("VitalMonitor");
        report.setName("ReportGenerator");

        // Highest priority
        emergency.setPriority(Thread.MAX_PRIORITY);   // 10

        // Medium priority
        vital.setPriority(Thread.NORM_PRIORITY);       // 5

        // Lowest priority
        report.setPriority(Thread.MIN_PRIORITY);       // 1

        emergency.start();
        vital.start();
        report.start();
    }
}
