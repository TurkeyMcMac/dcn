package jude.dcn;

final class CharacterCapsule extends PrimitiveCapsule {

	protected CharacterCapsule() {
		super('\'', '\'', null);
	}

	@Override
	protected Object parseContents(String contents) {
		return contents.charAt(0);
	}

}
