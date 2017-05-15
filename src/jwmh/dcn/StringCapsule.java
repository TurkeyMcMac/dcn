package jwmh.dcn;

final class StringCapsule extends PrimitiveCapsule<String> {

	public StringCapsule() {
		super('"', '"', null);
	}
	
	//instantiate capsule
	static {
		new StringCapsule();
	}
	
	@Override
	protected String parseContents(String contents) {
		return contents;
	}

}
