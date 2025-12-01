package accounts;

import accounts.state.AccountState;

public abstract class BaseAccount implements Account {
    protected String id;
    public double balance;
    protected AccountState state;

    public BaseAccount(String id) {
        this.id = id;
        this.balance = 0.0;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public AccountState getState() {
        return state;
    }

    @Override
    public String getId() { return id; }

    @Override
    public double getBalance() { return balance; }

    @Override
    public void deposit(double amount) {
        if (state != null) state.deposit(this, amount);
        else balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (state != null) state.withdraw(this, amount);
        else balance -= amount;
    }
}
