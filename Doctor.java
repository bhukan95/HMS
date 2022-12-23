package EHMS;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Doctor extends  Variables{
    public void viewProfile(int dID) throws IOException {
        filer = new BufferedReader(new FileReader("Doctor.csv"));
        filer.readLine();
        while ((line = filer.readLine()) != null) {
            data = line.split(",");
            if (dID == Integer.parseInt(data[0])) {
                System.out.printf("\n| Doctor ID:      %s\n", data[0]);
                System.out.printf("| Doctor Name:    %s %s\n", data[2],data[3]);
                System.out.printf("| Qualification   %s\n", data[8]);
                System.out.printf("| Department:     %s\n", data[9]);
                System.out.printf("| Contact Number: %s\n", data[6]);
                System.out.printf("| E-mail ID:      %s\n", data[7]);
            }
        }
        filer.close();
    }
    public void viewAppointment(int dID) throws IOException {
        req=new Required();
        if(req.dcheck("Appointment.csv",dID))
        {
            filer = new BufferedReader(new FileReader("Appointment.csv"));
            filer.readLine();
            while ((line = filer.readLine()) != null) {
                data = line.split(",");
                if (dID == Integer.parseInt(data[4]) && Integer.parseInt(data[8])==0){
                    System.out.println("+----------------------------+");
                    System.out.printf("| Appointment ID:  %-9s |\n", data[0]);
                    System.out.printf("| Patient ID:      %-9s |\n", data[1]);
                    System.out.printf("| Doctor ID:       %-9s |\n", data[4]);
                    System.out.printf("| Patient Problem: %-9s |\n", data[2]);
                    System.out.println("+----------------------------+");
                }
            }
            filer.close();
        }
        else {
            System.out.println("No Appointment Received");
        }
    }
    public void diagnosePatient(int dID)throws IOException{
        req=new Required();
        if(req.dcheck("Appointment.csv",dID))
        {
            int digId; //diagnose id
            String prescription,comments;
            filer=new BufferedReader(new FileReader("Appointment.csv"));
            filer.readLine();
            System.out.println("+----------------+--------------+");
            System.out.println("| Appointment ID | Patient Name |");
            System.out.println("+----------------+--------------+");
            while ((line=filer.readLine())!=null){
                data=line.split(",");
                if(Integer.parseInt(data[4])==dID && Integer.parseInt(data[8])==0){
                    System.out.printf("| %-14s | %-12s |\n",data[0],data[7]);
                    System.out.println("+----------------+--------------+");
                }
            }
            filer.close();
while(true){
try{
    Scanner sc =new Scanner(System.in);
    System.out.print("Enter Appointment Id : ");
    digId=sc.nextInt();
    break;
}catch (InputMismatchException e){
    System.out.println("Enter valid Appointment Id");
}

}


            System.out.print("Prescription : ");
            prescription=input.nextLine();
            System.out.print("Comments : ");
            comments=input.nextLine();

            filer=new BufferedReader(new FileReader("Appointment.csv"));
            filew=new BufferedWriter(new FileWriter("temp.csv"));

            firstline = filer.readLine();
            filew.write(firstline + "\n");

            while ((line=filer.readLine())!=null){
                data=line.split(",");
                if(Integer.parseInt(data[0])!=digId){
                    filew.write(line+"\n");
                }
                else{
                    data[8]="1";
                    String update=(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5]+","+data[6]+","+data[7]+","+data[8]+"\n");
                    filew.write(update);
                }
            }
            filer.close();
            filew.close();

            File of = new File("Appointment.csv");
            File nf = new File("temp.csv");

            of.delete();
            File dump = new File("Appointment.csv");
            nf.renameTo(dump);

            filew=new BufferedWriter(new FileWriter("Report.csv",true));
            filer=new BufferedReader(new FileReader("Appointment.csv"));
            filer.readLine();
            while((line=filer.readLine())!=null){
                data=line.split(",");
                if(Integer.parseInt(data[0])==digId){
                    String add;
                    add=(req.AutoId("Report.csv")+","+data[0]+","+data[1]+","+data[4]+","+data[7]+","+data[3]+","+data[2]+","+prescription+","+comments+"\n");
                    filew.write(add);
                }
            }
            filew.close();
            filer.close();
        }
        else {
            System.out.println("No Appointment To Be Diagnosed");
        }
    }
}
