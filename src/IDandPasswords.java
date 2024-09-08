import java.util.HashMap;

public class IDandPasswords
{
    HashMap<String,String> loginInfo=new HashMap<>();
    IDandPasswords()
    {
        loginInfo.put("Younes","ECPC");
        loginInfo.put("DrHagar","TheBest");
        loginInfo.put("admin","admin123");
    }
    protected HashMap getloginInfo()
    {
        return this.loginInfo;
    }
}
