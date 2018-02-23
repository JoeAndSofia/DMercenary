package study_swing.dmercenary.unit.game.interphase;

import java.awt.Font;
import java.awt.Insets;

/**
 * interface constant
 * @author Lenovo
 *
 */
public class IC {
	public static final int LTX = 10;		//LEFT_TOP_X
	public static final int LTY = 10;		//LEFT_TOP_Y
	public static final int BT = 2;		//BORDER_THICKNESS
	public static final int SSL = 16;		//SQUARE_SIDE_LENGTH
	public static final int MAIN_PANEL_WIDTH = 720;
	public static final int MAIN_PANEL_HEIGHT = 480;
	public static final int RG = 300;		//RIGHT_GAP
	public static final int BG = 100;		//BOTTOM_GAP
	public static final Insets CONTROL_INSETS = new Insets(2,2,2,2);
	public static final Insets BEING_SQUARE_INSETS = new Insets(0,0,0,0);
	public static boolean CANZOOM = true;
	
	public static Font CONTROL_FONT = new Font("Arial",Font.BOLD+Font.ITALIC,12);
}
