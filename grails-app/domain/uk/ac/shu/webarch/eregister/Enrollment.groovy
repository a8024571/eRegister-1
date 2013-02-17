package uk.ac.shu.webarch.eregister

/**
 * Enrollment - Representing the link between a student and a course. A student is
 * enrolled on a course.
 *
 * Here we're mapping a Many to many relationshop by explicitly making a join object.
 * We could have used hasMany mappings on both ends, but this mapping allows us to add
 * properties to the join table. for example: EnrollmentDate, CurrentGrade, etc/
 *
 * Again, this class demonstrates the use of mappings to change table and column names
 * We map the table name to the more traditional course_student and the student proprty
 * to the more meaningful database column name student_fk.
 * 
 */
class Enrollment {

  Student student
  RegClass regClass

  static constraints = {
  }

  static mapping = {
    table 'course_student'
    student column: 'student_fk'
    regClass column: 'reg_class_fk'
  }
}
