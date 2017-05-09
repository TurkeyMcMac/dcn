package jude.dcn;

final class IntegerCapsule extends PrimitiveCapsule {

	protected IntegerCapsule() {
		super('#', '#', null);
	}

	@Override
	protected Object parseContents(String contents) {
		return Integer.parseInt(contents);
	}

}
