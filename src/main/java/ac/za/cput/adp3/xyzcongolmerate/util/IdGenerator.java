package ac.za.cput.adp3.xyzcongolmerate.util;

import java.rmi.server.UID;
import java.util.UUID;

public class IdGenerator {
    public static String getId(){
      return UUID.randomUUID().toString();
    }
}
