package study_swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class SwingTerminal extends JFrame{
	private JPanel main = new JPanel();
	private JTextArea input = new JTextArea();
	
	public static void main(String[] args){
		SwingTerminal st = new SwingTerminal();
		st.init();
	}
	
	private void init(){
		this.setBounds(100, 100, 600, 450);
		
		input.setBorder(new BevelBorder(BevelBorder.LOWERED));
		input.setEditable(true);
		input.setLineWrap(true);
		input.setRows(29);
		input.setText("input here!");
		input.setFocusable(true);
		
		System.out.println(input.getFont());
		main.setBounds(10, 10, 580, 410);
		main.setLayout(new BorderLayout());
		main.add(input);
		
		this.add(main);
		this.setVisible(true);
		
		System.out.println(this.getLayout().toString());
		System.out.println(main.getLayout().toString());		
		
	}
}
