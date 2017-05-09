package jude.dcn;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

abstract class Capsule {

	public final char START;
	public final char FINISH;
	
	protected Capsule(char start, char finish) {
		START = start;
		FINISH = finish;
		capsuleBorders.put(start, finish);
		capsules.put(start, this);
	}
	
	protected static Map<Character, Character> capsuleBorders = new HashMap<>();
	protected static Map<Character, Capsule> capsules = new HashMap<>();
	
	static {
		new ListCapsule();
		new HashCapsule();
		new CharacterCapsule();
		new BooleanCapsule();
		new IntegerCapsule();
	}
	
	protected abstract ValueEnd evaluate(String capsule);
	
	private static Object read(String capsule) {
		Character firstChar = null;
		int firstCharPosition = 0;
		for (int i = 0; i < capsule.length(); i++) {
			char currentChar = capsule.charAt(i);
			if (!Character.toString(currentChar).matches("\\s")) {
				firstChar = currentChar;
				firstCharPosition = i;
				break;
			}
		}
		return capsules.get(firstChar).evaluate(capsule.substring(firstCharPosition + 1, capsule.length())).value;
	}
	
	//a data structure containing the evaluated contents of a capsule and where in a string it ends
	protected class ValueEnd {
	    
	    Object value;
	    int terminator;
	    
	    ValueEnd(Object value, int terminator) {
	        this.value = value;
	        this.terminator = terminator + 1;
	    }
	    
	}
	
	public static void main(String[] args) {
		System.out.println(read("{}"));
	}
	
}
