package jwmh.dcn;

final class CharacterCapsule extends PrimitiveCapsule<Character> {

	protected CharacterCapsule() {
		super('\'', '\'', null);
	}

	@Override
	protected Character parseContents(String contents) {
		return contents.charAt(0);
	}

}