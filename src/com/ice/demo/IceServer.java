package com.ice.demo;

import Ice.Communicator;
import Ice.ObjectAdapter;
import Ice.Util;

public class IceServer {

	public static void main(String[] args) {
		int status = 0;
		// Communicator 实例
		Communicator ice = null;
		
		try {
			System.out.println("调用 Ice.Util.initalize 方法初始化");
			ice = Util.initialize(args);
			
			System.out.println("创建一个对象适配器，传入适配器名字 SimpleHelloAdapter，在10000端口监听服务，默认采用 tcp 协议");
			ObjectAdapter adapter = ice.createObjectAdapterWithEndpoints("SimpleHelloAdapter", "default -p 10000");
			
			System.out.println("实例化一个 HelloImpl 对象，为 接口创建一个 servant");
			HelloImpl object = new HelloImpl();
			
			System.out.println("调用适配器 add 方法，告诉它增加一个新的servant，第一个参数是 servant 对象，第二个参数是 servant 的名字");
			adapter.add(object, Util.stringToIdentity("SimpleHello"));
			
			System.out.println("调用适配器 activate 方法，激活适配器，开始处理来自客户端的请求");
			adapter.activate();
			
			System.out.println("这个方法挂起发出调用的线程，直到服务器实现终止为止。或我们自己发出一个调用关闭。 ");
			ice.waitForShutdown();
		} catch (Exception e) {
			e.printStackTrace();
			status = 1;
		} finally {
			if (ice != null) {
				ice.destroy();
			}
		}
		
		System.out.println("服务端程序退出");
		System.exit(status);
	}

}
