package DataStructure;

public class Patient {
	private int patientId;
    private String name;
    private int age;
    private String contactNumber;
    private String medicalCondition;
    private PatientVisitHistory visitHistory;
    private Patient left;
    private Patient right;

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new PatientVisitHistory();
        this.left = null;
        this.right = null;
    }

    
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContactNumber() { return contactNumber; }
    public String getMedicalCondition() { return medicalCondition; }
    public PatientVisitHistory getVisitHistory() { return visitHistory; }
    public Patient getLeft() { return left; }
    public void setLeft(Patient left) { this.left = left; }
    public Patient getRight() { return right; }
    public void setRight(Patient right) { this.right = right; }

    @Override
    public String toString() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age +
               " | Contact: " + contactNumber + " | Condition: " + medicalCondition;
    }
}


