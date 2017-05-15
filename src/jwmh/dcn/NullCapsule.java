package jwmh.dcn;

final class NullCapsule extends EmptyCapsule {

	public NullCapsule() {
		super('_', '_', null);
	}
	
	//instantiate capsule
	static {
		new NullCapsule();
	}
	
}
