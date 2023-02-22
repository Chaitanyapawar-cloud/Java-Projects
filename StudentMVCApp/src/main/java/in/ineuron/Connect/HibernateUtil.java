package in.ineuron.Connect;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
   
	private static Configuration cfg = null;
	private static SessionFactory sf = null;
	private static Session session = null;
	
	static{
		cfg = new Configuration();
		
		sf = cfg.configure().buildSessionFactory();
	}
	
	public static Session getSession() 
	{
		if(session==null)
		{
			
			session = sf.openSession();
		}
		return session;
	}
	public static void closeSession(Session s)
	{
		if(s!=null)
		{
			s.close();
		}
	}

}
