package EHMS;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends Variables{
    public void viewDoctor() throws IOException {
        req=new Required();
        if(req.check("Doctor.csv")){
            System.out.println("\n+-----------+------------------+-------------+--------+-----+----------------+---------------+-------------+");
            System.out.println("| Doctor ID |    First Name    |  Last Name  | Gender | Age | Contact Number | Qualification | Doctor Type |");
            System.out.println("+-----------+------------------+-------------+--------+-----+----------------+---------------+-------------+");
            filer = new BufferedReader(new FileReader("Doctor.csv"));
            filer.readLine();
            while ((line = filer.readLine()) != null) {
                data = line.split(",");
                System.out.printf("| %-10s|    %-14s|  %-11s| %-7s| %-4s| %-15s| %-14s| %-12s|\n", data[0], data[2], data[3], data[4], data[5], data[6], data[8], data[9]);
                System.out.println("+-----------+------------------+-------------+--------+-----+----------------+---------------+-------------+");
            }
            filer.close();
        }
        else {
            System.out.println("NO Doctor Found");
        }

    }
    public void viewPatient() throws IOException {
        req=new Required();
        if(req.check("Doctor.csv")){
            System.out.println("\n+------------+------------------+-------------+--------+-----+----------------+-------------+----------------------------------+");
            System.out.println("| Patient ID |    First Name    |  Last Name  | Gender | Age | Contact Number | Blood Group |             Email ID             |");
            System.out.println("+------------+------------------+-------------+--------+-----+----------------+-------------+----------------------------------+");
            filer = new BufferedReader(new FileReader("Patient.csv"));
            filer.readLine();
            while ((line = filer.readLine()) != null) {
                data = line.split(",");
                System.out.printf("| %-10s | %-16s | %-11s | %-6s | %-3s | %-14s | %-11s | %-32s |\n", data[0], data[2], data[3], data[4], data[5], data[7], data[6], data[8]);
                System.out.println("+------------+------------------+-------------+--------+-----+----------------+-------------+----------------------------------+");
            }
            filer.close();
        }
        else {
            System.out.println("No Patient Found");
        }
    }
    public void addDoctor() throws IOException {
        Registration reg = new Registration();
        req=new Required();
        reg.doctorRegister(req.AutoId("Doctor.csv"));
    }
    public void removeDoctor() throws IOException {
        int count=0;
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("\nEnter ID no : ");
                userId = sc.nextInt();
                break;

            }catch (InputMismatchException e){
                System.out.println("Enter valid ID");
            }
        }


        System.out.print("Enter Password of Admin to confirm : ");
        password=input.next();
        if(password.equals("APPK")){
            filer = new BufferedReader(new FileReader("Doctor.csv"));
            filew = new BufferedWriter(new FileWriter("temp.csv"));

            firstline = filer.readLine();
            filew.write(firstline + "\n");

            while ((line = filer.readLine()) != null) {
                data = line.split(",");
                if (Integer.parseInt(data[0]) != userId) {
                    filew.write(line+"\n");
                }
                else{
                    count++;
                }
            }
            filer.close();
            filew.close();

            File of = new File("Doctor.csv");
            File nf = new File("temp.csv");

            of.delete();
            File dump = new File("Doctor.csv");
            nf.renameTo(dump);
            if(count==0)
            {
                System.out.println("Not Valid User ID!!");
            }
            else {
                System.out.println("Removed Successfully");
            }
        }
        else {
            System.out.println("Invalid Password");
        }

    }
    public void viewAppointments() throws IOException{
        req=new Required();
        if(req.check("Appointment.csv"))
        {
            System.out.println("\n+----------------+-----------+-----------------------------+------------------+----------+------------+---------------+");
            System.out.println("| Appointment Id | PatientId |           Problem           |    DoctorName    | DoctorId | DoctorType | Qualification |");
            System.out.println("+----------------+-----------+-----------------------------+------------------+----------+------------+---------------+");
            filer = new BufferedReader(new FileReader("Appointment.csv"));
            filer.readLine();
            while ((line=filer.readLine())!=null){
                data=line.split(",");
                System.out.printf("| %-14s | %-9s | %-27s | %-16s | %-8s | %-10s | %-13s |\n",data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
                System.out.println("+----------------+-----------+-----------------------------+------------------+----------+------------+---------------+");
            }
            filer.close();
        }
        else{
            System.out.println("No Appointment Found");
        }

    }
    public void viewReports() throws IOException{
        req=new Required();
        if(req.check("Report.csv")){
            filer=new BufferedReader(new FileReader("Report.csv"));
            filer.readLine();
            System.out.println("\n+-----------+----------------+------------+-----------+-------------------+--------------+");
            System.out.println("| Report-ID | Appointment-ID | Patient-ID | Doctor-ID |      Problem      | Prescription |");
            System.out.println("+-----------+----------------+------------+-----------+-------------------+--------------+");
            while ((line=filer.readLine())!=null){
                data=line.split(",");
                System.out.printf("| %-9s | %-14s | %-10s | %-9s | %-17s | %-12s |\n",data[0],data[1],data[2],data[3],data[6],data[7]);
                System.out.println("+-----------+----------------+------------+-----------+-------------------+--------------+");
            }
            filer.close();
        }
        else {
            System.out.println("No data to show");
        }

    }
    public void viewFeedbacks() throws IOException{
        req=new Required();
        if(req.check("Feedback.csv")){
            filer=new BufferedReader(new FileReader("Feedback.csv"));
            filer.readLine();
            System.out.println("\n+------------+--------+------------------+------------------------------+");
            System.out.println("| Patient ID | Rating |      Nature      |           Comments           |");
            System.out.println("+------------+--------+------------------+------------------------------+");
            while ((line=filer.readLine())!=null){
                data=line.split(",");
                System.out.printf("| %-10s | %-6s | %-16s | %-28s |\n",data[0],data[1],data[2],data[3]);
                System.out.println("+------------+--------+------------------+------------------------------+");
            }
            filer.close();
        }
        else {
            System.out.println("No Feedback Found");
        }

    }
}


