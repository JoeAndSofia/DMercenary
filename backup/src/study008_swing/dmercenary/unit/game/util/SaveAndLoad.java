package study008_swing.dmercenary.unit.game.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import study008_swing.dmercenary.unit.game.interphase.SandBox;
import study008_swing.dmercenary.unit.game.data.SandBoxJson;

import com.google.gson.Gson;

public class SaveAndLoad {
	public SandBox loadSandBox(String name){
		try{
			String jsonStr = readSaveFile(name);
			Gson gson = new Gson();
			
			SandBoxJson sbj = gson.fromJson(jsonStr, SandBoxJson.class);
			SandBox sb = sbj.parseSandBox();
			return sb;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	private String readSaveFile(String fileName) throws IOException{
		File scene = new File("."+File.separator+"save"+File.separator+"scene"+File.separator+fileName+".json");
		InputStream is = new FileInputStream(scene);
		byte[] content = new byte[(int)scene.length()];
		is.read(content);
		is.close();
		String line = new String(content).trim();
		String modified = line.replaceAll("\r|\n|\t", "");
		return modified;
	}
}
