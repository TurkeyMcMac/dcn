package jude.dcn;

final class StringCapsule extends PrimitiveCapsule {

	public StringCapsule() {
		super('"', '"', null);
	}

	@Override
	protected Object parseContents(String contents) {
		return contents;
	}

}
