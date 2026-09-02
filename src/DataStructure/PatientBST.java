package DataStructure;

public class PatientBST {
	private Patient root;

    public PatientBST() {
        this.root = null;
    }

    
    public void insert(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        root = insertRec(root, new Patient(patientId, name, age, contactNumber, medicalCondition));
    }

    private Patient insertRec(Patient root, Patient newPatient) {
        if (root == null) {
            return newPatient;
        }
        if (newPatient.getPatientId() < root.getPatientId()) {
            root.setLeft(insertRec(root.getLeft(), newPatient));
        } else if (newPatient.getPatientId() > root.getPatientId()) {
            root.setRight(insertRec(root.getRight(), newPatient));
        } else {
            System.out.println("Patient ID already exists!");
        }
        return root;
    }

    
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Patient root, int patientId) {
        if (root == null || root.getPatientId() == patientId) {
            return root;
        }
        if (patientId < root.getPatientId()) {
            return searchRec(root.getLeft(), patientId);
        }
        return searchRec(root.getRight(), patientId);
    }

    
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Patient deleteRec(Patient root, int patientId) {
        if (root == null) return root;

        if (patientId < root.getPatientId()) {
            root.setLeft(deleteRec(root.getLeft(), patientId));
        } else if (patientId > root.getPatientId()) {
            root.setRight(deleteRec(root.getRight(), patientId));
        } else {
            
            if (root.getLeft() == null) return root.getRight();
            else if (root.getRight() == null) return root.getLeft();

            
            Patient minNode = minValue(root.getRight());
            
            Patient replacement = new Patient(minNode.getPatientId(), minNode.getName(), 
                                               minNode.getAge(), minNode.getContactNumber(), 
                                               minNode.getMedicalCondition());
            replacement.setLeft(root.getLeft());
            replacement.setRight(deleteRec(root.getRight(), minNode.getPatientId()));
            return replacement;
        }
        return root;
    }

    private Patient minValue(Patient root) {
        Patient current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Patient root) {
        if (root != null) {
            inOrderRec(root.getLeft());
            System.out.println(root);
            inOrderRec(root.getRight());
        }
    }
}


