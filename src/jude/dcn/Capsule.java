package jude.dcn;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

abstract class Capsule {

	final char START;
	final char FINISH;
	final String SELECTOR;
	
	protected Capsule(char start, char finish, String selector) {
		START = start;
		FINISH = finish;
		if (selector == null) {
			String capsuleName = getClass().getSimpleName().toLowerCase();
			SELECTOR = capsuleName.substring(0, capsuleName.length() - 7);
		} else {
			SELECTOR = selector;
		}
		capsuleBorders.put(start, finish);
		capsuleStarts.put(start, this);
		capsules.add(this);
	}
	
	protected static Map<Character, Character> capsuleBorders = new HashMap<>();
	protected static Map<Character, Capsule> capsuleStarts = new HashMap<>();
	static List<Capsule>  capsules = new ArrayList<Capsule>();
	
	
	
	protected abstract ValueEnd evaluate(String capsule);
	
	//a data structure containing the evaluated contents of a capsule and where in the string it ends
	protected class ValueEnd {
	    
	    Object value;
	    int terminator;
	    
	    ValueEnd(Object value, int terminator) {
	        this.value = value;
	        this.terminator = terminator + 1;
	    }
	    
	}
	
}
