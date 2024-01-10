package kdu.backend3;

public abstract class SilverPlan extends HealthInsurancePlan {
    // Constructor for SilverPlan
    protected SilverPlan() {
        super(0.7);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.06 * salary + computePremiumBasedOnBrand(age, smoking);
    }
}
