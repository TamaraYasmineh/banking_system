package transactions;

public class ManagerApprovalHandler extends ApprovalHandler {
    @Override
    public void approve(Transaction tx) {
        // manager approves everything that reaches here
        System.out.println("Manager-approved tx " + tx.id);
    }
}
