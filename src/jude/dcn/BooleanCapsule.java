package jude.dcn;

final class BooleanCapsule extends PrimitiveCapsule {

	protected BooleanCapsule() {
		super(';', ';', null);
	}

	@Override
	protected Object parseContents(String contents) {
		return Boolean.valueOf(contents);
	}

}
