import javax.swing.JFrame;
import View.GameView;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo cái khung cửa sổ
        JFrame window = new JFrame("Flappy Bird Clone - By IT Student");
        
        // 2. Tạo tờ giấy vẽ của chúng ta
        GameView view = new GameView();

        // 3. Dán tờ giấy vẽ vào khung cửa sổ
        window.add(view);

        // 4. Thiết lập các thông số cho cửa sổ
        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setLocationRelativeTo(null); 
        
        window.setVisible(true);
    }
}