package jude.dcn;

final class StringCapsule extends PrimitiveCapsule {

	public StringCapsule(char start, char finish) {
		super('"', '"');
	}

	@Override
	protected Object parseContents(String contents) {
		return contents;
	}

}
