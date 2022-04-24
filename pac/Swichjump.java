package pac;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Swichjump extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    GraphicsContext g;

    Player player = Player.getInstance(10,390);

    boolean isRed=true;

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();

        Canvas canvas = new Canvas(500,500);

        root.getChildren().add(canvas);

        g = canvas.getGraphicsContext2D();

        Scene scene = new Scene(root,500,500,Color.WHITE);

        scene.setOnKeyPressed(this::keyPressed);

        stage.setScene(scene);
        
        stage.setTitle("-Swichjump-");

        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                draw();
                if(player.isFly)player.jump();
            }
        };
        timer.start();
    }

    private void draw(){
        // 画面を初期化
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 500, 500);

        for(int i =0 ;i < 10;i+=2){
            // 赤足場の描画
            g.setFill(new Color(1,0,0, isRed ? 1 : 0.4));
            g.fillRect(i*50, 400, 50, 10);
            // 青足場の描画
            g.setFill(new Color(0,0,1, !isRed ? 1 : 0.4));
            g.fillRect((i+1)*50, 400, 50, 10);
        }

        g.setFill(Color.GREEN);
        g.fillRect(player.x, player.y, 10, 10);

    }

    private void keyPressed(KeyEvent e) {
 
		switch(e.getCode()) {
		case SPACE:
            if(!player.isFly){
                isRed = isRed ? false : true;
                player.isFly=true;
            }
			break;
		default:
			break;
		}
	}
}
