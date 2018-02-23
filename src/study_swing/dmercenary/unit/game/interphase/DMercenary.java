package study_swing.dmercenary.unit.game.interphase;

import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DMercenary extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2515184870370871354L;

	static{
		try{
			Properties p = new Properties();
			FileInputStream in = new FileInputStream("config.properties");
			p.load(in);
			in.close();
			
			IC.CANZOOM = Boolean.parseBoolean(p.getProperty("canzoom"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

	
	private SandBox sandbox = new SandBox();
	private Control control = new Control(sandbox.getWidth(),0,IC.RG+IC.BT*2,sandbox.getHeight());
	private DataPrivy data_privy = new DataPrivy(0,sandbox.getHeight(),sandbox.getWidth(),IC.BG+IC.BT*2);
	private DataGroup data_group = new DataGroup(sandbox.getWidth(),sandbox.getHeight(),control.getWidth(),data_privy.getHeight());
	
	private String name;
	
	public DMercenary(){	
		this("DMercenary");
	}
	
	public DMercenary(String name){
		this.name = name;
		init();
//		System.out.println(this.getWidth()+","+this.getHeight());
//		System.out.println(sandbox.getWidth()+","+sandbox.getHeight());
//		System.out.println(control.getWidth()+","+control.getHeight());
//		System.out.println(data_group.getWidth()+","+data_group.getHeight());
//		System.out.println(data_privy.getWidth()+","+data_privy.getHeight());
		this.setVisible(true);
	}
	
	public JPanel getSandbox() {
		return sandbox;
	}

	public void setSandbox(SandBox sandbox) {
		if(sandbox instanceof SandBox){
			this.remove(this.sandbox);
			this.sandbox = sandbox;
			this.add(this.sandbox);
			this.sandbox.Battlefield().requestFocusInWindow();
		}else{
			throw new RuntimeException("sandbox is not an instance of SandBox.");
		}
	}

	public JPanel getControl() {
		return control;
	}

	public void setControl(Control control) {
		if(control instanceof Control){
			this.remove(this.control);
			this.control = control;
			this.add(this.control);
		}else{
			throw new RuntimeException("control is not an instance of Control.");
		}
	}

	public JPanel getDataPrivy() {
		return data_privy;
	}

	public void setDataPrivy(DataPrivy data_privy) {
		if(data_privy instanceof DataPrivy){
			this.remove(this.data_privy);
			this.data_privy = data_privy;
			this.add(this.data_privy);			
		}else{
			throw new RuntimeException("data_privy is not an instance of DataGroup.");
		}
	}

	public JPanel getDataGroup() {
		return data_group;
	}

	public void setDataGroup(DataGroup data_group) {
		if(data_group instanceof DataGroup){
			this.remove(this.data_group);
			this.data_group = data_group;
			this.add(this.data_group);	
		}else{
			throw new RuntimeException("data_group is not an instance of DataPrivy.");
		}
	}

	private void init(){
		this.setLayout(null);
		this.setBounds(20, 20, sandbox.getWidth()+control.getWidth()+6, sandbox.getHeight()+data_privy.getHeight()+28);
		this.setResizable(false);
		this.add(this.sandbox);
		this.add(this.control);
		this.add(this.data_privy);
		this.add(this.data_group);
		this.setTitle(this.name);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}		
}
