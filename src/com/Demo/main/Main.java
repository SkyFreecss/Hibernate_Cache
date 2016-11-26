package com.Demo.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Demo.entity.User;
import com.Demo.util.HibernateUtil;

/**
 * @author SkyFreecss
 *
 *1.�ڶ��β�ѯͬһ������ʱ����û���ٴ�ִ�����ݿ��ѯ��
 *2.�ڲ�ͬ��session�ж�β�ѯͬһ����ʱ����ִ�ж�����ݿ��ѯ��
 *3.һ�������У��־û����ÿ��ʵ��������Ψһ��OID(Ҳ����˵һ������ֻ�ڵ�ǰsession�ڣ�������session����ʹ��)��
 *
 */
public class Main {
       public static void main(String args[])
       {
    	   /*
    	    * 1.
    	   Session session = HibernateUtil.getSession();
    	   User user = (User) session.get(User.class,1);
    	   System.out.println(user.getUsername());

    	   
           user = (User) session.get(User.class,1);
           System.out.println(user.getUsername());
           session.close();
           */
    	   
    	 //-----------------------------------------------
    	   /*
    	    * 2.
    	   Session session = HibernateUtil.getSession();
    	   User user = (User) session.get(User.class,1);
    	   System.out.println(user.getUsername());

    	   Session session2 = HibernateUtil.getSession();
           user = (User) session2.get(User.class,1);
           System.out.println(user.getUsername());
           session.close();
    	    */
    	   
    	   //-----------------------------------------------
    	   /*
    	    * 3.
    	    
    	   Session session = HibernateUtil.getSession();
    	   User user = (User) session.get(User.class,1);
    	   System.out.println(user.getUsername());

    	   //ʹ��evict�������һ�λ��档
    	   //session.evict(user);
    	   //clear���һ�������е��������ݡ�
    	   session.clear();
           user = (User) session.get(User.class,1);
           System.out.println(user.getUsername());
           session.close();
          */
    	   
    	   //---------------���Ӳ���--------------------------
    	   /*
    	    * ��ʹ��Query�����list��������ô�������õ�һ�����档
    	   Session session = HibernateUtil.getSession();
    	   Query query = session.createQuery("from User");
    	   List<User> list = query.list();
    	   for(User user:list)
    	   {
    		   System.out.println(user.getUsername());
    	   }
    	   
    	   list = query.list();
    	   for(User user:list)
    	   {
    		   System.out.println(user.getUsername());
    	   }
    	   */
    	   
    	   //-----------------------------------------------
    	   
    	   Session session = HibernateUtil.getSession();
    	   Query query = session.createQuery("from User");
    	   List<User> list = query.list();
    	   for(User user:list)
    	   {
    		   System.out.println(user.getUsername());
    	   }
    	   
    	   /*���Կ���������Query��list������ѯ��������һ�����棬
    	    * ����Iterator��iterate����ͨ��ÿһ������ڻ����н��в�ѯ��
    	    */
    	   Iterator it = query.iterate();
    	   while(it.hasNext())
    	   {
    		   User user = (User) it.next();
    		   System.out.println(user.getUsername());
    	   }
    	  
    	  //----------------------------------------------
    	   /**
    	   query.list()��query.iterate()����

           1.���ص����Ͳ�ͬ��

           list()����List��iterate()����Iterate��

           2.��ѯ���Բ�ͬ��

           list()ֱ�ӷ���sql��䣬��ѯ���ݿ⣻

           iterate()����sql��䣬�����ݿ�ȡ��id��Ȼ���ȴӻ����и���id���Ҷ�Ӧ��Ϣ��

                            �оͷ��ؽ����û�о͸���id����sql��䣬��ѯ���ݿ⡣

           3.���ض���ͬ��

           list()���س־û�ʵ�������

           iterate()���ش������

           4.�뻺��Ĺ�ϵ��ͬ��

           list()ֻ���棬����ʹ�û��棨��ѯ������⣩��

           iterate()��ʹ�û��档 
    	   */
    	    
       }
}
