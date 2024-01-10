package kdu.backend3;

public class Doctor extends Staff {
    private long doctorId;
    private String specialization;

    // Constructor
    public Doctor(long id, String firstName, String lastName, String gender, String email,
                  long staffId, int yearsOfExperience, String description, double salary,
                  long doctorId, String specialization) {
        super(id, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    // Getters and Setters for Doctor class
    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
