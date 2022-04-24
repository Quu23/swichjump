package pac;

public class Player {

    int x,y;
    private static Player instance=null;
    int jumpCoolTime=0;

    private Player(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public static Player getInstance(int x,int y){
        if(instance==null){
            instance = new Player(x, y);
        }
        return instance;
    }

    public void jump() {
        this.y -= 5;
    }
    
}
