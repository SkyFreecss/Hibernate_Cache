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
 *1.第二次查询同一个对象时，并没有再次执行数据库查询。
 *2.在不同的session中多次查询同一对象时，会执行多次数据库查询。
 *3.一级缓存中，持久化类的每个实例都具有唯一的OID(也就是说一级缓存只在当前session内，其它的session则不能使用)。
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

    	   //使用evict方法清除一次缓存。
    	   //session.evict(user);
    	   //clear清除一级缓存中的所有内容。
    	   session.clear();
           user = (User) session.get(User.class,1);
           System.out.println(user.getUsername());
           session.close();
          */
    	   
    	   //---------------附加部分--------------------------
    	   /*
    	    * 若使用Query对象的list方法，那么将不会用到一级缓存。
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
    	   
    	   /*可以看出，经由Query的list方法查询后，生成了一个缓存，
    	    * 所以Iterator的iterate方法通过每一个编号在缓存中进行查询。
    	    */
    	   Iterator it = query.iterate();
    	   while(it.hasNext())
    	   {
    		   User user = (User) it.next();
    		   System.out.println(user.getUsername());
    	   }
    	  
    	  //----------------------------------------------
    	   /**
    	   query.list()和query.iterate()区别

           1.返回的类型不同：

           list()返回List；iterate()返回Iterate。

           2.查询策略不同：

           list()直接发送sql语句，查询数据库；

           iterate()发送sql语句，从数据库取出id，然后先从缓存中根据id查找对应信息，

                            有就返回结果，没有就根据id发送sql语句，查询数据库。

           3.返回对象不同：

           list()返回持久化实体类对象；

           iterate()返回代理对象。

           4.与缓存的关系不同：

           list()只缓存，但不使用缓存（查询缓存除外）；

           iterate()会使用缓存。 
    	   */
    	    
       }
}
