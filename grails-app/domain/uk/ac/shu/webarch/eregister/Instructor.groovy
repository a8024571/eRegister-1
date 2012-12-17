package uk.ac.shu.webarch.eregister

class Instructor {

  String name
  String staffId

  static hasMany = [classes: RegClass]

  static mappedBy = [classes: 'classInstructor']
 
  static constraints = {
  }
}
