package pac;

import java.util.Objects;

public class Block {
    int x;
    int width;
    boolean isRed;
    int id; //ブロックに振られるランダムな値。識別子。

    Block(int x,int width){
        this.x = x;
        this.width = width;
        this.isRed = Block.randIsRed();
        this.id = new java.util.Random().nextInt();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)return true;
        if(obj==null)return false;
        if(!(obj instanceof Block))return false;
        Block b = (Block)obj;
        if(!(this.x==b.x&&this.id==b.id))return false;
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.x,this.width,this.isRed,this.id);
    }
    public static boolean randIsRed(){
        switch(new java.util.Random().nextInt(2)){
            case 0:
                return true;
            case 1:
                return false;
            default:
                return true;
        }
    }
}
