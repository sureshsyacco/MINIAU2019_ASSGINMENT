package com.junit.test;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Test;

import com.junit.CsvProcessing;
import com.junit.Marks;
import com.junit.Student;
import com.junit.Subject;
import com.opencsv.CSVReader;

public class studentTest {
	

	@Test
	public void testComparator() {
		Student s1 = new Student(1, "a", 5);
		s1.getStudentMarks().put(Subject.BIOLOGY, new Marks(1, Subject.BIOLOGY, 5));
		s1.getStudentMarks().put(Subject.CHEMISTRY, new Marks(1, Subject.CHEMISTRY, 5));
		s1.getStudentMarks().put(Subject.MATHS, new Marks(1, Subject.MATHS, 5));
		s1.getStudentMarks().put(Subject.PHYSICS, new Marks(1, Subject.PHYSICS, 5));
		s1.getStudentMarks().put(Subject.GEOGRAPHY, new Marks(1, Subject.GEOGRAPHY, 5));

		Student s2 = new Student(2, "b", 5);
		s2.getStudentMarks().put(Subject.BIOLOGY, new Marks(2, Subject.BIOLOGY, 6));
		s2.getStudentMarks().put(Subject.CHEMISTRY, new Marks(2, Subject.CHEMISTRY, 5));
		s2.getStudentMarks().put(Subject.MATHS, new Marks(2, Subject.MATHS, 5));
		s2.getStudentMarks().put(Subject.PHYSICS, new Marks(2, Subject.PHYSICS, 5));
		s2.getStudentMarks().put(Subject.GEOGRAPHY, new Marks(2, Subject.GEOGRAPHY, 5));

		Student s3 = new Student(3, "c", 5);
		s3.getStudentMarks().put(Subject.BIOLOGY, new Marks(2, Subject.BIOLOGY, 7));
		s3.getStudentMarks().put(Subject.CHEMISTRY, new Marks(2, Subject.CHEMISTRY, 5));
		s3.getStudentMarks().put(Subject.MATHS, new Marks(2, Subject.MATHS, 5));
		s3.getStudentMarks().put(Subject.PHYSICS, new Marks(2, Subject.PHYSICS, 5));
		s3.getStudentMarks().put(Subject.GEOGRAPHY, new Marks(2, Subject.GEOGRAPHY, 5));

		List<Student> sortedStudents = new ArrayList<Student>();
		sortedStudents.add(s1);
		sortedStudents.add(s2);
		sortedStudents.add(s3);

		List<Student> expectedStudents = new ArrayList<Student>();
		expectedStudents.add(s3);
		expectedStudents.add(s2);
		expectedStudents.add(s1);

		Collections.sort(sortedStudents, CsvProcessing.StudentRankComparator);
		assertEquals(sortedStudents, expectedStudents);
	}

	@Test
	public void testComparatorWithSameMarks() {
		Student s1 = new Student(1, "a", 6);
		s1.getStudentMarks().put(Subject.BIOLOGY, new Marks(1, Subject.BIOLOGY, 5));
		s1.getStudentMarks().put(Subject.CHEMISTRY, new Marks(1, Subject.CHEMISTRY, 5));
		s1.getStudentMarks().put(Subject.MATHS, new Marks(1, Subject.MATHS, 5));
		s1.getStudentMarks().put(Subject.PHYSICS, new Marks(1, Subject.PHYSICS, 5));
		s1.getStudentMarks().put(Subject.GEOGRAPHY, new Marks(1, Subject.GEOGRAPHY, 5));

		Student s2 = new Student(2, "b", 5);
		s2.getStudentMarks().put(Subject.BIOLOGY, new Marks(2, Subject.BIOLOGY, 5));
		s2.getStudentMarks().put(Subject.CHEMISTRY, new Marks(2, Subject.CHEMISTRY, 5));
		s2.getStudentMarks().put(Subject.MATHS, new Marks(2, Subject.MATHS, 5));
		s2.getStudentMarks().put(Subject.PHYSICS, new Marks(2, Subject.PHYSICS, 5));
		s2.getStudentMarks().put(Subject.GEOGRAPHY, new Marks(2, Subject.GEOGRAPHY, 5));

		List<Student> sortedStudents = new ArrayList<Student>();
		sortedStudents.add(s1);
		sortedStudents.add(s2);

		List<Student> expectedStudents = new ArrayList<Student>();
		expectedStudents.add(s2);
		expectedStudents.add(s1);

		Collections.sort(sortedStudents, CsvProcessing.StudentRankComparator);
		assertEquals(sortedStudents, expectedStudents);
	}
	
//	@Test
//	public void testRankedWrite() throws IOException {
//		CsvProcessing studentDao = new CsvProcessing();
//		Map<Integer, Student> students = studentDao.loadStudents();
//		studentDao.loadMarks(students);
//		studentDao.storeStudent(new ArrayList<Student>(students.values()));
//
//		List<Student> sortedStudents = new ArrayList<Student>(students.values());
//		Collections.sort(sortedStudents, CsvProcessing.StudentRankComparator);
//
//		List<Student> writtenStudents = new ArrayList<Student>();
//		CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Suresh.Yadahalli\\results.csv"), ',');
//		List<String[]> rows = csvReader.readAll();
//		for (String[] row : rows) {
//			Integer studentId = Integer.valueOf(row[1]);
//			String studentName = row[2];
//			Integer studentAge = Integer.valueOf(row[3]);
//			writtenStudents.add(new Student(studentId, studentName, studentAge));
//		}
//		assertEquals(sortedStudents, writtenStudents);
//
//	}
	
//	@Test
//	public void testRankedWrite() throws IOException {
//		CsvProcessing studentDao = new CsvProcessing();
//	Map<Integer, Student> students = studentDao.loadStudents();
//	studentDao.loadMarks(students);
//		
//	}

	
}
