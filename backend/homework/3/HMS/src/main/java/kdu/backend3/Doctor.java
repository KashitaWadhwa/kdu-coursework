public class Doctor extends Staff {
    private long doctorId;
    private String specialization;

    private Doctor(long id, String firstName, String lastName, String gender, String email,
                   long staffId, int yearsOfExperience, String description, double salary,
                   long doctorId, String specialization) {
        super(id, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    public static class Builder extends Staff.Builder {
        private long doctorId;
        private String specialization;

        public Builder(long id, String firstName, String lastName, String gender, String email) {
            super(id, firstName, lastName, gender, email);
        }

        public Builder doctorId(long doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public Builder specialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Doctor build() {
            return new Doctor(id, firstName, lastName, gender, email,
                    staffId, yearsOfExperience, description, salary, doctorId, specialization);
        }
    }

    // Getters and Setters for Doctor class
    public long getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
