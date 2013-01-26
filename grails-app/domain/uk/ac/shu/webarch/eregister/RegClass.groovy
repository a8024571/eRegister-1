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

  static constraints = {
  }

  static mapping = {
    classInstructor column:'instructor_fk'
  }
}
