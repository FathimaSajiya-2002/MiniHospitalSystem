package DataStructure;

public class TreatmentStack {
	public static class TreatmentRecord {
        private Patient patient;
        private String treatmentDetails;

        public TreatmentRecord(Patient patient, String treatmentDetails) {
            this.patient = patient;
            this.treatmentDetails = treatmentDetails;
        }

        @Override
        public String toString() {
            return "Patient ID: " + patient.getPatientId() + " | Name: " + patient.getName() + 
                   " | Treatment Received: " + treatmentDetails;
        }
    }

    private static class StackNode {
        TreatmentRecord record;
        StackNode next;

        StackNode(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private StackNode top;

    public TreatmentStack() {
        this.top = null;
    }

    
    public void push(Patient patient, String treatmentDetails) {
        TreatmentRecord record = new TreatmentRecord(patient, treatmentDetails);
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record stored in history.");
    }

    
    public TreatmentRecord pop() {
        if (top == null) {
            System.out.println("Error: Treatment history stack is empty!");
            return null;
        }
        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    
    public void displayStack() {
        if (top == null) {
            System.out.println("No treatment history available.");
            return;
        }
        System.out.println("--- Treatment History (Most Recent First) ---");
        StackNode current = top;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }
}


