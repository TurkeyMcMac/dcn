package jude.dcn;

import java.util.regex.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public abstract class Capsule {

	public final char START;
	public final char FINISH;
	public final String BLUEPRINT;
	private Pattern pattern;
	
	protected Capsule(char start, char finish) {
		START = start;
		FINISH = finish;
		BLUEPRINT = Pattern.quote(Character.toString(START)) + getInner() + Pattern.quote(Character.toString(FINISH));
		pattern = Pattern.compile(BLUEPRINT, Pattern.DOTALL);
		capsules.put(new SimpleEntry<Character, Character>(START, FINISH), this);
	}
	
	private static String innerPattern = "(.*)";
	
	protected String getInner() {
		return innerPattern;
	}
	
	private static Map<SimpleEntry<Character, Character>, Capsule> capsules = new HashMap<>();
	
	private static Capsule categorize(String capsule) {
		SimpleEntry<Character, Character> ends = new SimpleEntry<Character, Character>(capsule.charAt(0), capsule.charAt(capsule.length() - 1));
		for (SimpleEntry<Character, Character> p : capsules.keySet()) {
			if (ends.getKey() == p.getKey() && ends.getValue() == p.getValue()) {
				return capsules.get(p);
			}
		}
		return NULL;
	}
	
	public static Object process(String capsule) {
		return categorize(capsule).detect(capsule);
	}
	
	protected final String findContents(String capsule) {
		Matcher detector = pattern.matcher(capsule);
		if (detector.lookingAt()) {
			return detector.group(1);
		}
		return null;
	}
	
	public abstract Object detect(String capsule);
	
	public static final Capsule COMMENT = new CommentCapsule();
	public static final Capsule STRING = new StringCapsule();
	public static final Capsule CHARACTER = new CharacterCapsule();
	public static final Capsule INTEGER = new IntegerCapsule();
	public static final Capsule BOOLEAN = new BooleanCapsule();
	public static final Capsule LIST = new ListCapsule();
	public static final Capsule HASH = new HashCapsule();
	public static final Capsule NULL = new NullCapsule();
	
	public static void main(String[] args) {
		Map<Object, Object> list = ((Map<Object, Object>) process("{ 'g': (5), 'h': <true> }"));
		//System.out.println(list.get('g') + "\n" + list.get('h'));
	}
	
}
