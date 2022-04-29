package pac;

import java.util.ArrayList;
import java.util.List;

public class Blocks {

    List<Block> blocks;
    int blocksWidth=500;

    Blocks(){
        this.blocks = new ArrayList<>();
        this.blocks.add(new Block(0  , 100));
        this.blocks.add(new Block(100, 100));
        this.blocks.add(new Block(200, 100));
        this.blocks.add(new Block(300, 100));
        this.blocks.add(new Block(400, 100));
    
    }
    public void add(){
        if(blocksWidth<500){
            int width = new java.util.Random().nextInt(491-blocksWidth)+10;
            int lastBlockIndex = this.blocks.size()-1;   
            Block block = new Block(this.blocks.get(lastBlockIndex).x,width);
            this.blocksWidth += block.width;
            this.blocks.add(block);
        }
    }
    public void move(){
        for(int i=0;i<this.blocks.size();i++){
            if(i==0){
                this.blocks.get(i).width--;
            }else{
                this.blocks.get(i).x--;
            }       
        }
        if(this.blocks.get(0).width<1){
            this.pop();
        }
        
    }
    public void pop(){
        this.blocksWidth -= this.blocks.get(0).width;
        this.blocks.remove(0);
    }
}
