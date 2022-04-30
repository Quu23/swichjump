package pac;

public class Player {

    // W:46 H:23

    int x,y;
    private static Player instance=null;
    int jumpTime = 0;
    int jumpSpeed = 0;
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
            jumpTime = 40;
            isFly=true;
            jumpSpeed = 5;
        }
        
        if(jumpTime == 27 || jumpTime == 25 || jumpTime == 23 || jumpTime == 22){
            jumpSpeed--;
        }else if(jumpTime == 18 || jumpTime == 17 || jumpTime == 15 || jumpTime == 13){
            jumpSpeed++;
            if(this.y>377&&this.y<380){
                this.y=377;
                jumpTime=1;
            }
        }
        this.y += jumpTime > 20 ? -1*jumpSpeed : jumpSpeed ;
        jumpTime--;
        if(jumpTime==0)isFly=false;
    }
    
}
