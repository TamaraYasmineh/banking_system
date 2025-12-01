package transactions;

import adapters.PaymentGateway;
import utils.AuditLog;
import notifications.NotificationSubject;

public class TransactionService {
    private ApprovalHandler approvalChain;
    private NotificationSubject notifier;
    private PaymentGateway paymentGateway;

    public TransactionService(ApprovalHandler chain, NotificationSubject notifier, PaymentGateway gateway) {
        this.approvalChain = chain;
        this.notifier = notifier;
        this.paymentGateway = gateway;
    }

    public void process(Transaction tx) {
        approvalChain.approve(tx);
        // here you would perform debit/credit on accounts (omitted)
        boolean paid = paymentGateway.pay(tx.amount);
        AuditLog.log("Processed tx " + tx.id + " paid=" + paid);
        notifier.notifyAll("Transaction " + tx.id + " processed.");
    }
}
