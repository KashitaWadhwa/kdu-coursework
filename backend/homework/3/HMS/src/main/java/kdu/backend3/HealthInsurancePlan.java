package kdu.backend3;

public abstract class HealthInsurancePlan {
    private double coverage;
    private InsuranceBrand offeredBy;

    // Constructor
    public HealthInsurancePlan(double coverage) {
        this.coverage = coverage;
    }

    // Getter and Setter for coverage
    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    /**
     *  Question 4 Abstract method for computing monthly premium
     */
    // Abstract method for computing monthly premium
//    public double computeMonthlyPremium(double salary) {
//        return 0;
//    }

    // Abstract method for computing monthly premium



    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0;
    }
    // Helper method to calculate premium based on InsuranceBrand rules
    protected double computePremiumBasedOnBrand(int age, boolean smoking) {
        return getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

    public abstract double computeMonthlyPremium(double salary);
}

