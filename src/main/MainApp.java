package main;

import DataStructure.EmergencyQueue;
import DataStructure.Patient;
import DataStructure.PatientBST;
import DataStructure.TreatmentStack;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Mini Hospital Emergency System ===");
            System.out.println("1. Add Patient Record (BST)");
            System.out.println("2. Search Patient Record (BST)");
            System.out.println("3. Delete Patient Record (BST)");
            System.out.println("4. Display All Patients Sorted (BST In-Order)");
            System.out.println("5. Enqueue Emergency Patient (Queue)");
            System.out.println("6. Treat Next Emergency Patient (Dequeue)");
            System.out.println("7. Display Waiting Queue");
            System.out.println("8. Display Treatment History (Stack)");
            System.out.println("9. Manage Patient Visit History (Singly Linked List)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID (Integer): ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Medical Condition: ");
                    String cond = sc.nextLine();
                    bst.insert(id, name, age, contact, cond);
                    System.out.println("Patient registered.");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to Search: ");
                    int searchId = sc.nextInt();
                    Patient p = bst.search(searchId);
                    if (p != null) System.out.println("Found: " + p);
                    else System.out.println("Patient not found.");
                    break;

                case 3:
                    System.out.print("Enter Patient ID to Delete: ");
                    int delId = sc.nextInt();
                    bst.delete(delId);
                    System.out.println("Patient deletion processed.");
                    break;

                case 4:
                    System.out.println("--- All Patients (Sorted by ID) ---");
                    bst.inOrder();
                    break;

                case 5:
                    System.out.print("Enter Patient ID for Emergency: ");
                    int eqId = sc.nextInt();
                    Patient eqPatient = bst.search(eqId);
                    if (eqPatient != null) {
                        queue.enqueue(eqPatient);
                    } else {
                        System.out.println("Patient record must exist before adding to Emergency Queue.");
                    }
                    break;

                case 6:
                    Patient treated = queue.dequeue();
                    if (treated != null) {
                        System.out.print("Enter treatment details provided to " + treated.getName() + ": ");
                        String details = sc.nextLine();
                        stack.push(treated, details);
                    }
                    break;

                case 7:
                    queue.displayQueue();
                    break;

                case 8:
                    stack.displayStack();
                    break;

                case 9:
                    System.out.print("Enter Patient ID to manage history: ");
                    int hId = sc.nextInt();
                    sc.nextLine();
                    Patient histPatient = bst.search(hId);
                    if (histPatient != null) {
                        manageVisitHistory(histPatient, sc);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 10:
                    System.out.println("Exiting System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageVisitHistory(Patient patient, Scanner sc) {
        while (true) {
            System.out.println("\n--- Visit History for " + patient.getName() + " ---");
            System.out.println("1. Add New Visit Record");
            System.out.println("2. Remove Visit Record");
            System.out.println("3. Search Visit Record");
            System.out.println("4. Display All Visits");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Visit ID: ");
                    String vId = sc.nextLine();
                    System.out.print("Visit Date: ");
                    String vDate = sc.nextLine();
                    System.out.print("Doctor Name: ");
                    String doc = sc.nextLine();
                    System.out.print("Diagnosis: ");
                    String diag = sc.nextLine();
                    System.out.print("Treatment: ");
                    String trt = sc.nextLine();
                    patient.getVisitHistory().addVisit(vId, vDate, doc, diag, trt);
                    break;
                case 2:
                    System.out.print("Enter Visit ID to Remove: ");
                    String remId = sc.nextLine();
                    if (patient.getVisitHistory().removeVisit(remId)) System.out.println("Visit removed.");
                    else System.out.println("Visit ID not found.");
                    break;
                case 3:
                    System.out.print("Enter Visit ID to Search: ");
                    String sId = sc.nextLine();
                    var node = patient.getVisitHistory().searchVisit(sId);
                    if (node != null) System.out.println(node);
                    else System.out.println("Visit not found.");
                    break;
                case 4:
                    patient.getVisitHistory().displayHistory();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

