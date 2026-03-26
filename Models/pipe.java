package Models;

import java.awt.Rectangle;

public class pipe {
    
    private int x,y;
    private int width, height;
    private int velocity;
    private boolean isPassed;
    
    public pipe(int startX, int startY, int pipeHeight) {
        this.x = startX;
        this.y = startY;
        this.height = pipeHeight;
        
        this.width = 64;
        this.velocity = 3;
        this.isPassed = false;
    }

    public void move(){
        this.x = this.x - this.velocity;
    }

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getVelocity() {
        return velocity;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

}
