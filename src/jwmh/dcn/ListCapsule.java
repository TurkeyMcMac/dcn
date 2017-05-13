package jwmh.dcn;

import java.util.List;

final class ListCapsule extends CollectiveCapsule<List<?>> {

	protected ListCapsule() {
		super('[', ']', null);
	}
	
	@Override
	protected ValueEnd processList(List<Object> valueList, int terminator) {
	    return new ValueEnd(valueList, terminator);
	}
	
}