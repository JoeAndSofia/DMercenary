package study_Class;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import basic.Basic;

public class TestInstanceof extends Basic{
	public static void main(String[] args){
		Exception e = new Exception("");
		IOException ioe = new IOException("");
		
		
		Vector v = new Vector();
		
		pl(e instanceof Object);
		pl(ioe instanceof Exception);
		
		pl(new HashMap() instanceof Map);
		pl(v instanceof List);
		pl(v instanceof Collection);
	}
}
