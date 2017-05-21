package jwmh.dcn;

import java.util.List;

final class DivideCapsule extends MathCapsule {

	public DivideCapsule() {
		super('/', null);
	}

	@Override
	protected Integer doIntMath(List<Number> numList) {
		Integer total = (Integer)numList.get(0);
		for (int i = 1; i < numList.size(); i++) {
			total /= (Integer)numList.get(i);
		}
		return total;
	}
	
	@Override
	protected Float doFloatMath(List<Number> numList) {
		Float total = (float)numList.get(0);
		for (int i = 1; i < numList.size(); i++) {
			total /= (Float)numList.get(i);
		}
		return total;
	}

}
