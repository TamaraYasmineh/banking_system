package accounts;

import interest.InterestStrategy;

public class InvestmentAccount extends BaseAccount {
    private InterestStrategy strategy;

    public InvestmentAccount(String id, InterestStrategy strategy) {
        super(id);
        this.strategy = strategy;
    }

    public double calculateReturn() {
        return strategy.calculate(balance);
    }
}
