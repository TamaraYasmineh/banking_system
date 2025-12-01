package accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountGroup implements Account {
    private String id;
    private final List<Account> accounts = new ArrayList<>();

    public AccountGroup(String id) {
        this.id = id;
    }

    public void add(Account acc) { accounts.add(acc); }
    public void remove(Account acc) { accounts.remove(acc); }
    public List<Account> getChildren() { return new ArrayList<>(accounts); }

    @Override
    public String getId() { return id; }

    @Override
    public double getBalance() {
        return accounts.stream().mapToDouble(Account::getBalance).sum();
    }

    @Override
    public void deposit(double amount) {
        // distribute proportionally or equally; simple equal split here
        if (accounts.isEmpty()) return;
        double per = amount / accounts.size();
        accounts.forEach(a -> a.deposit(per));
    }

    @Override
    public void withdraw(double amount) {
        if (accounts.isEmpty()) return;
        double per = amount / accounts.size();
        accounts.forEach(a -> a.withdraw(per));
    }
}
