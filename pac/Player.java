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

        this.y += jumpTime > 20 ? -1*jumpSpeed : jumpSpeed ;
        
        if(jumpSpeed-20 == 7 || jumpSpeed-20 == 5 || jumpSpeed-20 == 3 || jumpSpeed-20 == 2){
            jumpSpeed--;
        }else if(jumpSpeed == 18 || jumpSpeed == 17 || jumpSpeed == 15 || jumpSpeed == 13){
            jumpSpeed++;
        }

        jumpTime--;
        if(jumpTime==0)isFly=false;
    }
    
}
