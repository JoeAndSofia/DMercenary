package study_swing.dmercenary.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class UIUtil {
	public static RoundBorder getRoundBorder(){
		return new RoundBorder();
	}
	
	static class RoundBorder implements Border{
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.setColor(Color.BLACK);
			g.drawRoundRect(0, 0, c.getWidth()-1, c.getHeight()-1, 5, 5);
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(0, 0, 0, 0);
//			return null;
		}

		@Override
		public boolean isBorderOpaque() {
			return false;
		}
	}
	
	static class SelectedBorder implements Border{

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.setColor(Color.ORANGE);
//			g.draw
		}

		@Override
		public Insets getBorderInsets(Component c) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isBorderOpaque() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
