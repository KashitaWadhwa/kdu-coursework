package kdu.backend3;

/**
 * Question 4
 */
public class BlueCrossBlueShield implements InsuranceBrand {
    private long id;
    private String name;

    // Getters and Setters for id and name

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
        double premium = 0.0;

        // Specific rules for BlueCrossBlueShield
        if (age > 55) {
            premium += 50.0; // Base increase for age > 55
        }

        if (smoking) {
            premium += 30.0; // Additional increase for smoking
        }

        return premium;
    }
}
