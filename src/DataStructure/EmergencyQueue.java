package DataStructure;

public class EmergencyQueue {
	private static class QueueNode {
        Patient patient;
        QueueNode next;

        QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue
    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (rear == null) {
            front = rear = newNode;
            System.out.println(patient.getName() + " added to the emergency queue.");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println(patient.getName() + " added to the emergency queue.");
    }

    // Dequeue
    public Patient dequeue() {
        if (front == null) {
            System.out.println("Error: Emergency Queue is empty!");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return patient;
    }

    // Display Queue
    public void displayQueue() {
        if (front == null) {
            System.out.println("No patients currently waiting in emergency.");
            return;
        }
        System.out.println("--- Current Emergency Waiting Queue ---");
        QueueNode current = front;
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }
}


