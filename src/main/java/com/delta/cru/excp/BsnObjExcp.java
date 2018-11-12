package com.delta.cru.excp;

public class BsnObjExcp extends Exception {

    private static final long serialVersionUID = -3825935087413777004L;

    public BsnObjExcp(Throwable cse) {
        super(cse);
    }
    
    /**
	 * Creates an exception object with the specified message.
	 */
	public BsnObjExcp( String msg) {
		super(msg);
	}

}
