package in.ineuron.DAO;

import in.ineuron.Dto.Student;

public interface IStudentDao {

	String save(Student s);
	Student CheckById(Integer Id);
	String Update(Student st );
	String DeleteById(Integer Id);
}
