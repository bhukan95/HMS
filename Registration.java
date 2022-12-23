package EHMS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Registration extends Variables{
    public void doctorRegister(int did) throws IOException {
        filew=new BufferedWriter(new FileWriter("Doctor.csv",true));
        System.out.println("Doctor ID : "+did);
        System.out.print("Enter Your Password : ");
        password=input.next();
        while (true){
            System.out.print("Confirm Your Password : ");
            confpass =input.next();
            if(confpass.equals(password)){
                break;
            }
            else {
                System.out.println("Password not matched!!");
            }
        }
        System.out.println("    Signed-Up Successfully    ");
        System.out.println("+--------------------------------------+");
        System.out.println("+      Fill out Following Details      +");
        System.out.println("+--------------------------------------+");
        System.out.print("First Name : ");
        fullname =input.next();
        System.out.print("Last Name : ");
        lastname =input.next();
        System.out.print("Gender : ");
        gender=input.next();
        while(true){

             try {
                 Scanner sc =new Scanner(System.in);
                 System.out.print("Age : ");
                 age = sc.nextInt();
                 break;
             }catch (InputMismatchException e){
                 System.out.println("Enter valid age");
             }
        }


        System.out.print("Contact Number : ");
        contactNum =input.next();
        System.out.print("Email ID : ");
        mailID =input.next();
        System.out.print("Qualification : ");
        quilification =input.next();
        System.out.println("Choose Specialization");
        System.out.println("+------------------------+");
        System.out.printf("| 1] %-8s 2]%-8s |\n","ENT","EYES");
        System.out.printf("| 3] %-8s 4]%-8s |\n","HEART","LUNGS");
        System.out.printf("| 5] %-8s 6]%-8s |\n","KIDNEY","GENERAL");
        System.out.println("+------------------------+");

        while (true){
            while (true) {
                try {

                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter Your Choice : ");
                    choice = sc.nextInt();
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Enter valid choice");
                }
            }

            if(choice>=1 && choice<=6){
                switch (choice){
                    case 1:spec="ENT"; break;
                    case 2:spec="EYES"; break;
                    case 3:spec="HEART"; break;
                    case 4:spec="LUNGS"; break;
                    case 5:spec="KIDNEY"; break;
                    case 6:spec="GENERAL"; break;
                }
                break;
            }
            else {
                System.out.println("Invalid entry!!");
            }
        }
        String ndata=(did+","+password+","+ fullname +","+ lastname +","+gender+","+age+","+ contactNum +","+ mailID +","+ quilification +","+spec+"\n");
        filew.write (ndata);
        filew.close();
        System.out.println("Registered Successfully");
    }
    public void patientRegister(int pid) throws IOException{
        filew=new BufferedWriter(new FileWriter("Patient.csv",true));
        System.out.println("Patient ID : "+pid);
        System.out.print("Enter Your Password : ");
        password=input.next();
        while (true){
            System.out.print("Confirm Your Password : ");
            confpass =input.next();
            if(confpass.equals(password)){
                break;
            }
            else {
                System.out.println("Password Entered Do Not Match Enter Again");
            }
        }
        System.out.println("    SignedUP Successfully    ");
        System.out.println("+--------------------------------------+");
        System.out.println("+      Fill out Following Details      +");
        System.out.println("+--------------------------------------+");
        System.out.print("First Name : ");
        fullname =input.next();
        System.out.print("Last Name : ");
        lastname =input.next();
        System.out.print("Gender : ");
        gender=input.next();
        while(true){

            try{
                Scanner sc =new Scanner(System.in);
                System.out.print("Age : ");
                age=sc.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Enter valid age");
            }
        }


        System.out.print("Blood Group : ");
        bloodg=input.next();
        System.out.print("Contact Number : ");
        contactNum =input.next();
        System.out.print("Email ID : ");
        mailID =input.next();

        String ndata=(pid+","+password+","+ fullname +","+ lastname +","+gender+","+age+","+bloodg+","+ contactNum +","+ mailID);
        filew.write (ndata+"\n");
        filew.close();
        System.out.println("Registered Successfully");
    }
}
