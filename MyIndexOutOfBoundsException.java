/**
 * An exception thrown if the user selects an empty index
 * 
 * @author "Kush Patel"
 *
 * @param exception message e which is sent to the superclass Exception to throw error message
 */
public class MyIndexOutOfBoundsException extends RuntimeException {
	public MyIndexOutOfBoundsException(String e) {
		super(e);
	}

	public MyIndexOutOfBoundsException() {
		super();
	}

}
