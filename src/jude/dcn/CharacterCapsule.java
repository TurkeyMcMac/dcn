package jude.dcn;

final class CharacterCapsule extends PrimitiveCapsule {

	protected CharacterCapsule() {
		super('\'', '\'');
	}

	@Override
	protected Object parseContents(String contents) {
		return contents.charAt(0);
	}

}
