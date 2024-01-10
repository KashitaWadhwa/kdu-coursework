package kdu.backend3;
package kdu.backend3;

public class Staff extends User {
    private long staffId;
    private int yearsOfExperience;
    private String description;
    private double salary;
    // Constructor
    private Staff(long id, String firstName, String lastName, String gender, String email,
                  long staffId, int yearsOfExperience, String description, double salary) {
        super(id, firstName, lastName, gender, email);
        this.staffId = staffId;
        this.yearsOfExperience = yearsOfExperience;
        this.description = description;
        this.salary = salary;
    }

    public static class Builder {
        private long id;
        private String firstName;
        private String lastName;
        private String gender;
        private String email;
        private long staffId;
        private int yearsOfExperience;
        private String description;
        private double salary;

        public Builder(long id, String firstName, String lastName, String gender, String email) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.email = email;
        }

        public Builder staffId(long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder yearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public Staff build() {
            return new Staff(id, firstName, lastName, gender, email, staffId, yearsOfExperience, description, salary);
        }
    }
}
