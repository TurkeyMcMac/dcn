package jude.dcn;

final class StringCapsule extends Capsule {

	protected StringCapsule() {
		super('"', '"');
	}

	@Override
	public String detect(String capsule) {
		return findContents(capsule);
	}

}
