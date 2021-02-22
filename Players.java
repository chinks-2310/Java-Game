public class Players {
    public String email;
    public int BankRoll;
    public String userName;
    public Players(String email,int BankRoll,String userName) {
        this.email=email;
        this.BankRoll=BankRoll;
        this.userName=userName;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public String getEmail() {
        return email;
    }
    public void setBankRoll(int bankRoll) {
        this.BankRoll=bankRoll;
    }
    public int getBankRoll() {
        return BankRoll;
    }
    public void setUserName(String userName) {
        this.userName=userName;
    }
    public String getUserName() {
        return userName;
    }
}
