package uk.ac.shu.webarch.eregister

/*
 * A Class. 
 * We called the class RegClass to avoid reserved word clashes with the java keyword "class"
 *
 * This class has a name, and a foreign key to the instructor who teaches this class. This is the 1 side
 * of a 1 to many relationship
 *
 */
class RegClass {

  /* Class name */
  String name

  /* Instructor teaching this class */
  Instructor classInstructor

  /* This class is an occurrence of which course? */
  Course course

  /* The set of students enrolled on this class */
  Set enrolledSudents

  /*
   *   TODO
   *   THIS CLASS NEEDS a hasMany adding for the enrolledStudents set above. 
   *
   *   this will be a set of "Enrollment" objects
   * 
   *   This class will also need a mapped by section so that the class knows 
   *   to use the "student" property of the Enrollment class as the foreign key
   *   
   */ 

  static hasMany = [
  ]

  static mappedBy = [
  ]

  static constraints = {
  }

  static mapping = {
    classInstructor column:'instructor_fk'
    course column:'course_fk'
  }
}
