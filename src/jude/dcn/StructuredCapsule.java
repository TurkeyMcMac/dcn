
package jude.dcn;

import java.util.List;

abstract class StructuredCapsule extends Capsule {

	protected StructuredCapsule(char start, char finish) {
		super(start, finish);
		// TODO Auto-generated constructor stub
	}
	
	private static String innerPattern = "\\s*(\\S.*\\S)\\s*";
	
	@Override
	protected String getInner() {
		return innerPattern;
	}
	
	protected final String[] listContents(String capsule)  {
		String contents = findContents(capsule);
		return contents.split("\\s*,\\s*");
		
	}
	
	protected abstract Object processList(String[] contentList);
	
	@Override
	public Object detect(String capsule) {
		return processList(listContents(capsule));
	}
	
}
