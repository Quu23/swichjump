package pac;

public class Player {

    // W:46 H:23

    int x,y;
    private static Player instance=null;
    int jumpTime=0;
    boolean isFly=false;

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
        if(jumpTime==0){
            jumpTime = 20;
            isFly=true;
        }
        this.y += jumpTime > 10 ? -5 : 5 ;
        
        jumpTime--;
        if(jumpTime==0)isFly=false;
    }
    
}
