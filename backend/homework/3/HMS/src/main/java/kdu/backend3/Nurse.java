public class Nurse extends Staff {
    private long nurseId;

    private Nurse(long id, String firstName, String lastName, String gender, String email,
                  long staffId, int yearsOfExperience, String description, double salary, long nurseId) {
        super(id, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary);
        this.nurseId = nurseId;
    }

    public static class Builder extends Staff.Builder {
        private long nurseId;

        public Builder(long id, String firstName, String lastName, String gender, String email) {
            super(id, firstName, lastName, gender, email);
        }

        public Builder nurseId(long nurseId) {
            this.nurseId = nurseId;
            return this;
        }

        public Nurse build() {
            return new Nurse(id, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary, nurseId);
        }
    }

    // Getters and Setters for Nurse class
    public long getNurseId() {
        return nurseId;
    }
}
