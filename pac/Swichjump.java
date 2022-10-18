package pac;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Swichjump extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    GraphicsContext g;

    Image img =	new Image(new File("img/slimec.png").toURI().toString());

    Player player = Player.getInstance(10,377);

    Blocks blocks = new Blocks();

    boolean isRed=true;

    int time  = 0;
    int score = 0;

    // ０ならゲーム、１ならゲームオーバー、２ならゲームクリア
    int gameFlg = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();

        Canvas canvas = new Canvas(500,500);

        root.getChildren().add(canvas);

        g = canvas.getGraphicsContext2D();

        g.setFont(new Font(30));

        Scene scene = new Scene(root,500,500,Color.WHITE);

        scene.setOnKeyPressed(this::keyPressed);

        stage.setScene(scene);
        
        stage.setTitle("-Swichjump-");

        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                draw();
                if(gameFlg==0){
                    if(player.isFly)player.jump();

                    for(Block b:blocks.blocks){
                        if(
                            //プレイヤーが落下してもよいか。 
                            (((player.x>=b.x&&player.x+46<=b.x+b.width)&&
                            ((isRed&&!b.isRed)||(!isRed&&b.isRed)))||player.y>377)&&!player.isFly
                        ){  
                            player.y+=2;
                            break;
                        }
                    }

                    blocks.move();
                    time+=2;
                    score = time/10;
                    if(time%1000==0){
                        blocks.setMoveSpeed(blocks.getMoveSpeed()+1);
                    }

                    if(score == 500){
                        g.setStroke(Color.BLUE);
                    }else if(score == 1000){
                        g.setStroke(Color.GOLD);
                    }
                    if(score > 1500){
                        gameFlg=2;
                        g.setFont(new Font(50));
                        g.setStroke(Color.YELLOW);
                    }else if(player.y>500){
                        gameFlg=1; 
                        g.setFont(new Font(50));
                        g.setStroke(Color.RED);
                    }
                    // System.out.println(player.y);
                    // System.out.println(player.isFly);
                    // System.out.println(player.jumpTime);
                }
            }
        };
        timer.start();
    }

    private void draw(){
        // 画面を初期化
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 500, 500);

        if(gameFlg==0){
            for(Block block:this.blocks.blocks){
            
                if(block.isRed){
                    // 赤足場の描画
                    g.setFill(new Color(1,0,0, isRed ? 1 : 0.4));
                    g.fillRect(block.x, 400, block.width, 10);
                }else{
                    // 青足場の描画
                    g.setFill(new Color(0,0,1, !isRed ? 1 : 0.4));
                    g.fillRect(block.x, 400, block.width, 10);
                }
    
            }
    
            g.drawImage(img, player.x, player.y);
    
            g.strokeText("Score:"+score, 350, 30);
        }else if(gameFlg==1){
            g.strokeText("GAMEOVER", 150, 200);
            g.strokeText("SCORE:"+score, 150, 250);
        }else{
            g.strokeText("GAMECLEAR", 150, 200);
            g.strokeText("SCORE:"+score, 150, 250);
        }

    }

    private void keyPressed(KeyEvent e) {
 
		switch(e.getCode()) {
		case SPACE:
            if(!player.isFly){
                player.isFly=true;
                isRed = isRed ? false : true;
            }
			break;
		default:
			break;
		}
	}
}
