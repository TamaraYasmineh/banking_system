package transactions;

public class TellerApprovalHandler extends ApprovalHandler {
    private final double threshold;

    public TellerApprovalHandler(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void approve(Transaction tx) {
        if (tx.amount <= threshold) {
            System.out.println("Teller-approved tx " + tx.id);
        } else if (next != null) {
            next.approve(tx);
        } else {
            System.out.println("No handler available for tx " + tx.id);
        }
    }
}
