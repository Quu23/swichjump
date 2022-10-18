package pac;

public class Player {

    // W:46 H:23

    int x,y;
    private static Player instance=null;
    int jumpTime = 0;
    final int INITIAL_VELOCITY =-30;//初速度
    final int ACCELERATION = 5; //加速度
    final int HIGHEST_TIME=(int)(-INITIAL_VELOCITY/ACCELERATION);
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

        this.y=INITIAL_VELOCITY*this.jumpTime+(ACCELERATION*this.jumpTime*this.jumpTime)/2+377;

        jumpTime++;

        if(jumpTime==HIGHEST_TIME*2+1){
            isFly=false;
            this.jumpTime=0;
        }
    }
    
}
