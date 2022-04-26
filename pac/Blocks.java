package pac;

import java.util.ArrayList;
import java.util.List;

public class Blocks {

    List<Block> blocks;
    int blocksWidth=0;

    Blocks(){
        this.blocks = new ArrayList<>();
        this.blocks.add(new Block(0, 0));
    }
    public void add(){
        if(blocksWidth<500){
            int width = new java.util.Random().nextInt(501-blocksWidth);
            int lastBlockIndex =  this.blocks.size() == 1 ? 1 : this.blocks.size()-1;   
            Block block = new Block(this.blocks.get(lastBlockIndex).x,width);
            blocks.add(block);
        }
    }
    public void pop(){
        this.blocks.remove(0);
    }
}
