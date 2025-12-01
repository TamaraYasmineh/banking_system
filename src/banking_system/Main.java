package banking_system;

import accounts.CheckingAccount;
import accounts.SavingsAccount;
import accounts.state.ActiveState;
import interest.SimpleInterestStrategy;
import notifications.EmailNotifier;
import notifications.SMSNotifier;

public class Main {
    public static void main(String[] args) {
        BankFacade facade = new BankFacade();

        // sample accounts
        SavingsAccount sa = new SavingsAccount("SAV-001", new SimpleInterestStrategy(0.03));
        sa.setState(new ActiveState());
        sa.deposit(1000);

        CheckingAccount ca = new CheckingAccount("CHK-001");
        ca.setState(new ActiveState());
        ca.deposit(500);

        // register notifiers
        facade.registerNotifier(new EmailNotifier("tamaraforit@gmail.com"));
        facade.registerNotifier(new SMSNotifier("+963939387014"));

        // perform transfer
        facade.transfer(sa.getId(), ca.getId(), 200);

        System.out.println("Savings balance: " + sa.getBalance());
    }
}
