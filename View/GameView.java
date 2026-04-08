package View;

import Controller.GameLogic;
import Models.bird;
import Models.pipe;

import javax.swing.JPanel;
import javax.swing.Timer; // Thêm Timer
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Implement thêm ActionListener (cho Timer) và KeyListener (cho Bàn phím)
public class GameView extends JPanel implements ActionListener, KeyListener {
    
    private GameLogic gameLogic;
    private Timer gameTimer; // Biến đồng hồ nhịp tim

    public GameView() {
        this.gameLogic = new GameLogic(); 

        // --- CÀI ĐẶT BÀN PHÍM ---
        this.setFocusable(true); // Cực kỳ quan trọng: Cho phép tờ giấy này nhận tín hiệu bàn phím
        this.addKeyListener(this); // Gắn cái "tai nghe" vào tờ giấy

        // --- CÀI ĐẶT NHỊP TIM (GAME LOOP) ---
        // Tham số đầu tiên: 16 (mili-giây) -> 1000ms / 16 = khoảng 60 khung hình/giây
        // Tham số thứ hai: this (chỉ định class này sẽ nhận nhịp đập)
        this.gameTimer = new Timer(16, this); 
        this.gameTimer.start(); // Bắt đầu đập!
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        // 1. VẼ BẦU TRỜI
        g.setColor(Color.CYAN); 
        g.fillRect(0, 0, 800, 600); 

        // 2. VẼ CON CHIM
        bird b = this.gameLogic.getBird(); 
        g.setColor(Color.YELLOW);          
        g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight()); 

        // 3. VẼ CÁC ỐNG NƯỚC
        g.setColor(Color.GREEN); 
        for (pipe p : this.gameLogic.getPipes()) {
            g.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
        }

        // 4. VẼ ĐIỂM SỐ VÀ GAME OVER
        g.setColor(Color.WHITE);
        g.drawString("Score: " + this.gameLogic.getScore(), 10, 20); 

        if (this.gameLogic.isGameOver()) {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 350, 300); 
        }
    }

    // ==========================================================
    // NHỮNG HÀM DƯỚI ĐÂY BẮT BUỘC PHẢI CÓ KHI IMPLEMENT INTERFACE
    // ==========================================================

    // Hàm này được Timer gọi tự động mỗi 16ms
    @Override
    public void actionPerformed(ActionEvent e) {
        this.gameLogic.updateStatus(); // Bảo não bộ cập nhật tọa độ
        this.repaint(); // Lệnh cực quan trọng: Ép JPanel phải xóa màn hình và chạy lại paintComponent()
    }

    // Hàm này kích hoạt khi bạn NHẤN một phím xuống
    @Override
    public void keyPressed(KeyEvent e) {
        // Nếu phím vừa nhấn là dấu CÁCH (Spacebar)
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.gameLogic.birdJump(); // Gọi hàm bay lên
        }
    }

    // Hai hàm này của KeyListener bắt buộc phải khai báo, dù ta không dùng tới
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}