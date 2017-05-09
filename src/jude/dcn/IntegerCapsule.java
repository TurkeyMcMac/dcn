package jude.dcn;

final class IntegerCapsule extends PrimitiveCapsule {

	protected IntegerCapsule() {
		super('#', '#');
	}

	@Override
	protected Object parseContents(String contents) {
		return Integer.parseInt(contents);
	}

}
