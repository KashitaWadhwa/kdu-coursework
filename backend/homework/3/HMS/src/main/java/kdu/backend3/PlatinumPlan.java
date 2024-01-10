package kdu.backend3;

public abstract class PlatinumPlan extends HealthInsurancePlan {
    // Constructor for PlatinumPlan
    public PlatinumPlan() {
        super(0.9);
    }

    /**
     * @param salary Question 3 Abstract method for computing monthly premium
     * @return
     */

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }





// Implement similar methods in GoldPlan, SilverPlan, and BronzePlan

}
