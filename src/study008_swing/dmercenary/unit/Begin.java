package study008_swing.dmercenary.unit;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import study008_swing.dmercenary.db.dao.UserDao;
import study008_swing.dmercenary.db.entity.User;
import study008_swing.dmercenary.utils.MD5Util;
import study008_swing.dmercenary.utils.UIUtil;

public class Begin extends JFrame{
	private static final Font FONT_FOR_ALL = new Font("Times Roma New",Font.PLAIN,11);
	private static final Font FONT_FOR_BEGIN = new Font("Dialog",Font.BOLD,11);
	private static final Insets INSETS_FOR_ALL = new Insets(0, 0, 0, 0);
	
	private static final int SHOW_X = 0;
	private static final int SHOW_Y = 0;
	
	private static final int STANDARD_INTERVAL = 15;
	

	private static final int FRAME_INNER_W = 207;
	private static final int FRAME_INNER_H = 170;
	private static final int USER_BLOCK_W = 175;
	private static final int USER_BLOCK_H = 55;
	private static final int USER_LIST_W = USER_BLOCK_W*3+STANDARD_INTERVAL*4;
	private static final int USER_LIST_H = 570;
	private static final int FRAME_MAIN_W = FRAME_INNER_W+USER_LIST_W+STANDARD_INTERVAL*2;
	private static final int FRAME_MAIN_H = USER_LIST_W+STANDARD_INTERVAL*2;

	
	private static final Point HIDE_POINT = new Point(-FRAME_INNER_W,-FRAME_INNER_H);
	private static final Point SHOW_POINT = new Point(STANDARD_INTERVAL+SHOW_X, STANDARD_INTERVAL+SHOW_Y);
//	private static final Dimension FRAME_MAIN_DIMENSION = new Dimension()
	private static final Dimension FRAME_INNER_DIMENSION = new Dimension(FRAME_INNER_W,FRAME_INNER_H);
	private static final Point USER_LIST_POINT = new Point(FRAME_INNER_W+STANDARD_INTERVAL,SHOW_Y+STANDARD_INTERVAL);
	private static final Dimension USER_LIST_DIMENSION = new Dimension(USER_LIST_W,USER_LIST_H);
	private static final Dimension USER_BLOCK_DIMENSION = new Dimension(USER_BLOCK_W, USER_BLOCK_H);
	private static final Dimension FRAME_MAIN_DIMENSION = new Dimension(FRAME_MAIN_W,FRAME_MAIN_H+6);
	
	
	private JPanel choose = new Choose();
	private JPanel login = new Login();
	private JPanel create = new Create();
	private JPanel userList = new UserList(); 

//	private JButton 
	
	public static void main(String[] args){
		try{
			Begin b = new Begin();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public Begin(){
		init();
		this.setVisible(true);
	}
	
	private void init(){		
		this.setLayout(null);
		this.add(choose);
		this.add(login);
		this.add(create);
		this.add(userList);
		
//		this.setBounds(new Rectangle(FRAME_INNER_W+userList.getWidth()+STANDARD_INTERVAL*2, FRAME_MAIN_H));
		this.setSize(FRAME_MAIN_DIMENSION);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class Choose extends JPanel implements ActionListener{
		private JButton jb_login = new JButton("Log In");
		private JButton jb_create = new JButton("Create New Role");
		
		public Choose(){
			initBegin();
		}
		
		private void initBegin(){
			jb_login.setBounds(40, 25, 127, 25);
			jb_login.setBorder(UIUtil.getRoundBorder());
			jb_login.setContentAreaFilled(false);
			jb_login.addActionListener(this);
			jb_login.setFont(FONT_FOR_BEGIN);

			jb_create.setBounds(40, 75, 127, 25);
			jb_create.setBorder(UIUtil.getRoundBorder());
			jb_create.setContentAreaFilled(false);
			jb_create.addActionListener(this);
			jb_create.setFont(FONT_FOR_BEGIN);
			
			this.setLayout(null);
			this.setLocation(SHOW_POINT);
			this.setSize(FRAME_INNER_DIMENSION);
			this.add(jb_login);
			this.add(jb_create);
		}
		
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton)e.getSource();
			if(jb==jb_login){
				JFrame b = (Begin)choose.getParent().getParent().getParent().getParent();
				choose.setLocation(HIDE_POINT);
				choose.setEnabled(false);
				login.setLocation(SHOW_POINT);
				login.setEnabled(true);
//				userList.setLocation(FRAME_INNER_W,0);
				userList.setVisible(true);
				System.out.println("choose_login");
			}else if(jb==jb_create){
				choose.setLocation(HIDE_POINT);
				choose.setEnabled(false);
				create.setLocation(SHOW_POINT);
				create.setEnabled(true);
				System.out.println("choose_create");
			}
		}
	}
	
	class Login extends JPanel implements ActionListener{
		private JLabel jl_username = new JLabel("User Name:");
		private JLabel jl_password = new JLabel("Password :");
		private JTextField jt_username = new JTextField();
		private JTextField jt_password = new JTextField();
		private JButton jb_back = new JButton("<-Back");
		private JButton jb_login = new JButton("Login->");
		
		public Login(){
			initLogin();
		}
		
		private void initLogin(){
			jl_username.setBounds(10, 10, 80, 20);
			jl_username.setFont(FONT_FOR_ALL);
			
			jl_password.setBounds(10, 50, 80, 20);
			jl_password.setFont(FONT_FOR_ALL);
			
			jt_username.setBounds(110, 10, 80, 20);
			jt_username.setFont(FONT_FOR_ALL);
			
			jt_password.setBounds(110, 50, 80, 20);
			jt_password.setFont(FONT_FOR_ALL);
			
			jb_back.setBounds(5, 90, 90, 20);
			jb_back.setFont(FONT_FOR_ALL);
			jb_back.setMargin(INSETS_FOR_ALL);
			jb_back.addActionListener(this);
			
			jb_login.setBounds(105, 90, 90, 20);
			jb_login.setFont(FONT_FOR_ALL);
			jb_login.setMargin(INSETS_FOR_ALL);
			jb_login.addActionListener(this);
			
			this.setLayout(null);
			this.setBounds(-FRAME_INNER_W, -FRAME_INNER_H, FRAME_INNER_W, FRAME_INNER_H);
			this.add(jl_username);
			this.add(jl_password);
			this.add(jt_username);
			this.add(jt_password);
			this.add(jb_back);
			this.add(jb_login);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton)e.getSource();
			if(jb==jb_back){
				login.setLocation(HIDE_POINT);
				userList.setVisible(false);
				choose.setLocation(SHOW_POINT);
				System.out.println("login_back");
			}else if(jb==jb_login){
				
				userList.setVisible(false);
				System.out.println("login_login");
			}
		}
		
		public void setUserName(String username){
			this.jt_username.setText(username);
			this.jt_password.setText("");
		}
	}
	
	class Create extends JPanel implements ActionListener{
		private JLabel jl_username = new JLabel("User Name:");
		private JLabel jl_password = new JLabel("Password :");
		private JLabel jl_confirm = new JLabel("Confirm  :");
		private JLabel jl_hint = new JLabel("Hint     :");
		private JTextField jt_username = new JTextField();
		private JTextField jt_password = new JTextField();
		private JTextField jt_confirm = new JTextField();
		private JTextField jt_hint = new JTextField();
		private JButton jb_back = new JButton("<- Back");
		private JButton jb_create = new JButton("Create->");
		
		public Create(){
			initCreate();
		}
		
		private void initCreate(){
			jl_username.setBounds(10, 5, 80, 20);
			jl_username.setFont(FONT_FOR_ALL);
			
			jl_password.setBounds(10, 32, 80, 20);
			jl_password.setFont(FONT_FOR_ALL);
			
			jl_confirm.setBounds(10, 59, 80, 20);
			jl_confirm.setFont(FONT_FOR_ALL);
			
			jl_hint.setBounds(10, 86, 80, 20);
			jl_hint.setFont(FONT_FOR_ALL);
			
			jt_username.setBounds(110, 5, 80, 20);
			jt_username.setFont(FONT_FOR_ALL);
			
			jt_password.setBounds(110, 32, 80, 20);
			jt_password.setFont(FONT_FOR_ALL);
			
			jt_confirm.setBounds(110, 59, 80, 20);
			jt_confirm.setFont(FONT_FOR_ALL);
			
			jt_hint.setBounds(110, 86, 80, 20);
			jt_hint.setFont(FONT_FOR_ALL);
			
			jb_back.setBounds(5, 113, 90, 20);
			jb_back.setFont(FONT_FOR_ALL);
			jb_back.setMargin(INSETS_FOR_ALL);
			jb_back.addActionListener(this);
			
			jb_create.setBounds(105, 113, 90, 20);
			jb_create.setFont(FONT_FOR_ALL);
			jb_create.setMargin(INSETS_FOR_ALL);
			jb_create.addActionListener(this);
			
			this.setLayout(null);
			this.setLocation(HIDE_POINT);
			this.setSize(FRAME_INNER_DIMENSION);
			this.add(jl_username);
			this.add(jl_password);
			this.add(jl_confirm);
			this.add(jl_hint);
			this.add(jt_username);
			this.add(jt_password);
			this.add(jt_confirm);
			this.add(jt_hint);
			this.add(jb_back);
			this.add(jb_create);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton)e.getSource();
			if(jb==jb_back){
				choose.setLocation(SHOW_POINT);
				create.setLocation(HIDE_POINT);
				System.out.println("create_back");
			}else if(jb==jb_create){
				String name = jl_username.getText();
				if(name!=null){
					name = name.trim();
				}
				String password = jl_password.getText();
				if(password!=null){
					password = password.trim();
				}
				String confirm = jl_confirm.getText();
				if(confirm!=null){
					confirm = confirm.trim();
				}
				String hint = jl_hint.getText();
				if(hint!=null){
					hint = hint.trim();
				}
				if(name!=null && name.length()>0 && password!=null && confirm!=null && password.length()>8 && password.equals(confirm)){
					User user = new User();
					user.Name(name);
					user.Password(MD5Util.MD5(password));
					user.Hint(hint);
					try{
						user.save(true);	
					}catch(Exception ex){
						throw new RuntimeException("Save user error.");
					}
				}else{
					throw new RuntimeException("Name and password cannot be null, name cannot be empty, password cannot be less than 8 character and password should be the same as confirmed password.");
				}
				
				System.out.println("create_create");
			}
		}
	}
	
//	class UserList extends JDialog{
//		
//		public UserList(JFrame owner){
//			super(owner);
//			initUserList(owner);
//		}
//		
//		private void initUserList(JFrame owner){
//			this.setTitle("User List");
//			this.setLayout(null);
//			this.setResizable(false);
//			this.setAutoRequestFocus(true);
////			this.setUndecorated(true);
//			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
//			
//			UserDao dao = new UserDao();
//			Map<Integer, User> usersMap = dao.getAll();
//			if(usersMap!=null&&usersMap.size()>0){
//				Set<Integer> ids = usersMap.keySet();
//				int i=0;
//				for(Integer id:ids){
//					UserBlock userBlock = new UserBlock(usersMap.get(id));
//					userBlock.setLocation(0, i*60);
//					this.add(userBlock);
//				}
//				this.setBounds(new Rectangle(180, i+2*60));
//			}
//			dao.dis();
//		}
//	}
	
	class UserList extends JPanel{
		
		public UserList(){
			initUserList();
		}
		
		private void initUserList(){
			this.setLocation(USER_LIST_POINT);
			this.setSize(USER_LIST_DIMENSION);
//			this.setBounds(FRAME_INNER_W, STANDARD_INTERVAL, STANDARD_INTERVAL*4 + USER_BLOCK_W*3, FRAME_MAIN_H-2*STANDARD_INTERVAL);
			FlowLayout fl = new FlowLayout(FlowLayout.LEFT,STANDARD_INTERVAL,STANDARD_INTERVAL);
			this.setLayout(fl);
			this.setBorder(UIUtil.getRoundBorder());
			this.setVisible(false);
			
			System.out.println(this.getLayout().toString());
			
			UserDao dao = new UserDao();
			Map<Integer, User> usersMap = dao.getAll();
			if(usersMap!=null&&usersMap.size()>0){
				Set<Integer> ids = usersMap.keySet();
				int i=0;
				for(Integer id:ids){
					UserBlock userBlock = new UserBlock(usersMap.get(id));
					this.add(userBlock);
//					JButton jb = new JButton("Test");
//					String x = "";
//					this.add(jb);
				}
			}
			dao.dis();
		}
	}
	
	class UserBlock extends JPanel implements MouseListener{
		private int id = 0;
		private String username = "";
		private String password = "";
		private String hint = "";
		private int playduration = 0;
		private JLabel jl_username = null;
		private JLabel jl_playduration = null;
		
		public UserBlock(User user){
			this.id = user.Id();
			this.username = user.Name();
			this.password = user.Password();
			this.hint = user.Hint();
			this.playduration = user.PlayDuration();
			
			
			this.jl_username = new JLabel(this.username);
			this.jl_username.setFont(FONT_FOR_ALL);
			this.jl_username.setBounds(10, 5, USER_BLOCK_W, 20);
			
			this.jl_playduration = new JLabel(duration(playduration));
			this.jl_playduration.setFont(FONT_FOR_ALL);
			this.jl_playduration.setBounds(10, 25, USER_BLOCK_W, 20);
			
			this.setLayout(null);
//			this.setSize(new Dimension(174,55));
			this.setPreferredSize(USER_BLOCK_DIMENSION);
			this.setBorder(UIUtil.getRoundBorder());
			this.addMouseListener(this);
			this.add(jl_username);
			this.add(jl_playduration);
			System.out.println(this.getBounds().toString());
		}
		
		public String duration(int duration){
			int day = duration/86400;
			int hour = (duration - day*86400)/3600;
			int minute = (duration - day*86400 - hour*3600)/60;
			return day+(day>1?" Days ":" Day ")+hour+(hour>1?" Hours ":" Hour ")+minute+(minute>1?" Minutes ":" Minute ");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("UserBlock: user clicked.");
//			System.out.println()
			((Login) login).setUserName(this.username);
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}
}
