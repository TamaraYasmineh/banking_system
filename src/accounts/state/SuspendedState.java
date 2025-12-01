package accounts.state;

import accounts.BaseAccount;

public class SuspendedState implements AccountState {
    @Override
    public void deposit(BaseAccount acc, double amount) {
        // maybe allow deposit but not withdraw
        acc.balance += amount;
    }

    @Override
    public void withdraw(BaseAccount acc, double amount) {
        throw new IllegalStateException("Account suspended: withdrawals blocked");
    }
}
