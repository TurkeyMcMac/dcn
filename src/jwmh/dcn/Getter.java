package jwmh.dcn;

/**
 * This class is used to
 * insert variable getters
 * when writing objects in
 * data capsule notation.
 * <p>
 * Warning: do not try to
 * use capsules which will
 * be ignored on compilation
 * as variables to be gotten.
 * This will throw an
 * IllegalContentsException.
 * 
 * @author jude
 *
 */
public class Getter {
	
	Object variable;
	
	public Getter(Object variable) {
		this.variable = variable;
	}

}
