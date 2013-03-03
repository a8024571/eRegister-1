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

  /* Class code - Used in URLs to generate short clean COOL URLs */
  String code

  /* Instructor teaching this class */
  Instructor classInstructor

  /* This class is an occurrence of which course? */
  Course course

  /* The set of students enrolled on this class */
  Set enrolledSudents
  Set registrationSheets

  static hasMany = [
    enrolledStudents:Enrollment, registrationSheets:RegistrationSheet
  ]

  static mappedBy = [
    enrolledStudents:'regClass', registrationSheets:'regClass'
  ]

  static constraints = {
  }

  static mapping = {
    classInstructor column:'instructor_fk'
    course column:'course_fk'
  }
}
