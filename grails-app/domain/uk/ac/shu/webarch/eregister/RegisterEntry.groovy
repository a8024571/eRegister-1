package uk.ac.shu.webarch.eregister

/**
 *  An entry in the register for a particular student. Again, a simple link table. Holds the 
 *  1: part of two 1:M relationshops. A student signs many registers, a register is signed by many students.
 */
class RegisterEntry {

  /* The student signing this register */
  Student student

  /* The register being signed */
  RegistrationSheet regSheet

  /* Date/Time of the signing */
  Long timestamp

  /* 
   * No constraints for this simple domian class
   */
  static constraints = {
    timestamp(nullable:false, blank:false);
  }

  /*
   * Again, we use a cleaner and more traditional join table name
   */
  static mapping = {
    table 'student_register_entry'
    student column: 'student_fk'
  }
}
