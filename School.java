import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class School 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);

		HashSet<Student> students = new HashSet<Student>();
		StudentAssessment studentAssessment1 = new StudentAssessment();
		int numberOfStudents = Validation.read_number(input, "Enter the number of students : ");
		int roll, totalMarks; 
		String name,grade;
		System.out.println("Enter the student details");
		for(int i=0; i< numberOfStudents; i++)
		{
			System.out.println("Student"+(i+1));
			roll = Validation.read_roll(input, "Enter the roll number : ",students);
			name = Validation.read_name(input, "Enter the name : ");
			totalMarks = Validation.read_int_score(input, "Enter the total marks : ");
			grade = studentAssessment1.getGrade(totalMarks);	
			students.add(new Student(roll, name, totalMarks, grade));
			System.out.println("One record inserted.");
			System.out.println();
		}	
		System.out.println(students);
		if(numberOfStudents == 1)
		{
			for(Student student: students)
			{
				System.out.println("---- Only one record found ----");
				System.out.println("---- Details of the student ----");
				student.display();
			}
		}
		else 
		{
			HashMap<Integer,Student> highPerformStudents = new HashMap<Integer,Student>();
			highPerformStudents = studentAssessment1.highPerformanceAssessment(students);
			if(highPerformStudents.isEmpty())
			{
				System.out.println("---- Details of the students ----");
				for(Student student: students)
				{
					student.display();
				}
			}
			else 
			{
				Set set = highPerformStudents.entrySet();
				Iterator entryItr = set.iterator();
				while(entryItr.hasNext())
				{
					Map.Entry entryObj = (Map.Entry) entryItr.next();
					int key = (Integer)entryObj.getKey();
					Student student = (Student)entryObj.getValue();
					if(key == 1)
					{
						System.out.println("---- Details of the student with highest mark ----");
						student.display();
					}
					else 
					{
						System.out.println("---- Details of the student with lowest mark -----");
						student.display();
					}
				}
			}
						
		}
		input.close();
	}
}