package study008_swing.dmercenary.game.basic;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Matter extends JButton{
	private Shape shape = null;// 用于保存按钮的形状,有助于侦听单击按钮事件
	public Matter(String label) {
		super(label);
		this.addMouseListener(new MouseAdapter(){
			/**
			 * {@inheritdoc}
			 */
			public void mouseEntered(MouseEvent e) {
				((JButton)e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			/**
			 * {@inheritdoc}
			 */
			public void mouseExited(MouseEvent e) {
				((JButton)e.getSource()).setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
		});
		Dimension size = getPreferredSize();// 获取按钮的最佳大小
		// 调整按钮的大小,使之变成一个方形
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		// 使jbutton不画背景,即不显示方形背景,而允许我们画一个圆的背景
		setContentAreaFilled(false);
	}
	// 画图的按钮的背景和标签
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			// getmodel方法返回鼠标的模型buttonmodel
			// 如果鼠标按下按钮，则buttonmodel的armed属性为真
			g.setColor(Color.LIGHT_GRAY);
		} else {
			// 其他事件用默认的背景色显示按钮
			g.setColor(getBackground());
		}
		// filloval方法画一个矩形的内切椭圆,并且填充这个椭圆
		// 当矩形为正方形时,画出的椭圆便是圆
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		// 调用父类的paintcomponent画按钮的标签和焦点所在的小矩形
		super.paintComponents(g);
	}
	// 用简单的弧充当按钮的边界
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		// drawoval方法画矩形的内切椭圆,但不填充,只画出一个边界
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}
	// 判断鼠标是否点在按钮上
	public boolean contains(int x, int y) {
		// 如果按钮边框,位置发生改变,则产生一个新的形状对象
		if ((shape == null) || (!shape.getBounds().equals(getBounds()))) {
			// 构造椭圆型对象
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		// 判断鼠标的x,y坐标是否落在按钮形状内
		return shape.contains(x, y);
	}
	public static void main(String[] args) {
		JButton button = new Matter("click me");// 产生一个圆形按钮
		//button.setbackground(color.green);// 设置背景色为绿色
		// 产生一个框架显示这个按钮
		JFrame frame = new JFrame("图形按钮");
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(button);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}}
