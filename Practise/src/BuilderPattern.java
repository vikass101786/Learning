
public class BuilderPattern {
	
	private String name;
	private int age;
	private String address;
	
	private BuilderPattern(BuilderPatternHelper builderPatternHelper) {
		this.name = builderPatternHelper.name;
		this.age = builderPatternHelper.age;
		this.address = builderPatternHelper.address;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}

	public static class BuilderPatternHelper {
		private String name;
		private int age;
		private String address;
		
		public BuilderPatternHelper(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}
		
		public BuilderPatternHelper setAge(int age) {
			this.age = age;
			return this;
		}
		
		public BuilderPatternHelper setAddress(String address) {
			this.address=address;
			return this;
		}
		
		public BuilderPattern build() {
			return new BuilderPattern(this);
		}
		
	}
	
}
