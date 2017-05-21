package jwmh.dcn;

import java.util.ArrayList;
import java.util.List;

abstract class MathCapsule extends CollectiveCapsule<Number> {

	public MathCapsule(Character start, String selector) {
		super(start, 'm', selector);
	}
	
	protected abstract Integer doIntMath(List<Number> numList);
	
	protected abstract Float doFloatMath(List<Number> numList);

	@Override
	protected Number processList(List<Object> valueList) {
		List<Number> numList = new ArrayList<>();
		Class<? extends Number> numType = (Class<? extends Number>)valueList.get(0).getClass();
		if (numType == Integer.class) {
			for (Object o : valueList) {
				numList.add((Integer)o);
			}
			return doIntMath(numList);
		} else if (numType == Float.class) {
			for (Object o : valueList) {
				numList.add((Float)o);
			}
			return doFloatMath(numList);
		} else {
			throw new IllegalContentsException("math only works on numbers");
		}
	}
	
}
