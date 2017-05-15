package jwmh.dcn;

final class CommentCapsule extends EmptyCapsule {

	public CommentCapsule() {
		super('`', '`', null);
	}
	
	//instantiate capsule
	static {
		new CommentCapsule();
	}
	
}
