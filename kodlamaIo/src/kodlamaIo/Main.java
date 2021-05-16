package kodlamaIo;

public class Main {

	public static void main(String[] args) {
		Instructor �nstructor = new Instructor(1,"Engin","Demiro�","1234","engindemirog@asd.com");
		�nstructor.setClassNumber(3);
		�nstructor.setStudentNumber(4500);
		
		Student student = new Student(2,"Yunus Emre","Bayaz�t","5678","yunusemre@asd.com");
		student.setGpa(3.14);
		student.setUniversity("Konya Teknik �niversitesi");
		
		UserManager userManager = new UserManager();
		InstructorManager instructorManager = new InstructorManager();
		StudentManager studentManager = new StudentManager();
		
		userManager.logIn(�nstructor);
		instructorManager.course(�nstructor);
		instructorManager.homework(�nstructor);
		userManager.logOut();

		userManager.logIn(student);
		studentManager.course();
		studentManager.homework();
		userManager.logOut();
		
		
		
		

	}

}
