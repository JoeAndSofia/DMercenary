package study008_swing.dmercenary.unit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMapper extends JFrame {
	private static final int LTX = 10;		//LEFT_TOP_X
	private static final int LTY = 10;		//LEFT_TOP_Y
	private static final int MAIN_PANEL_WIDTH = 720;
	private static final int MAIN_PANEL_HEIGHT = 480;
	
	private JPanel sandboxTemplate = new JPanel();
	private JPanel controlPanel = new JPanel();
	
	private void init(){
		sandboxTemplate.setBounds(LTX, LTY, MAIN_PANEL_WIDTH, MAIN_PANEL_HEIGHT);
		sandboxTemplate.setFocusable(true);
		
		
	}
}
