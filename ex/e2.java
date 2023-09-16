package ex;


import java.util.List;
import java.util.stream.Collectors;

public class e2 {

//	@RestController
//	@RequestMapping("users")
//	public class UserRestController {
//		private final UserRepository repository;
//
//		UserRestController(UserRepository repository) {
//			this.repository = repository;
//		}
//
//		@GetMapping
//		public ResponseEntity<List<UserDto>> create(@RequestParam(required = false) String name) {
//			List<UserDto> users = repository.findAll();
//			List<UserDto> response = users.stream()
//					.filter(p -> p.getName().equals(name))
//					.toList();
//
//			if(name != null) return new ResponseEntity<>(response, HttpStatus.OK);
//			else return new ResponseEntity<>(users, HttpStatus.OK);
//
//		}
//	}


	public static void main(String[] args) {
		UserDto u1 = new UserDto(1, "1", "1");
		UserDto u2 = new UserDto(2, "2", "2");
		UserDto u3 = new UserDto(3, "3", "3");
		List<UserDto> users = List.of(u1, u2, u3);
		List<UserDto> list = users.stream()
				.filter(p -> p.getName().equals("4"))
				.toList();


		System.out.println(list);

	}

	public static class UserDto {
		private Integer id;
		private String name;
		private String role;

		public UserDto() {}

		public UserDto(Integer id, String name, String role) {
			this.id = id;
			this.name = name;
			this.role = role;
		}

		public Integer getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getRole() {
			return role;
		}
	}

}
