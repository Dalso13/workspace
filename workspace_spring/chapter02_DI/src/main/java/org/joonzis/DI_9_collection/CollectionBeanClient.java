package org.joonzis.DI_9_collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationContext9.xml");
		
		
		CollectionBean cBean1 = ctx.getBean("cBean1" , CollectionBean.class);
		CollectionBean cBean2 = ctx.getBean("cBean2" , CollectionBean.class);
		CollectionBean cBean3 = ctx.getBean("cBean3" , CollectionBean.class);
		
	
		// 값 꺼내기
		List<String> list = cBean1.getAddressList();
		
		for (String sss : list) {
			System.out.println(sss);
		}
		
		System.out.println("-------------\n-------------");
		
		
		Set<String> set = cBean2.getAddressSet();
		
		Iterator<String> itr = set.iterator();	
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("-------------\n--------------");
		
		Map<String, String> map = cBean3.getAddressMap();
		
		Set<String> setMap = map.keySet();
		
		Iterator<String> itr2 = setMap.iterator();	
		
		while (itr2.hasNext()) {
			String sss = itr2.next();
			String value = map.get(sss);
			
			System.out.println(sss + " : " + value);
		}
		
		
		ctx.close();
		
	}
}
