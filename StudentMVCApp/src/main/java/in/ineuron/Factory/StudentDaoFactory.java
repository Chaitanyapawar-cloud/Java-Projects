package in.ineuron.Factory;

import in.ineuron.DAO.IStudentDao;
import in.ineuron.DAO.StudentDaoImp;

public class StudentDaoFactory {

	private static IStudentDao studentDao;
	public StudentDaoFactory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static IStudentDao getStudentDao()
	{
		if(studentDao==null)
			studentDao=new StudentDaoImp();
		
		return studentDao;
	}

	
}
