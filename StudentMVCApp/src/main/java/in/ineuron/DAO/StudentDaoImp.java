package in.ineuron.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.Connect.HibernateUtil;
import in.ineuron.Dto.Student;

public class StudentDaoImp implements IStudentDao {

	private Session session=null;
	private Transaction tx=null;
	
	@Override
	public String save(Student s)  {
		boolean flag =false;
		String status;
		
		try {
			session = HibernateUtil.getSession();
			tx =session.beginTransaction();
			session.save(s);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag =false;
		}
		finally {
				if(flag) 
				{ 
					status ="success";
					tx.commit();
				}
				else { 
						status ="failure";
						tx.rollback();
				}
			}
		return status;	
	}

	@Override
	public Student CheckById(Integer Id) {
		Student st= null;
		
		try {
			session = HibernateUtil.getSession();
			
			 st= session.get(Student.class,Id);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			}
		if(st!=null)
				return st;
		else {
			return null;
		}
		
				
	}

	@Override
	public String Update(Student stud) {
		
		boolean flag =false;
		String status;
		
		try {
			session = HibernateUtil.getSession();
			tx =session.beginTransaction();
			session.clear();
			session.update(stud);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag =false;
		}
		finally {
				if(flag) 
				{ 
					status ="success";
					tx.commit();
				}
				else { 
					status ="failure";
					tx.rollback();
				}
			}
		
		return status;
		
				
	}

	@Override
	public String DeleteById(Integer Id) {
		boolean flag =false;
		String status;
		
		try {
			session = HibernateUtil.getSession();
			tx =session.beginTransaction();
			Student std = new Student();
			std.setId(Id);
			session.delete(std);;
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag =false;
		}
		finally {
				if(flag) 
				{ 
					status ="success";
					tx.commit();
				}
				else { 
					status ="failure";
					tx.rollback();
				}
			}
		return status;	
	}

}
