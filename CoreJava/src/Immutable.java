import java.util.Date;

public final class Immutable {
	
	private final String name;
	
	private final Integer age;
	
	private final Date dateOfBirth;
	
	public Immutable(String conName , Integer conAge , Date dob ) {
		// TODO Auto-generated constructor stub
		this.name = conName;
		this.age = conAge;
		this.dateOfBirth = new Date(dob.getTime());
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Date getDateOfBirth() {
		return new Date(dateOfBirth.getTime());
	}
	
}
