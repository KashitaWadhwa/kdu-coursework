package kdu.backend3;

//public class Main {
//    public static void main(String[] args) {
//        HealthInsurancePlan insurancePlan = new PlatinumPlan();
//        Patient patient = new Patient(1, "John", "Doe", "Male", "john.doe@example.com", 123, true);
//        patient.setInsurancePlan(insurancePlan);
//
//        double[] payments = Billing.computePaymentAmount(patient, 1000.0);
//
//        System.out.println("Insurance Payment: " + payments[0]);
//        System.out.println("Patient Payment: " + payments[1]);
//    }
//}
public class Main {
    public static void main(String[] args) {
        // Assuming your User class constructor requires these arguments
        User staff = new User(1L, "John", "Doe", "Male", "john.doe@example.com");

        // Create an insurance brand (e.g., BlueCrossBlueShield)
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();

        // Create a health insurance plan (e.g., PlatinumPlan)
        HealthInsurancePlan insurancePlan = new PlatinumPlan() {
            @Override
            public double computeMonthlyPremium(double salary) {
                return 0;
            }
        };

        // Set the insurance brand for the plan
        insurancePlan.setOfferedBy(insuranceBrand);

        // Set the insurance plan for the user
        staff.setInsurancePlan(insurancePlan);

        // Calculate and display the monthly premium
        double monthlyPremium = insurancePlan.computeMonthlyPremium(5000, 56, true);
        System.out.println("Monthly Premium: $" + monthlyPremium);
    }
}
