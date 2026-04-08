package View;

import Controller.GameLogic; 
import Models.bird;         
import Models.pipe;          

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameView extends JPanel{
    private GameLogic gameLogic;

    public GameView() {
        this.gameLogic = new GameLogic(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        // 1. VẼ BẦU TRỜI (Nền game)
        g.setColor(Color.CYAN); 
        g.fillRect(0, 0, 800, 600); 

        // 2. VẼ CON CHIM
        bird b = this.gameLogic.getBird(); 
        g.setColor(Color.YELLOW);          
        g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight()); 

        // 3.Vẽ Ống nước
        ArrayList<pipe> pipeList = this.gameLogic.getPipes(); 
        
        g.setColor(Color.GREEN); 
        for (pipe p : pipeList) {
            g.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
        }

        // 4. VẼ ĐIỂM SỐ VÀ GAME OVER (Tặng thêm cho bạn)
        g.setColor(Color.WHITE);
        g.drawString("Score: " + this.gameLogic.getScore(), 10, 20); 

        if (this.gameLogic.isGameOver()) {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 350, 300); 
        }
    }
}
