package jude.dcn;

final class BooleanCapsule extends PrimitiveCapsule {

	protected BooleanCapsule() {
		super(';', ';');
	}

	@Override
	protected Object parseContents(String contents) {
		return Boolean.valueOf(contents);
	}

}
