package uk.ac.shu.webarch.eregister

class Instructor {

  String name
  String staffNumber

  static hasMany = [
    classes_taught_by_this_instructor:RegClass
  ]

  static mappedBy = [
    classes_taught_by_this_instructor:'class_instructor'
  ]

  static constraints = {
  }
}
