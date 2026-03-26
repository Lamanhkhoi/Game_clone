package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Rectangle;
import Models.*;

public class GameLogic {
    
    private bird Bird;
    private ArrayList<pipe> Pipes;

    private int Score;
    private boolean isGameOver;

    private int spawnTimer;
    private Random ramdomGenerator;

    public GameLogic() {
        this.Bird = new bird(100, 200); 
        this.Pipes = new ArrayList<>(); 
        this.Score = 0;
        this.isGameOver = false;
        this.spawnTimer = 0;
        this.ramdomGenerator = new Random();
    }

    public void updateStatus(){
        if(isGameOver){
            return;
        }

        this.Bird.update();
        spawnTimer += 1;

        if(spawnTimer >= 100){
            spawnPipe();
            spawnTimer = 0;
        }
    }

    public spawnPipe(){
        
    }
}
