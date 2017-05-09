package jude.dcn;

final class StringCapsule extends PrimitiveCapsule {

	public StringCapsule() {
		super('"', '"');
	}

	@Override
	protected Object parseContents(String contents) {
		return contents;
	}

}
