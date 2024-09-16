package kdu.backend3;

class FactorFactorialThread
{

    public static void main(String[] args) {
        Factor obj = new Factor(12);
        Factorial obj2 = new Factorial(5);
        try {
            obj2.t.join();
            obj.t.join();
        } catch (InterruptedException e) {
            Logging.logInfo("Thread interrupted: " + e);
            Thread.currentThread().interrupt();

        }

        Logging.logInfo("Exiting main thread");
    }

}