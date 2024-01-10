package kdu.backend3;

public class Patient extends User implements InsuranceBrand {
    private long patientId;
    private boolean insured;
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

    // Getter and Setter for insurancePlan
    @Override
    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    @Override
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

    @Override
    public boolean isInsured() {
        return insured;
    }

    @Override
    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}
