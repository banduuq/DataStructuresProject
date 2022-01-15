package ds_project;

public   class Student implements Comparable <Student>{
	
	private  String  student_id;
	private String name;
	private String surname;
	private String faculty;
	private String deparment;
	
	public Student(String name,String surname, String  student_id, String faculty,String department) {
		this.student_id =  student_id;
		this.name = name;
		this.surname = surname;
		this.faculty = faculty;
		this.deparment = department;
	}
	public Student() {
		
	}
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getDeparment() {
		return deparment;
	}
	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}
	
	public boolean  equals(Object  obj) {
		if(this.getStudent_id() != obj) {
			return false;
		}
	
		else {
			return true;
		}
		
	}
	public String toString() {
		return "student_id: " + student_id + "  name: " + name + " surname: " + surname + " faculty: " + faculty
				+ "  deparment: " + deparment + "  mail: " +  student_id +"@ogr.cbu.edu.tr" ;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
	 if(Integer.parseInt(this.student_id) > Integer.parseInt(o.student_id)) {
		 return 1;
	 }
	 
	 if(Integer.parseInt(this.student_id)  < Integer.parseInt(o.student_id)) {
		 return -1;
	 }
	 else {
		 return 0;
	 }
	}
	
	public String  equals() {
		return this.name;
	}
	
	
}
	
 



