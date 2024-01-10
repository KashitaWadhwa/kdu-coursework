package kdu.backend3;

public abstract class BronzePlan extends HealthInsurancePlan {
    // Constructor for BronzePlan
    protected BronzePlan() {
        super(0.6);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return 0.05 * salary + computePremiumBasedOnBrand(age, smoking);
    }
}
