package pac;

import java.util.Objects;

public class Block {
    int x;
    int width;
    boolean isRed;
    int id; //ブロックに振られるランダムな値。特に意味はない。

    Block(int x,int width,boolean isRed){
        this.x = x;
        this.width = width;
        this.isRed = isRed;
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
}
