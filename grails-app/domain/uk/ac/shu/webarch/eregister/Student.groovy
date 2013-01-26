package uk.ac.shu.webarch.eregister

class Student {

  String fullStudentName
  String studentNumber

  static constraints = {
    fullStudentName(nullable:false, blank:false,maxSize:256);
    studentNumber(nullable:false, blank:false,maxSize:256);
  }
}
