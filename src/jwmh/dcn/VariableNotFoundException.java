package jwmh.dcn;

class VariableNotFoundException extends IllegalContentsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4718520319182988963L;

	public VariableNotFoundException() {}

	public VariableNotFoundException(String arg0) {
		super(arg0);
	}

	public VariableNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public VariableNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
