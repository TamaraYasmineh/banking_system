package notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationSubject {
    private final List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver obs) { observers.add(obs); }
    public void removeObserver(NotificationObserver obs) { observers.remove(obs); }

    public void notifyAll(String msg) {
        observers.forEach(o -> {
            try { o.update(msg); } catch (Exception e) { /* log */ }
        });
    }
}
