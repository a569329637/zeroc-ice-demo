package com.ice.demo;

import Demo.HelloPrx;
import Demo.HelloPrxHelper;
import Ice.Communicator;
import Ice.ObjectPrx;
import Ice.Util;

public class IceClient {
	
	public static void main(String[] args) {
		int status = 0;
		// Communicator 实例
		Communicator ice = null;
		
		try {
			System.out.println("调用 Ice.Util.initalize 方法初始化");
			ice = Util.initialize(args);
			
			System.out.println("根据 servant 的名称以及服务器ip、端口获取远程服务代理");
			ObjectPrx base = ice.stringToProxy("SimpleHello:default -p 10000");
			
			System.out.println("将上面的代理向下转换成一个 Hello 接口的代理");
			HelloPrx HelloProxy = HelloPrxHelper.checkedCast(base);
			
			// check 是否转换成功
			if (HelloProxy == null) {
				throw new Exception("Invalid Proxy");
			}
			
			System.out.println("通过代理对象实现远程过程调用");
			String ret = HelloProxy.sayHello("zeroc ice");
			
			System.out.println("打印调用结果返回值");
			System.out.print(ret);
		} catch(Exception e) {
			e.printStackTrace();
			status = 1;
		} finally {
			if (ice != null) {
				ice.destroy();
			}
		}
		
		System.out.println("客户端程序退出");
		System.exit(status);
	}
}
