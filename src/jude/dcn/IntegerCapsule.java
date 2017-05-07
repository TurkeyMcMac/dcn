package jude.dcn;

final class IntegerCapsule extends Capsule {

	protected IntegerCapsule() {
		super('(', ')');
	}
	
	public Integer detect(String capsule) {
		return Integer.parseInt(findContents(capsule));
	}
	
}
