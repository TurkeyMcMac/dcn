package jwmh.dcn;

final class BooleanCapsule extends PrimitiveCapsule<Boolean> {

	protected BooleanCapsule() {
		super('~', null, null);
	}
	
	
	//instantiate capsule
	static {
		new BooleanCapsule();
	}
	
	@Override
	protected Boolean parseContents(String contents) {
		return Boolean.valueOf(contents);
	}

}
