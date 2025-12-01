package utils;
import java.io.IOException;
import java.util.logging.*;

public class AuditLog {
    public static void log(String msg) {
        // simplistic audit logger
        System.out.println("[AUDIT] " + System.currentTimeMillis() + " - " + msg);
    }
}


//public class AuditLog {
//
//    private static final java.util.logging.Logger auditLogger = java.util.logging.Logger.getLogger("AuditLogger");
//
//    static {
//        try {
//            Handler fileHandler = new FileHandler("logs/audit.log", true);
//            fileHandler.setFormatter(new SimpleFormatter());
//            auditLogger.addHandler(fileHandler);
//
//            auditLogger.setUseParentHandlers(false);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void log(String msg) {
//        auditLogger.log(Level.INFO, msg);
//    }
//}
