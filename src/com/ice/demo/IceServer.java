package com.ice.demo;

import Ice.Communicator;
import Ice.ObjectAdapter;
import Ice.Util;

public class IceServer {

	public static void main(String[] args) {
		int status = 0;
		// Communicator ʵ��
		Communicator ice = null;
		
		try {
			System.out.println("���� Ice.Util.initalize ������ʼ��");
			ice = Util.initialize(args);
			
			System.out.println("����һ���������������������������� SimpleHelloAdapter����10000�˿ڼ�������Ĭ�ϲ��� tcp Э��");
			ObjectAdapter adapter = ice.createObjectAdapterWithEndpoints("SimpleHelloAdapter", "default -p 10000");
			
			System.out.println("ʵ����һ�� HelloImpl ����Ϊ �ӿڴ���һ�� servant");
			HelloImpl object = new HelloImpl();
			
			System.out.println("���������� add ����������������һ���µ�servant����һ�������� servant ���󣬵ڶ��������� servant ������");
			adapter.add(object, Util.stringToIdentity("SimpleHello"));
			
			System.out.println("���������� activate ��������������������ʼ�������Կͻ��˵�����");
			adapter.activate();
			
			System.out.println("����������𷢳����õ��̣߳�ֱ��������ʵ����ֹΪֹ���������Լ�����һ�����ùرա� ");
			ice.waitForShutdown();
		} catch (Exception e) {
			e.printStackTrace();
			status = 1;
		} finally {
			if (ice != null) {
				ice.destroy();
			}
		}
		
		System.out.println("����˳����˳�");
		System.exit(status);
	}

}
