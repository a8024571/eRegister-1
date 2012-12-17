package uk.ac.shu.webarch.eregister

class Instructor {

  static hasMany = [
    classes:RegClass
  ]

  static mappedBy = [
    classes:'instructor'
  ]

  static constraints = {
  }
}
