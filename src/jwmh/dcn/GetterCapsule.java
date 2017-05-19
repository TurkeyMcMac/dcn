package jwmh.dcn;

import java.util.List;

final class GetterCapsule extends CollectiveCapsule<Object> {

	public GetterCapsule() {
		super('^', '!', null);
	}
	
	@Override
	protected Object processList(List<Object> valueList) {
		if (valueList.size() != 1) {
			throw new IllegalArgumentException("getters must contain only a name");
		}
		return valueList.get(0);
	}
	
}
