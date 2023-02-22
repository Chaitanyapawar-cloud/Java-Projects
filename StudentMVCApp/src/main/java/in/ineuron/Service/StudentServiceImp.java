package in.ineuron.Service;

import in.ineuron.DAO.IStudentDao;
import in.ineuron.Dto.Student;
import in.ineuron.Factory.StudentDaoFactory;
import in.ineuron.Factory.StudentServiceFactory;
import in.ineuron.Service.*;

public class StudentServiceImp implements IStudentService {

	@Override
	public String save(Student s) {
		IStudentDao std =StudentDaoFactory.getStudentDao();
		return std.save(s);
		
		
	}

	@Override
	public Student CheckById(Integer Id) {
		IStudentDao std =StudentDaoFactory.getStudentDao();
		return  std.CheckById(Id);
	}

	@Override
	public String Update(Student st) {
		IStudentDao std =StudentDaoFactory.getStudentDao();
		return  std.Update(st);
		
	}

	@Override
	public String DeleteById(Integer Id) {
		IStudentDao std =StudentDaoFactory.getStudentDao();
		return   std.DeleteById(Id);
		
	}

}
