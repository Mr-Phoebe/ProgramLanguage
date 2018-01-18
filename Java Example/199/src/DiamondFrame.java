import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

@SuppressWarnings("restriction")
public class DiamondFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3874680085852175319L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DiamondFrame frame = new DiamondFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public DiamondFrame() {
        setAlwaysOnTop(true);
        setUndecorated(true);// 去掉窗体修饰
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                do_this_mouseClicked(e);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                do_this_windowOpened(e);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 400, 406);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        URL resource = getClass().getResource("photo1.jpg");
        Image image = getToolkit().getImage(resource);
        backgroundPanel.setImage(image);
        contentPane.add(backgroundPanel, BorderLayout.CENTER);
    }
    
    protected void do_this_windowOpened(WindowEvent e) {
        int[] xPoints = { 0, 50, 350, 400, 200, 0 };// 定义各顶点的X坐标
        int[] yPoints = { 200, 100, 100, 200, 400, 200 };// 定义各顶点的Y坐标
        Polygon polygon = new Polygon(xPoints, yPoints, 6);// 创建多边形
        AWTUtilities.setWindowShape(this, polygon);// 设置窗体形状
    }
    
    protected void do_this_mouseClicked(MouseEvent e) {
        dispose();// 销毁窗体
    }
}
