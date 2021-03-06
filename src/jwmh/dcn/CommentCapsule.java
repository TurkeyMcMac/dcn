package jwmh.dcn;

/**
 * This capsule type holds
 * comments which are
 * completely ignored.
 * 
 * @author jude
 *
 */
final class CommentCapsule extends EmptyCapsule implements Ignored {

	public CommentCapsule() {
		super('`', '`');
	}

	@Override
	protected String stringify(Object anObject) {
		return START + anObject.toString() + FINISH;
	}

	@Override
	protected boolean matches(Object anObject) {
		return anObject instanceof Comment;
	}
	
}
