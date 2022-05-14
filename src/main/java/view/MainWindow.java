package main.java.view;


import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainWindow extends JPanel {

	private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 625;
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 70;
    private static final int MARGIN_X = 20;
    private static final int MARGIN_Y = 60;

    private JFrame window; // Main window
	
	
	public MainWindow(int ui) {

		JPanel panel = new JPanel();
		
		window = new JFrame("Tuc Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(panel);
        window.pack();
        window.setVisible(true);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	
	}
}