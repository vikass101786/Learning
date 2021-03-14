import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("ABC", "DEF", "GHI", "JKL");

		System.out.println("===========USING EXTERNAL ENHANCED FOR EACH ITERATOR=============");

		for (String name : names) {
			if (!name.equals("DEF")) {
				System.out.println(name);
			}
		}

		System.out.println("==========JAVA 8 WAY || REAL CODE [EXPANDED DAY]==============");

		names.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return !t.equals("DEF");
			}
		}).forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		System.out.println("==================");

		names.stream().filter(t -> !t.equals("DEF")).forEach(t -> System.out.println(t));

		System.out.println("==================");

		names.stream().filter(t -> isFilter(t)).forEach(System.out::println);

		System.out.println("==================");

		names.stream().filter(Streams::isFilter).forEach(System.out::println);
		
		
		
		names.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return !t.equals("DEF");
			}
		}).map(new Function<String, User>() {
			@Override
			public User apply(String t) {
				return new User(t, ((int)(Math.random()*100)));
			}
		}).forEach(new Consumer<User>() {
			@Override
			public void accept(User t) {
				System.out.println(t);
			}
		});
		
		
		
		
		names.stream().filter(t -> !t.equals("DEF")).
		map( t ->  new User(t, ((int)(Math.random()*100)))).
		forEach( t -> System.out.println(t));
		

	}

	public static boolean isFilter(String name) {
		return !name.equals("DEF");
	}

	static class User {
		private String name;
		private int age;
		public User(String name, int age) {
			this.name = name;
			this.age = age;
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
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "name :: [" + name + "]  age :: [ " + age + " ]";
		}
	}
	
}
