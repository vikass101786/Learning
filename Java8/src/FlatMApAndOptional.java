import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FlatMApAndOptional {
	
	
	public static void main(String[] args) {
		List<User> users = Arrays.asList(new User("ABC", 20, Arrays.asList("LUcknow","Kanpur")),
										 new User("DEF", 30, Arrays.asList("BHOPAL","MADURAI")),
										 new User("GHI", 20, Arrays.asList("AHEMDABAD","BANGALORE")),
										 new User("JKL", 20, Arrays.asList("ALLAHABAD","MIRZAPUR")));
		
		 /*Optional<String> address =*/ users.stream()
				 					.map( user -> user.getAddress().stream())
				 					.flatMap(streamString ->  streamString.filter(addresses -> addresses.equals("BANGALORE")))
				 					/*.findAny();*/
				 					.forEach(System.out::println);
		// address.ifPresent(System.out::println);
		 
		// users.stream().map( user -> user.getAddress().stream().filter( add -> add.equals("BANGALORE"))).map(mapper)
		 
		users.stream().map(new Function<User, String>() {

			@Override
			public String apply(User t) {
				String num = "";
				
				return null;
			}
		});
	}
	
	static class User {
		private String name;
		private int age;
		private List<String> address;
		public User(String name, int age, List<String> address) {
			this.name = name;
			this.age = age;
			this.address=address;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}		
		public List<String> getAddress() {
			return address;
		}
		public void setAddress(List<String> address) {
			this.address = address;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "name :: [" + name + "]  age :: [ " + age + " ]";
		}
	}

}
