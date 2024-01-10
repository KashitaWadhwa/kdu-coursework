package kdu.backend3;

public class Billing {
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if (patientInsurancePlan != null) {
            // Calculate insurance coverage
            double coverage = patientInsurancePlan.getCoverage();
            double insurancePayment = amount * coverage;

            // Apply discount based on insurance plan
            double discount = 0.0;
            if (patientInsurancePlan instanceof PlatinumPlan) {
                discount = 50.0;
            } else if (patientInsurancePlan instanceof GoldPlan) {
                discount = 40.0;
            } else if (patientInsurancePlan instanceof SilverPlan) {
                discount = 30.0;
            } else if (patientInsurancePlan instanceof BronzePlan) {
                discount = 25.0;
            }

            // Calculate patient's part after discount
            double patientPayment = (amount - insurancePayment) - discount;

            payments[0] = insurancePayment;
            payments[1] = patientPayment;
        } else {
            // No insurance plan, apply default discount
            double patientPayment = amount - 20.0;

            payments[0] = 0.0; // Insurance pays 0
            payments[1] = patientPayment;
        }

        return payments;
    }
}
