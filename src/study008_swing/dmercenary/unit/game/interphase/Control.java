package study008_swing.dmercenary.unit.game.interphase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import study008_swing.dmercenary.unit.game.util.SaveAndLoad;


public class Control extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1653410850119124699L;
	private static final int DBW = 100;		//DEFAULT_BUTTON_WIDTH
	private static final int DBH = 25;		//DEFAULT_BUTTON_HEIGHT
	
	private JButton next = new JButton();
	private JButton locate = new JButton();
	
	public Control(int x, int y, int width, int height){
		init(x,y,width,height);
	}
	
	private void init(int x, int y, int width, int height){
		
		this.next.setBounds(C.LTX*4, C.LTY*4, DBW, DBH);
		this.next.setText("Next Round");
		this.next.setToolTipText("Give up the rest moves and enter into next Round");
		this.next.setMargin(C.CONTROL_INSETS);
		this.next.setFont(C.CONTROL_FONT);
		
		this.locate.setBounds(C.LTX*6+DBW, C.LTY*4, DBW, DBH);
		this.locate.setText("Locate");
		this.locate.setToolTipText("Locate current unit on the map");
		this.locate.setMargin(C.CONTROL_INSETS);
		this.locate.setFont(C.CONTROL_FONT);
		
		JButton jb1 = new JButton();
		jb1.setBounds(C.LTX*4, C.LTY*4+DBW/2, DBW, DBH);
		jb1.setText("Test");
		jb1.setMargin(C.CONTROL_INSETS);
		jb1.setFont(C.CONTROL_FONT);
		jb1.addActionListener(this);
		
//		dm.update(dm.getGraphics());
		
		this.setLayout(null);
		this.setBounds(x,y,width,height);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
		this.add(next);
		this.add(locate);
		this.add(jb1);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton jb = (JButton)ae.getSource();
		if("test".equalsIgnoreCase(jb.getText())){
			SaveAndLoad sl = new SaveAndLoad();
			DMercenary d = (DMercenary)this.getParent().getParent().getParent().getParent();
			d.setSandbox(sl.loadSandBox("joe"));
		}

		
		this.getParent().update(this.getParent().getGraphics());
	}
}
