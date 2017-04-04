package study016_Image;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import basic.Basic;

public class ImageDownloader extends Basic{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub  
		
//		download("http://ui.51bi.com/opt/siteimg/images/fanbei0923/Mid_07.jpg", "51bi.gif","c:\\image\\");
		try{
			
			String urlPrefix = "http://t1.zngirls.com/gallery/23391/20674/";
			DecimalFormat df = new DecimalFormat("000");
//			batchDownload(urlPrefix,1,49,".jpg","C:\\Users\\Administrator.phpDev-PC\\Desktop\\新建文件夹 (2)\\陈梓涵Sunny\\");
			
			download("http://t1.zngirls.com/gallery/23391/20674/001.jpg","001.jpg","C:\\Users\\Administrator.phpDev-PC\\Desktop\\新建文件夹 (2)\\陈梓涵Sunny\\");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void batchDownload(String urlPrefix, int start, int end, String urlSuffix, String location) throws Exception{
		DecimalFormat df = new DecimalFormat("000");
		for(int i=start; i<=end; i++){
			String imageFileName = df.format(i) + urlSuffix;
			String urlString = urlPrefix + imageFileName;
			download(urlString, imageFileName, location);
		}
	}
	
	public static void download(String urlString, String filename,String savePath) throws Exception {
		// 构造URL  
		pl(urlString);
		URL url = new URL(urlString);  
		// 打开连接  
		URLConnection con = url.openConnection();  
		//设置请求超时为5s  
		con.setConnectTimeout(100*1000);  
		// 输入流  
		InputStream is = con.getInputStream();  

//		GET /gallery/22459/20487/0.jpg HTTP/1.1
//		Host: t1.zngirls.com
//		Connection: keep-alive
//		Pragma: no-cache
//		Cache-Control: no-cache
//		Upgrade-Insecure-Requests: 1
//		User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36
//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//		Referer: http://www.zngirls.com/g/20487/
//		Accept-Encoding: gzip, deflate, sdch
//		Accept-Language: zh-CN,zh;q=0.8
//		Cookie: __cfduid=dbfab0dbadd1841c12a3c8a66861c4ccf1482411459; Hm_lvt_1bb490b9b92efa278bd96f00d3d8ebb4=1482504868,1482589684,1482589705,1482590167; Hm_lpvt_1bb490b9b92efa278bd96f00d3d8ebb4=1482592256
		
		
		
		// 1K的数据缓冲  
		byte[] bs = new byte[1024];  
		// 读取到的数据长度  
		int len;  
		// 输出的文件流  
		File sf=new File(savePath);  
		if(!sf.exists()){  
			sf.mkdirs();  
		}  
		OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);  
		// 开始读取  
		while ((len = is.read(bs)) != -1) {  
			os.write(bs, 0, len);  
		}  
		// 完毕，关闭所有链接  
		os.close();  
		is.close();  
	}
}
