package jude.dcn;

final class BooleanCapsule extends Capsule {

	protected BooleanCapsule() {
		super('<', '>');
	}

	@Override
	public Boolean detect(String capsule) {
		return Boolean.parseBoolean(findContents(capsule));
	}

}
