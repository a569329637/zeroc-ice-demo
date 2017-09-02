package com.ice.demo;

import Demo._HelloDisp;
import Ice.Current;

public class HelloImpl extends _HelloDisp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7812836118148648322L;

	@Override
	public String sayHello(String name, Current __current) {
		// TODO Auto-generated method stub
		return "hello " + name;
	}

}
