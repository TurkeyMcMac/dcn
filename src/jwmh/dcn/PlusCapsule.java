package jwmh.dcn;

import java.util.List;

final class PlusCapsule extends MathCapsule {

	public PlusCapsule() {
		super('+', null);
	}

	@Override
	protected Integer doIntMath(List<Number> numList) {
		Integer total = 0;
		for (Number i : numList) {
			total += (Integer)i;
		}
		return total;
	}
	
	@Override
	protected Float doFloatMath(List<Number> numList) {
		Float total = (float) 0.0;
		for (Number i : numList) {
			total += (Float)i;
		}
		return total;
	}
	
}
