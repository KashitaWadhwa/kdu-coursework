package kdu.backend3;

public class Nurse extends Staff {
    private long nurseId;

    // Constructor
    public Nurse(long id, String firstName, String lastName, String gender, String email,
                 long staffId, int yearsOfExperience, String description, double salary,
                 long nurseId) {
        super(id, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary);
        this.nurseId = nurseId;
    }

    // Getters and Setters for Nurse class
    public long getNurseId() {
        return nurseId;
    }

    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }
}
