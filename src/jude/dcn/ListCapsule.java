package jude.dcn;

import java.util.List;
import java.util.ArrayList;

final class ListCapsule extends StructuredCapsule {

	protected ListCapsule() {
		super('[', ']');
	}

	@Override
	protected List<Object> processList(String[] contentList) {
		List<Object> values = new ArrayList<>(contentList.length);
		for (String s : contentList) {
			values.add(Capsule.process(s));
		}
		return values;
	}

	
	
}
