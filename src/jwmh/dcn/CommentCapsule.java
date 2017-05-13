package jwmh.dcn;

final class CommentCapsule extends Capsule<Object> {

	public CommentCapsule() {
		super('`', '`', null);
	}

	@Override
	protected ValueEnd evaluate(String capsule) {
		int terminator = 0;
	    for (int i = 0; i < capsule.length(); i++) {
	    	char currentChar = capsule.charAt(i);
	        if (currentChar == FINISH) {
	        	terminator = i;
	            break;
	        }
	 	}
		return new ValueEnd(null, terminator);
	}

}
