package jude.dcn;

final class CharacterCapsule extends Capsule {

	protected CharacterCapsule() {
		super('\'', '\'');
	}

	@Override
	public Character detect(String capsule) {
		return findContents(capsule).charAt(0);
	}

}
