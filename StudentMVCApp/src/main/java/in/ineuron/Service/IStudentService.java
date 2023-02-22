package in.ineuron.Service;

import in.ineuron.Dto.Student;

public interface IStudentService {

	String save(Student s);
	Student CheckById(Integer Id);
	String Update(Student st );
	String DeleteById(Integer Id);
}
