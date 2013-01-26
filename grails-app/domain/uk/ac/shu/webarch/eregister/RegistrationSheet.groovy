package uk.ac.shu.webarch.eregister

class RegistrationSheet {

  /* What course this sheet is for */
  Course course

  /* Date of the sheet */
  Date sheetDate

  String notes

  static constraints = {
    course(nullable:false, blank:false);
    sheetDate(nullable:false, blank:false);
    notes(nullable:true, blank:true);
  }

  static mapping = {
    notes column: 'course_desc', type:'text'
  }
}
