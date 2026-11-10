package facadepattern1;

/**
 * Subsystem Class 5: FraudDetectionService
 * Responsible for screening transactions for suspicious or fraudulent activity
 * before any money is charged.
 */
public class FraudDetectionService {

    // Orders above this amount are treated as suspicious (mock rule for the demo)
    private static final double MAX_SAFE_AMOUNT = 5000.00;

    /**
     * Step 1: Check whether the transaction looks legitimate.
     *
     * @param customerId The customer placing the order.
     * @param amount The total amount of the order.
     * @return true if the transaction is safe to process, false if it looks fraudulent.
     */
    public boolean isTransactionSafe(String customerId, double amount) {
        // Step 1.1: Run risk analysis on customer and amount
        System.out.println("[FraudDetectionService] Step 1: Screening transaction of $" + amount + " for customer: " + customerId);

        // Step 1.2: Apply mock risk rule (non-positive or too large amounts are suspicious)
        boolean safe = amount > 0 && amount <= MAX_SAFE_AMOUNT;
        System.out.println("[FraudDetectionService] Step 2: Transaction " + (safe ? "approved" : "flagged as suspicious"));
        return safe;
    }
}
