package jwmh.dcn;

final class BooleanCapsule extends PrimitiveCapsule<Boolean> {

	protected BooleanCapsule() {
		super(';', ';', null);
	}

	@Override
	protected Boolean parseContents(String contents) {
		return Boolean.valueOf(contents);
	}

}
