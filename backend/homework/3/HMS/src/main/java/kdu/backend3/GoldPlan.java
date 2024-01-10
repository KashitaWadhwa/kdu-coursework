package kdu.backend3;

public abstract class GoldPlan extends HealthInsurancePlan {
    // Constructor for GoldPlan
    protected GoldPlan() {
        super(0.8);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.07 * salary + computePremiumBasedOnBrand(age, smoking);
    }


}
