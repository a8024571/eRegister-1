package uk.ac.shu.webarch.eregister

class RegistrationSheet {

  /* What course this sheet is for */
  Course course

  /* Date of the sheet */
  Date sheetDate

  /* Signatories */
  Set signatories

  /* Any notes */
  String notes

  /** TODO:
   *  Add the metadata needed to add a list if RegisterEntry classes for this sheet... essentially
   *  modelling the fact that 1 registration sheet has many register entries.
   *
   *  The RegisterEntry class will need a property that points back to this RegistrationSheet. You
   *  should implement that link first
   */

  static constraints = {
    course(nullable:false, blank:false);
    sheetDate(nullable:false, blank:false);
    notes(nullable:true, blank:true);
  }

  static mapping = {
    notes column: 'course_desc', type:'text'
  }
}
