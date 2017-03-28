package art.utils;

import java.util.Stack;

/**
 * Helper class for processint select comands.
 */
public class SelectInfo {

	private static Stack<Boolean> selectSkipOptionStack = new Stack<Boolean>();
	private static Stack<String> selectKeyStack= new Stack<String>();
	private static Stack<String> selectValueStack= new Stack<String>();
	
	public static Stack<String> getSelectValueStack() {
		return selectValueStack;
	}
	
	public static Stack<Boolean> getSelectSkipOptionStack() {
		return selectSkipOptionStack;
	}
	
	public static void addSelect(String key, String val){
		selectKeyStack.add(key);
		selectValueStack.add(val);
		selectSkipOptionStack.add(false);
	}
	
	public static void popSelect(){
		if (selectValueStack.size() > 1 && selectSkipOptionStack.size() > 1 && selectKeyStack.size() > 1){
			selectValueStack.pop();
			selectSkipOptionStack.pop();
			selectKeyStack.pop();
		}
	}
	
	public static boolean isSkipOtherwise() {
		if (selectSkipOptionStack.size() > 1){
			return selectSkipOptionStack.lastElement();
		} else {
			return false;
		}
	}

	public static void setSkipOtherwise(boolean skipOtherwise) {
		if (selectSkipOptionStack.size() > 1){			
			selectSkipOptionStack.pop(); 
		}
		selectSkipOptionStack.add(skipOtherwise);
	}

	public static Stack<String> getSelectKeyStack() {
		return selectKeyStack;
	}
	
	
	
	public static boolean undefined(){
		if (SelectInfo.getSelectKeyStack().isEmpty()){
			return true;
		}
		return !(Utils.getVariables().containsKey(SelectInfo.getSelectKeyStack().lastElement()));	
	}
}
