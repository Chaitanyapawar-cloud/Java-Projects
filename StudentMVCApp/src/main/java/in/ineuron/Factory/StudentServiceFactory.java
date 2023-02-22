package in.ineuron.Factory;


import in.ineuron.Service.IStudentService;
import in.ineuron.Service.StudentServiceImp;

public class StudentServiceFactory {
	private static IStudentService studentService;
	public StudentServiceFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static IStudentService getStudentService()
	{
		if(studentService==null)
			studentService=new StudentServiceImp();
		
		return studentService;
	}

}
