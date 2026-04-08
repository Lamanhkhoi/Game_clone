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

        for(int i = this.Pipes.size() - 1; i >= 0; i--){
            pipe currentPipe = this.Pipes.get(i);
            currentPipe.move();

            if (this.Bird.getX() > currentPipe.getX() + currentPipe.getWidth() && !currentPipe.isPassed()) {
                this.Score += 1;
                currentPipe.setPassed(true); 
            }

            if (this.Bird.getBounds().intersects(currentPipe.getBounds())) {
                this.isGameOver = true;
            }
            if (this.Bird.getY() > 600) {
                this.isGameOver = true;
            }

            if (currentPipe.getX() + currentPipe.getWidth() < 0) {
                this.Pipes.remove(i); 
            }
        }
    }

    public void spawnPipe(){
        int pipeX = 800; 
        int gap = 150;
        int topHeight = 100 + this.ramdomGenerator.nextInt(200);
        pipe topPipe = new pipe(pipeX, 0, topHeight); 
        this.Pipes.add(topPipe);
        int bottomY = topHeight + gap;
        int bottomHeight = 600 - bottomY;
        pipe bottomPipe = new pipe(pipeX, bottomY, bottomHeight);
        this.Pipes.add(bottomPipe);
    }

    public void birdJump(){
        if(!isGameOver){
            this.Bird.jump();
        }
    }

    public bird getBird() {
        return Bird;
    }

    public ArrayList<pipe> getPipes() {
        return Pipes;
    }

    public int getScore() {
        return Score;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

}
