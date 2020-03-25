public class Student
{
	int roll;
	String name;
	String grade;
	int totalMarks;
	
	public Student(int roll, String name, int totalMarks, String grade)
	{
		this.roll = roll;
		this.name = name;
		this.totalMarks = totalMarks;
		this.grade = grade;
	}
	public int getRoll()
	{ 
		return this.roll;
	}
	public String getName()
	{
		return name;
	}
	public int getTotalMarks()
	{
		return totalMarks;
	}
	public String getGrade()
	{
		return grade;
	}
	public void display()
	{
		System.out.println("Roll Number : "+roll);
		System.out.println("Name : "+name);
		System.out.println("Total Marks : "+totalMarks);
		System.out.println("Grade : "+grade);
	}
}