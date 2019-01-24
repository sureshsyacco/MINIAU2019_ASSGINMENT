package com.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;

public class CsvProcessing {

	public Map<Integer, Student> loadStudents() throws IOException {
		Map<Integer, Student> students = new HashMap<Integer, Student>();
		CSVReader studentCSVReader = new CSVReader(new FileReader("C:\\Users\\Suresh.Yadahalli\\students.csv"), ',');
		List<String[]> studentRows = studentCSVReader.readAll();
		for (String[] row : studentRows) {
			Integer studentId = Integer.valueOf(row[0]);
			String studentName = row[1];
			Integer studentAge = Integer.valueOf(row[2]);
			students.put(studentId, new Student(studentId, studentName, studentAge));
		}
		return students;
		
	}

	public void loadMarks(Map<Integer, Student> students) throws IOException {
		CSVReader markCSVReader = new CSVReader(new FileReader("C:\\Users\\Suresh.Yadahalli\\marks.csv"), ',');
		List<String[]> markRows = markCSVReader.readAll();
		for (String[] row : markRows) {
			Integer studentId = Integer.valueOf(row[0]);
			Subject subject = Subject.valueOf(row[1]);
			Integer score = Integer.valueOf(row[2]);
			students.get(studentId).getStudentMarks().put(subject, new Marks(studentId, subject, score));
		}
	}

	public void storeStudent(List<Student> students) throws IOException {
		Collections.sort(students, StudentRankComparator);
		CSVWriter studentCSVWriter = new CSVWriter(new FileWriter("C:\\Users\\Suresh.Yadahalli\\results.csv"), ',');
		Integer rank = 0;
		for (Student student : students) {
			String[] tempArr = new String[student.getCSV().length + 1];
			tempArr[0] = rank.toString();
			System.arraycopy(student.getCSV(), 0, tempArr, 1, tempArr.length - 1);
			studentCSVWriter.writeNext(tempArr);
			rank++;
		}
		studentCSVWriter.close();
	}

	public static final Comparator<Student> StudentRankComparator = new Comparator<Student>() {

		public int compare(Student s1, Student s2) {
			int s1Score = 0, s2Score = 0;
			for (Subject subject : Subject.values()) {
				s1Score += s1.getStudentMarks().get(subject).getTotal();
				s2Score += s2.getStudentMarks().get(subject).getTotal();
			}
			if (s1Score == s2Score) {
				return s1.getStudentAge() - s2.getStudentAge();
			} else {
				return s2Score - s1Score;
			}
		}
	};
}