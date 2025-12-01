package accounts.state;

import accounts.BaseAccount;

public class ActiveState implements AccountState {
    @Override
    public void deposit(BaseAccount acc, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        acc.balance += amount;
    }

    @Override
    public void withdraw(BaseAccount acc, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (acc.balance < amount) throw new RuntimeException("Insufficient funds");
        acc.balance -= amount;
    }
}
