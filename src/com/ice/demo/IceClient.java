package com.ice.demo;

import Demo.HelloPrx;
import Demo.HelloPrxHelper;
import Ice.Communicator;
import Ice.ObjectPrx;
import Ice.Util;

public class IceClient {
	
	public static void main(String[] args) {
		int status = 0;
		// Communicator ʵ��
		Communicator ice = null;
		
		try {
			System.out.println("���� Ice.Util.initalize ������ʼ��");
			ice = Util.initialize(args);
			
			System.out.println("���� servant �������Լ�������ip���˿ڻ�ȡԶ�̷������");
			ObjectPrx base = ice.stringToProxy("SimpleHello:default -p 10000");
			
			System.out.println("������Ĵ�������ת����һ�� Hello �ӿڵĴ���");
			HelloPrx HelloProxy = HelloPrxHelper.checkedCast(base);
			
			// check �Ƿ�ת���ɹ�
			if (HelloProxy == null) {
				throw new Exception("Invalid Proxy");
			}
			
			System.out.println("ͨ���������ʵ��Զ�̹��̵���");
			String ret = HelloProxy.sayHello("zeroc ice");
			
			System.out.println("��ӡ���ý������ֵ");
			System.out.print(ret);
		} catch(Exception e) {
			e.printStackTrace();
			status = 1;
		} finally {
			if (ice != null) {
				ice.destroy();
			}
		}
		
		System.out.println("�ͻ��˳����˳�");
		System.exit(status);
	}
}
