public class ATM {
    public int ID;
    static public int ID_COUNTER=0;
    private double allMoney;
    Mode mode=Mode.WAIT;

    ATM(double allMoney) {
        this.allMoney = allMoney;
    }

    public double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(double allMoney) {
        this.allMoney = allMoney;
    }

    public void setMode(Mode mode){
        this.mode=mode;
    }

    public Mode getMode() {
        return mode;
    }

    static public boolean Verivication_prototype(int PIN){
        return true;
    }
}
