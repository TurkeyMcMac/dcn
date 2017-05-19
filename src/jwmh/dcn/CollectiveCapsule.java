package jwmh.dcn;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class CollectiveCapsule<T> extends Capsule<T> {
	
	protected CollectiveCapsule(Character start, Character finish, String selector) {
		super(start, finish, selector);
	}
	
	@SuppressWarnings("unchecked")
	protected final ValueEnd evaluate(String capsule) {
		//storage for variables within this scope
		Map<Object, Object> vars = new HashMap<>();
		//list of processed values, to be filled
	    List<Object> valueList = new ArrayList<>();
	    //the position of the end of the capsule, to be determined
	    int terminator = 0;
	    //iterate through capsule string
	    for (int i = 0; i < capsule.length(); i++) {
	        char currentChar = capsule.charAt(i);
	        //check if currentChar is the beginning of a sub-capsule
	        Capsule<?> subCapsule = capsuleStarts.get(currentChar);
	        if (subCapsule != null) {
	            //pass sub-capsule string to sub-capsule
	            ValueEnd subValue = (Capsule<T>.ValueEnd) subCapsule.evaluate(capsule.substring(i + 1));
	            if (!(subCapsule instanceof Ignored)) {
	            	if (subCapsule instanceof GetterCapsule) {
	            		valueList.add(vars.get(subValue.value));
	            	} else {
	            		valueList.add(subValue.value);
	            	}
	            } else if (subCapsule instanceof SetterCapsule) {
	            	AbstractMap.SimpleEntry<Object, Object> var = (SimpleEntry<Object, Object>)subValue.value;
	            	vars.put(var.getKey(), var.getValue());
	            }
	            i += subValue.terminator;
	        } else if (currentChar == capsuleBorders.get(START)) {
	        	terminator = i;
	        	break;
	        }
	    }
	    return new ValueEnd(processList((List<Object>)valueList), terminator);
	}
	
	protected abstract T processList(List<Object> valueList);
	
}
