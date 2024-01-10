package kdu.backend3;

public class Staff extends User {
    private long staffId;
    private int yearsOfExperience;
    private String description;
    private double salary;

    // Constructor
    public Staff(long id, String firstName, String lastName, String gender, String email,
                 long staffId, int yearsOfExperience, String description, double salary) {
        super(id, firstName, lastName, gender, email);
        this.staffId = staffId;
        this.yearsOfExperience = yearsOfExperience;
        this.description = description;
        this.salary = salary;
    }

    // Getters and Setters for Staff class
    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}


