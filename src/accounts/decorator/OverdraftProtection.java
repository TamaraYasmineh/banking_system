package accounts.decorator;


import accounts.Account;

public class OverdraftProtection extends AccountDecorator {

    public OverdraftProtection(Account wrapped) {
        super(wrapped);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {
        if (wrapped.getBalance() + 500 >= amount) {
            wrapped.withdraw(amount);
        } else {
            throw new RuntimeException("Overdraft limit exceeded");
        }
    }
}
