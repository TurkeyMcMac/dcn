package jude.dcn;

final class ListCapsule extends CollectiveCapsule {

	protected ListCapsule() {
		super('[', ']');
	}
	
	protected ValueEnd evaluate(String capsule) {
	    return listValues(capsule);
	}
	
}
