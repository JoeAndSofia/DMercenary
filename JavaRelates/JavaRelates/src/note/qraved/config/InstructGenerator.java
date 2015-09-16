package note.qraved.config;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InstructGenerator {
	private String user = "";
	private String ip = "";
	private String filename = "";
	private String[] sourceAndTarget = null;
	private String target = "";
	
	private static final long MILLISECONDS_PER_DAY = 86_400_000;
	
	private static final String[] CACHE01 = {"/disk3/logs/cache01/","/home/imaginato/wyl/workspace_bugFix/cache01/"};
	private static final String[] S001 = {"/disk3/logs/s001/","/home/imaginato/wyl/workspace_bugFix/s001/"};
	private static final String[] S002 = {"/disk3/logs/s002/","/home/imaginato/wyl/workspace_bugFix/s002/"};
	private static final String[] DB01 = {"/disk3/logs/db01/","/home/imaginato/wyl/workspace_bugFix/db01/"};
	private static final String[] DEV = {"/mnt/tomcatdevservice/logs/","/home/imaginato/wyl/workspace_bugFix/dev/"};
	private static final String[] STAGING = {"/mnt/tomcatstagingservice/logs/","/home/imaginato/wyl/workspace_bugFix/staging/"};
	
	private static final String IP_STAGING_AND_LIVE = "54.251.100.162";
			
	
	public static void main(String[] args){
		try{
			InstructGenerator ig = new InstructGenerator();
			
			ig.User("joe");
			ig.Ip(IP_STAGING_AND_LIVE);
//			ig.Filename("catalina.out.2015-08-13.tgz");
//			ig.Filename("localhost_access_log.2015-08-13.txt");

//			ig.Filename("stacktrace.log");
			ig.Filename("catalina.out");
			ig.SourceAndTarget(InstructGenerator.DEV);

			String cmd = ig.logScp(ig.SourceAndTarget()[0], ig.SourceAndTarget()[1], ig.Filename());
			if(cmd!=null || cmd!=""){
				executeCmd(cmd);
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static String yyyyMMdd(long dayOffset){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date(new Date().getTime() + MILLISECONDS_PER_DAY*dayOffset);
		return sdf.format(d);
	}
	
	public String logScp(String sourceLocation, String targetLocation, String filename){
		File folder = new File(targetLocation);
		if(!folder.exists()){
			folder.mkdirs();
			System.out.println("Folder \"" + targetLocation + "\" has been made.");
		}
		File file = new File(targetLocation+filename);
		String order = "";
		if(file.exists()){
			System.out.println("File \""+filename +"\" is already existed in target location \"" + targetLocation + "\"");
		}else{
			if(Filename()==null || Filename()==""){
				System.out.println("file name hasn't been assigned, the following scp order may not work.");
			}
		}
		order = "scp -r " + this.user + "@" + this.ip + ":" + sourceLocation + Filename() + " " + targetLocation + filename;
		System.out.println(order);
		return order;
	}
	
	public static void executeCmd(String order) throws IOException{
		Process p = Runtime.getRuntime().exec(order);
		
//		Socket s = new Socket();
		System.out.println("************************************************************");
	}
	
	public String User(){
		return this.user;
	}
	public void User(String user){
		this.user = user;
	}
	public String Ip(){
		return this.ip;
	}
	public void Ip(String ip){
		this.ip = ip;
	}
	public String Filename(){
		return this.filename;
	}
	public void Filename(String filename){
		this.filename = filename;
	}
	public String[] SourceAndTarget(){
		return this.sourceAndTarget;
	}
	public void SourceAndTarget(String[] sourceAndTarget){
		this.sourceAndTarget = sourceAndTarget;
	}
	
}
