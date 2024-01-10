package kdu.backend3;

public class Patient extends User {
    private long patientId;
    private boolean insured;
    /**
     * Question 2
     */
    private HealthInsurancePlan insurancePlan;

    // Constructor
    public Patient(long id, String firstName, String lastName, String gender, String email,
                   long patientId, boolean insured) {
        super(id, firstName, lastName, gender, email);
        this.patientId = patientId;
        this.insured = insured;
        this.insurancePlan = null;
        // Default value is null
    }
    /**
     * Question 2 Getter and Setter for insurancePlan
     */
    // Getter and Setter for insurancePlan
    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    // Getters and Setters for Patient class
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }


    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}
