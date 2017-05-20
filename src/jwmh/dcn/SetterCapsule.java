package jwmh.dcn;

import java.util.AbstractMap;
import java.util.List;

final class SetterCapsule extends CollectiveCapsule<AbstractMap.SimpleEntry<?, ?>> implements Ignored {

	public SetterCapsule() {
		super('$', '!', null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AbstractMap.SimpleEntry<Object, Object> processList(List<Object> valueList) {
		if (valueList.size() != 2) {
			throw new IllegalContentsException("setters must contain a name and a value");
		}
		AbstractMap.SimpleEntry<Object, Object> var = new AbstractMap.SimpleEntry<>(valueList.get(0), valueList.get(1));
		return var;
	}

}
