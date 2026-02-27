import java.util.HashMap;

public class IDandPasswords {

    HashMap<String, String> logininfo = new HashMap<String, String>();

    IDandPasswords() {
        logininfo.put("Dimonie", "Chipotle08");
        logininfo.put("Dimonie2", "Chipotle08");
        logininfo.put("Dimonie3", "Chipotle08");
    }

    protected HashMap getLoginInfo() {
        return logininfo;
    }
}