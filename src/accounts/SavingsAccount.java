package accounts;

import interest.InterestStrategy;

public class SavingsAccount extends BaseAccount {
    private InterestStrategy interestStrategy;

    public SavingsAccount(String id, InterestStrategy strategy) {
        super(id);
        this.interestStrategy = strategy;
    }

    public double calculateInterest() {
        return interestStrategy.calculate(balance);
    }
}
