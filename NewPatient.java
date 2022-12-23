package EHMS;
import java.io.IOException;

public class NewPatient extends Required{
    public void newPatient() throws IOException{
        req=new Required();
        Registration r=new Registration();
        r.patientRegister(req.AutoId("Patient.csv"));
    }
}
