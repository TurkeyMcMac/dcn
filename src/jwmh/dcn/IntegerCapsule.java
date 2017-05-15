package jwmh.dcn;

final class IntegerCapsule extends PrimitiveCapsule<Integer> {

	protected IntegerCapsule() {
		super('#', null, null);
	}
	
	//instantiate capsule
	static {
		new IntegerCapsule();
	}
	
	@Override
	protected Integer parseContents(String contents) {
		return Integer.parseInt(contents);
	}

}
