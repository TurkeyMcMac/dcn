package jwmh.dcn;

final class FloatCapsule extends PrimitiveCapsule<Float> {

	public FloatCapsule() {
		super('*', null, null);
	}
	
	//instantiate capsule
	static {
		new FloatCapsule();
	}
	
	@Override
	protected Float parseContents(String contents) {
		return Float.parseFloat(contents);
	}

}
