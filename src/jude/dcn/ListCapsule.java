package jude.dcn;

import java.util.List;

final class ListCapsule extends CollectiveCapsule {

	protected ListCapsule() {
		super('[', ']', null);
	}
	
	protected ValueEnd processList(List<Object> valueList, int terminator) {
	    return new ValueEnd(valueList, terminator);
	}
	
}
