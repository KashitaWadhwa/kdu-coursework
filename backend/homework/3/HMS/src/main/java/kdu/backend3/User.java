package kdu.backend3;

package kdu.backend3;
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;


    // Constructor
    public User(long id, String firstName, String lastName, String gender, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    private int age;
    private boolean smoking;

    // Getters and Setters for age and smoking
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getters and Setters for Name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getters and Setters for Gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getters and Setters for Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    private boolean insured;
    private HealthInsurancePlan insurancePlan;

    /**
     * Question 3 Getters and Setters for insured and insurancePlan
     */
    // Getters and Setters for insured and insurancePlan
    
    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public HealthInsurancePlan getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }
    /**
     * Question 4
     * */

    private int age;
    private boolean smoking;

    // Getters and Setters for age and smoking
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }
}

