import com.revature.repository.UsersRepository;

public class Driver {

	public static void main(String[] args) {
		UsersRepository uRepo = new UsersRepository();
		
		System.out.println(uRepo.getAllUsers());
	}
}
