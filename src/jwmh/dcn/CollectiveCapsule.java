package jwmh.dcn;

import java.util.ArrayList;
import java.util.List;

abstract class CollectiveCapsule<T> extends Capsule<T> {
	
	protected CollectiveCapsule(char start, char finish, String selector) {
		super(start, finish, selector);
	}
	
	protected final ValueEnd evaluate(String capsule) {
		//list of processed values, to be filled
	    List<T> valueList = new ArrayList<>();
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
	            if (!(subCapsule instanceof CommentCapsule)) {
	            	valueList.add(subValue.value);
	            }
	            i += subValue.terminator;
	        } else if (currentChar == capsuleBorders.get(START)) {
	        	terminator = i;
	        	break;
	        }
	    }
	    return processList((List<Object>)valueList, terminator);
	}
	
	protected abstract ValueEnd processList(List<Object> valueList, int terminator);
	
}
