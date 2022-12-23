package EHMS;
public class Headers {
    public void MainHeader(){
        System.out.println("+----------------------------------------+");
        System.out.printf("|          %-30s|\n","1]ADMIN");
        System.out.printf("|          %-30s|\n","2]DOCTOR");
        System.out.printf("|          %-30s|\n","3]PATIENT");
        System.out.printf("|          %-30s|\n","4]NEW PATIENT SIGN-UP");
        System.out.printf("|          %-30s|\n","5]EXIT");
        System.out.println("+----------------------------------------+");
    }
    public void AdminHeader(){
        System.out.println("\n+----------------------------------------+");
        System.out.println("+        ----> ADMIN PORTAL <----        +");
        System.out.println("+----------------------------------------+");
        System.out.println("+----------------------------------------+");
        System.out.printf("|           %-29s|\n","1]Doctor List");
        System.out.printf("|           %-29s|\n","2]Patient List");
        System.out.printf("|           %-29s|\n","3]Add Doctor");
        System.out.printf("|           %-29s|\n","4]Remove Doctor");
        System.out.printf("|           %-29s|\n","5]Appointments");
        System.out.printf("|           %-29s|\n","6]Reports");
        System.out.printf("|           %-29s|\n","7]Feedback");
        System.out.printf("|           %-29s|\n","8]Logout");
        System.out.println("+----------------------------------------+");
    }
    public void DoctorHeader(){
        System.out.println("\n+----------------------------------------+");
        System.out.println("+        ----> DOCTOR PORTAL <----       +");
        System.out.println("+----------------------------------------+");
        System.out.println("+----------------------------------------+");
        System.out.printf("|           %-29s|\n","1]Profile");
        System.out.printf("|           %-29s|\n","2]Appointments Received");
        System.out.printf("|           %-29s|\n","3]Diagnosed");
        System.out.printf("|           %-29s|\n","4]Logout");
        System.out.println("+----------------------------------------+");
    }
    public void PatientHeader(){
        System.out.println("\n+----------------------------------------+");
        System.out.println("+       ----> PATIENT PORTAL <----       +");
        System.out.println("+----------------------------------------+");
        System.out.println("+----------------------------------------+");
        System.out.printf("|           %-29s|\n","1]Profile");
        System.out.printf("|           %-29s|\n","2]Doctor List");
        System.out.printf("|           %-29s|\n","3]Book New Appointment");
        System.out.printf("|           %-29s|\n","4]Appointments");
        System.out.printf("|           %-29s|\n","5]Reports");
        System.out.printf("|           %-29s|\n","6]Give Feedback");
        System.out.printf("|           %-29s|\n","7]Logout");
        System.out.println("+----------------------------------------+");
    }
}
