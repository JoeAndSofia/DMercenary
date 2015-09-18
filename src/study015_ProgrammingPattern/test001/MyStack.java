package study015_ProgrammingPattern.test001;

import java.util.Vector;

public class MyStack{
	private Vector _vector = new Vector();
	
	public void push (Object element){
		_vector.insertElementAt(element,0);
	}
	
	public Object pop(){
		Object result = _vector.firstElement();
		_vector.removeElementAt(0);
		return result;
	}
}
