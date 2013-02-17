package uk.ac.shu.webarch.eregister


/**
 * A course. 
 *
 * Keep in mind that this is a simplification. In real life, a course can span many years
 * so we would likely need intermediary objects for course_session.
 *
 * This class demonstrates simple properties (courseName, courseCode, description). It also
 * shows how the database mapping can be influenced with the mapping metadata appearing at the 
 * bottom of the file. In this instance, we slightly change the column names used in the database
 * and change the type of the description property from the conventional varchar to a text lob field.
 * Finally, this class also shows the use of constraints metadata to tell the framework about
 * a validation criteria : that courseCode should not be longer than 20 characters.
 * 
 */
class Course {
  
  String courseName
  String courseCode
  String description
  int myIntProp=1

  /* The set of classes where this course is being taught */
  Set classes

  static constraints = {
    courseCode maxSize: 20
  }

  static hasMany = [classes: RegClass]
  static mappedBy = [classes: 'course']

  // Note  here how we change the SQL column name for description from the default "description" to
  // "course_desc" and the datatype from the convention-generated varchar to the LOB text type
  static mapping = {
    table 'course'
    courseName column: 'course_name'
    courseCode column: 'mapped_course_code'
    description column: 'course_desc', type:'text'
  }
}
