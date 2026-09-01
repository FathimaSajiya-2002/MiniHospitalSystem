package DataStructure;

public class PatientVisitHistory {
	private VisitNode head;

    public PatientVisitHistory() {
        this.head = null;
    }

    
    public void addVisit(String visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        VisitNode newNode = new VisitNode(visitId, visitDate, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        System.out.println("Visit record added successfully.");
    }

    
    public boolean removeVisit(String visitId) {
        if (head == null) return false;

        if (head.getVisitId().equalsIgnoreCase(visitId)) {
            head = head.getNext();
            return true;
        }

        VisitNode current = head;
        while (current.getNext() != null && !current.getNext().getVisitId().equalsIgnoreCase(visitId)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            return true;
        }
        return false;
    }

    
    public VisitNode searchVisit(String visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.getVisitId().equalsIgnoreCase(visitId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    
    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        VisitNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}


