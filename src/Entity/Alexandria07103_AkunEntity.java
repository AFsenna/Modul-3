package Entity;
public class Alexandria07103_AkunEntity {
    private String email;
    private String username;
    private String password;
    private int uangR,umur,loop,loopP;
    public Alexandria07103_AkunEntity() {
    }

    public Alexandria07103_AkunEntity(int loop, int loopL) {
        this.loop = loop;
        this.loopP = loopL;
    }
    
    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public int getLoopP() {
        return loopP;
    }

    public void setLoopP(int loopP) {
        this.loopP = loopP;
    }
    
    public String getUsername() {
        return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getUangR() {
        return uangR;
    }
    public void setUangR(int uangR) {
        this.uangR = uangR;
    }
    public int getUmur() {
        return umur;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }
}
