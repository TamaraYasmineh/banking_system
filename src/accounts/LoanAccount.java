package accounts;

import interest.LoanInterestStrategy;

public class LoanAccount extends BaseAccount {
    private LoanInterestStrategy loanInterestStrategy;

    public LoanAccount(String id, LoanInterestStrategy strategy) {
        super(id);
        this.loanInterestStrategy = strategy;
    }

    public double calculateInterest() {
        return loanInterestStrategy.calculate(balance);
    }
}
