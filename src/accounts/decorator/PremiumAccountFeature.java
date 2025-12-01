package accounts.decorator;

import accounts.Account;

public class PremiumAccountFeature extends AccountDecorator {
    public PremiumAccountFeature(Account wrapped) {
        super(wrapped);
    }

    public void applyCashback(double percentage) {
        double cb = wrapped.getBalance() * (percentage / 100.0);
        wrapped.deposit(cb);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }
}
