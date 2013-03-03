package uk.ac.shu.webarch.eregister

/**
 * Instructor - Teaches a class
 * 
 * As mentioned in class, really we would want a class to have many instructors
 * differentiated by role, but we keep this simple for clarity.
 *
 *
 */
class Instructor {

  /* Remember that all domain classes get an "id" property by default which is
     auto incremented */

  String name
  String staffId

  // Here we say that there is a set of classes that the instructor is associated with
  // We've chosen Set over List as ordering is not important.
  Set classes

  /* Some metadata that tells the framework how to map the set property "classes" to the database */

  /* Here we tell the framework that the classes property is actually a set of RegClass instances.
     This lets the framework understand that it has to join to the reg_class table. The framework
     already knows that this class (Instructor) has a primary key called id. The problem is,
     although we want to join to the reg_class table, what should we use as a foreign key? */
  static hasMany = [classes: RegClass]

  /* The mappedBy property allows us to give the framework a hint about how it should form the join
   * Here, we're saying that the property on the other side of the association is the classInstructor
   * property of the RegClass class. In essence, this tells the framework that the set "Classes"
   * is to consist of all RegClass instances where classInstructor is this. By way of example,
   * if we have an Instructor { Id: 53, Name:"Ian", staffId:'3334a67' }
   * then the set classes will be populated by SQL like"Select * from reg_class where class_instructor = 53"
   * 
   */
  static mappedBy = [classes: 'classInstructor']
 
  /* We set some constraints, max size and what fields can be blank or null */
  static constraints = {
    name(nullable:false, blank:false,maxSize:256);
    staffId(nullable:false, blank:false,maxSize:20, unique:true);
  }
}
