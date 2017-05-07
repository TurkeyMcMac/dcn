package jude.dcn;

final class NullCapsule extends Capsule {

	public NullCapsule() {
		super('^', '%');
	}
	
	private static String innerPattern = "";
	
	protected String getInner() {
		return innerPattern;
	}
	
	@Override
	public Object detect(String capsule) {
		return null;
	}

}
