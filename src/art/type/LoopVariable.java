package art.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class for storing the loopVariables for the time of processing
 */
public class LoopVariable extends ProcessVariable {

	private boolean hasVarSection = false;

	public LoopVariable(String scope) {
		super(false);
		super.setScope(scope);
	}

	// TODO if we want to add this feature
	public void insertVariable(MultiValVariable multiVar) {
		if (!(null == vars) && !(vars.size() == 0)) {
			MultiValVariable firstVar = vars.get(0);
			multiVar.setInIteration(firstVar.isInIteration());
			multiVar.setActualIter(firstVar.getActualIter());
		}

		// adding iteration

		// adding var
		vars.add(multiVar);
	}

	private List<MultiValVariable> vars;

	public List<MultiValVariable> getVars() {
		if (null == vars) {
			vars = new ArrayList<MultiValVariable>();
		}
		return vars;
	}

	public void setVars(List<MultiValVariable> vars) {
		this.vars = vars;
	}

	@Override
	public String getValue() {
		StringBuilder sb = new StringBuilder();

		for (Iterator<MultiValVariable> iterator = vars.iterator() ; iterator.hasNext() ;) {
			MultiValVariable var = iterator.next();
			if (iterator.hasNext()) {
				sb.append(var.getValue() + "|");
			} else {
				sb.append(var.getValue());
			}
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		return "LoopVariable [vars=" + vars + "]";
	}

	public boolean hasVarSection() {
		return hasVarSection;
	}

	public void setVarSection(boolean varSection) {
		hasVarSection = varSection;
	}
}
