package transactions;

public class AutoApprovalHandler extends ApprovalHandler {
    private final double threshold;

    public AutoApprovalHandler(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void approve(Transaction tx) {
        if (tx.amount <= threshold) {
            System.out.println("Auto-approved tx " + tx.id);
        } else if (next != null) {
            next.approve(tx);
        } else {
            System.out.println("No handler available for tx " + tx.id);
        }
    }
}
