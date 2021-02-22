public class Tables {
    public String name;
    public int betSize;
    public Tables(String name,int betSize) {
        this.name=name;
        this.betSize=betSize;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setBetSize(int betSize) {
        this.betSize=betSize;
    }
    public int getBetSize(){
        return betSize;
    }
}
