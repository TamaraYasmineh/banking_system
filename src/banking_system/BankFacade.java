package banking_system;

import adapters.PaymentGateway;
import adapters.LegacyPaymentAdapter;
import adapters.LegacyPaymentAPI;
import notifications.NotificationSubject;
import transactions.AutoApprovalHandler;
import transactions.ManagerApprovalHandler;
import transactions.TellerApprovalHandler;
import transactions.TransactionService;
import transactions.ApprovalHandler;
import utils.AuditLog;

public class BankFacade {
    private final TransactionService txService;
    private final NotificationSubject notifier;
    private final ApprovalHandler approvalChain;

    public BankFacade() {
        notifier = new NotificationSubject();
        LegacyPaymentAPI legacyAPI = new LegacyPaymentAPI();
        PaymentGateway gateway = new LegacyPaymentAdapter(legacyAPI);

        // build approval chain: auto -> teller -> manager
        AutoApprovalHandler auto = new AutoApprovalHandler(1000.0);
        TellerApprovalHandler teller = new TellerApprovalHandler(10000.0);
        ManagerApprovalHandler manager = new ManagerApprovalHandler();
        auto.setNext(teller);
        teller.setNext(manager);
        approvalChain = auto;

        txService = new TransactionService(approvalChain, notifier, gateway);
    }

    public void registerNotifier(notifications.NotificationObserver obs) {
        notifier.addObserver(obs);
    }

    public void transfer(String from, String to, double amount) {
        transactions.Transaction tx = new transactions.Transaction(from, to, amount);
        AuditLog.log("Facade initiating transfer " + tx.id);
        txService.process(tx);
    }

    // other facade methods (create account, get balance, etc.) can be added here
}
