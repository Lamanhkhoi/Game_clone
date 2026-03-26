package Models;

import java.awt.Rectangle;

public class bird {
    
    private int x,y;
    private int width, height;

    private double velocity;
    private double gravity;
    private double jumpStrength;


    public bird(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.width = 34;        
        this.height = 24;

        this.velocity = 0;      
        this.gravity = 0.5;     
        this.jumpStrength = -9;
    }

    public void jump(){
        this.velocity = this.jumpStrength;
    }
    
    public void update(){
        this.velocity += this.gravity;
        this.y = (int) this.velocity;
    }

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
