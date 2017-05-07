package jude.dcn;

import java.util.Map;
import java.util.HashMap;

final class HashCapsule extends StructuredCapsule {

	public HashCapsule() {
		super('{', '}');
	}

	@Override
	protected Map<Object, Object> processList(String[] contentList) {
		HashMap<Object, Object> hash = new HashMap<>();
		for (String s : contentList) {
			String[] parts = s.split("\\s*:\\s*");
			hash.put(Capsule.process(parts[0]), Capsule.process(parts[1]));
		}
		return hash;
	}

}
