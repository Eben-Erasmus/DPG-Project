package gui;

public class LoginResult
{
    public String access;
    public int memberID;

    public LoginResult(String access, int memberID)
    {
        this.access = access;
        this.memberID = memberID;
    }

    public String getAccess()
    {
        return access;
    }

    public int getMemberID()
    {
        return memberID;
    }
}
