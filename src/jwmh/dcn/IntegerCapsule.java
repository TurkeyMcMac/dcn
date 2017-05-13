package jwmh.dcn;

final class IntegerCapsule extends PrimitiveCapsule<Integer> {

	protected IntegerCapsule() {
		super('#', '#', null);
	}

	@Override
	protected Integer parseContents(String contents) {
		return Integer.parseInt(contents);
	}

}
