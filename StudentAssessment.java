import java.util.*;
import java.util.*;

public class StudentAssessment
{
	public String getGrade(int totalMarks) 
	{
		if(totalMarks<=100 && totalMarks>=90)
			return "A+";
		else if (totalMarks<90 && totalMarks>=80)
			return "A";
		else if (totalMarks<80 && totalMarks>=70)
			return "B+";
		else if (totalMarks<70 && totalMarks>=60)
			return "B";
		else if (totalMarks<60 && totalMarks>=50)
			return "C+";
		else if (totalMarks<50 && totalMarks>=40)
			return "C";
		else 
			return "D";
	}	
	// to get the list of students with high marks
	public HashMap<Integer,Student> highPerformanceAssessment(HashSet<Student> students)
	{	
		HashMap<Integer,Student> high_low_students = new HashMap<Integer,Student>();
		ArrayList<Integer> listOfMarks = new ArrayList<Integer>();
		listOfMarks = getListOfMarks(students);
		int high = Collections.max(listOfMarks);
		int low = Collections.min(listOfMarks);
//		System.out.println(high);
//		System.out.println(low);
		if( high == low )
		{
			return high_low_students;
		}
		else 
		{
			Iterator itr = students.iterator();
			while(itr.hasNext())
			{
				Student student = (Student)itr.next();

				System.out.println(student.getTotalMarks());
				if(student.getTotalMarks() == high)
				{
					high_low_students.put(1, student);
				}
				if(student.getTotalMarks() == low)
				{
					high_low_students.put(0, student);
				}
			}
		}
		return high_low_students;
	}
	
	// To get the list of total marks
	private static ArrayList<Integer> getListOfMarks(HashSet<Student> students)
	{
		ArrayList<Integer> listOfMarks = new ArrayList<Integer>();
		Iterator itr = students.iterator();
		while(itr.hasNext())
		{
			Student student = (Student)itr.next();
			listOfMarks.add(student.getTotalMarks());
		}
		return listOfMarks;
	}
	
	public int getClassAverage(HashSet<Student> students)
	{	
		int total = 0;
		for(Student student: students)
		{
			total += student.getTotalMarks();
		}
		return total/students.size();		
	}
	
}