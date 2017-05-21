package jwmh.dcn;

import java.util.List;

final class TimesCapsule extends MathCapsule {

	public TimesCapsule() {
		super('*', null);
	}

	@Override
	protected Integer doIntMath(List<Number> numList) {
		Integer total = 1;
		for (Number i : numList) {
			total *= (Integer)i;
		}
		return total;
	}
	
	@Override
	protected Float doFloatMath(List<Number> numList) {
		Float total = (float) 1.0;
		for (Number i : numList) {
			total *= (Float)i;
		}
		return total;
	}

}
