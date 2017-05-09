package jude.dcn;

abstract class PrimitiveCapsule extends Capsule {

	protected PrimitiveCapsule(char start, char finish) {
		super(start, finish);
	}
	
	protected abstract Object parseContents(String contents);
	
	@Override
	protected ValueEnd evaluate(String capsule) {
		String contents = "";
	    int terminator = 0;
	    for (int i = 0; i < capsule.length(); i++) {
	    	char currentChar = capsule.charAt(i);
	        if (currentChar == FINISH) {
	        	terminator = i;
	            break;
	        } else {
	            contents += currentChar;
	        }
	 	}
		return new ValueEnd(parseContents(contents), terminator);
	}

}
