package kodlama�o2;

public class InstructorManager extends UserManager {
	
	public void homework(User user) {
		System.out.println(user.firstName +" "+user.lastName+" taraf�ndan �dev verildi!");
	}
	
	public void course(User user) {
		System.out.println(user.firstName +" "+user.lastName+" taraf�ndan yeni kurs eklendi !");
	}
}
