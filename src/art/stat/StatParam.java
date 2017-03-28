package art.stat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StatParam {
	private static final StatParam INSTANCE = new StatParam();
	private Stack<Long> fileIdStack;
	private Boolean statEnabled;
	private List<Long> usedSetIdList;
	private Map<Long, Stack<Boolean>> whileStackMap;
	private Map<Long, Stack<Integer>> baseLineNoStackMap;
	private Boolean processingInsert = false;
	private int breakLineNo;
	
	private StatParam() {
		fileIdStack = new Stack<>();
		whileStackMap = new HashMap<>();
		baseLineNoStackMap = new HashMap<>();
	}
	
	public Boolean isStatEnabled() {
		if (null == statEnabled){
			return false;
		}
		return statEnabled;
	}

	public void setStatEnabled(Boolean statEnabled) {
		this.statEnabled = statEnabled;
	}

	public static StatParam getInstance() {
		return INSTANCE;
	}
	
	public void pushFileId(Long id) {
		fileIdStack.push(id);
	}
	
	public Long popFileId() {
		return fileIdStack.pop();
	}
	
	public Long getCurrentFileId() {
		return fileIdStack.peek();
	}

	public List<Long> getUsedSetIdList() {
		return usedSetIdList;
	}

	public void setUsedSetIdList(List<Long> usedSetIdList) {
		this.usedSetIdList = usedSetIdList;
	}

	public Boolean isProcessingWhile() {
		Long fileId =  getCurrentFileId();
		//If whileStackMap contains a stack for fileId and the stack is not empty
		//then we can conclude that it's processing while
		if(whileStackMap.containsKey(fileId)) {
			if(!whileStackMap.get(fileId).isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public void addProcessingWhile(int baseLine) {
		Long fileId =  getCurrentFileId();
		Stack<Boolean> whileStack = whileStackMap.get(fileId);

		if(whileStack == null) {
			whileStack = new Stack<>();
			whileStackMap.put(fileId, whileStack);
		}
		whileStack.push(true);
		
		Stack<Integer> baseLineStack = baseLineNoStackMap.get(fileId);
		if(baseLineStack == null) {
			baseLineStack = new Stack<>();
			baseLineNoStackMap.put(fileId, baseLineStack);
		} else {
			baseLine += baseLineStack.peek();
		}
		baseLineStack.push(baseLine);
	}
	
	public void removeProcessingWhile() {
		Long fileId =  getCurrentFileId();
		Stack<Boolean> whileStack = whileStackMap.get(fileId);
		if(whileStack != null) {
			whileStack.pop();
		}
		
		Stack<Integer> baseLineStack = baseLineNoStackMap.get(fileId);
		if(baseLineStack != null) {
			baseLineStack.pop();
		}
	}
	
	public int getBaseLineNo() {
		Long fileId =  getCurrentFileId();
		Stack<Integer> baseLineStack = baseLineNoStackMap.get(fileId);
		if(baseLineStack == null) {
			return 0;
		}
		return baseLineStack.peek();
	}

	public Boolean istProcessingInsert() {
		return processingInsert;
	}

	public void setProcessingInsert(Boolean processingInsert) {
		this.processingInsert = processingInsert;
	}

	public int getBreakLineNo() {
		return breakLineNo;
	}

	public void setBreakLineNo(int insertLineNo) {
		this.breakLineNo = insertLineNo;
	}

}
