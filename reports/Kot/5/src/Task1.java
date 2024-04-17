interface Doctor {
    void treatPatient();
}

class Surgeon implements Doctor {
    @Override
    public void treatPatient() {
        System.out.println("Performing a surgery");
    }
}

class Neurosurgeon extends Surgeon {
    @Override
    public void treatPatient() {
        super.treatPatient();
        System.out.println("\t on human brain");
    }
}

class Patient {
    public Patient (Doctor attendingDoctor) {
        System.out.println("The patient is being treated...");
        attendingDoctor.treatPatient();
    }
}

public class Task1 {
    public static void main(String[] args) {
        Surgeon SallyMulligan = new Surgeon();
        Neurosurgeon KattyPerry = new Neurosurgeon();

        new Patient(SallyMulligan);
        System.out.println();
        new Patient(KattyPerry);
    }
}