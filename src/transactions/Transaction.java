package transactions;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    public final String id;
    public final String fromAccountId;
    public final String toAccountId;
    public final double amount;
    public final LocalDateTime createdAt;

    public Transaction(String from, String to, double amount) {
        this.id = UUID.randomUUID().toString();
        this.fromAccountId = from;
        this.toAccountId = to;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }
}
