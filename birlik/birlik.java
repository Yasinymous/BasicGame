package birlik;


public abstract class birlik {
    private int hp;
    private int dp;
    private int ap;

    public birlik(int hp, int dp, int ap) {
        this.hp = hp;
        this.dp = dp;
        this.ap = ap;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }
}
