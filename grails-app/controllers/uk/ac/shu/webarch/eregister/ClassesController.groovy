package uk.ac.shu.webarch.eregister


import grails.converters.*
import uk.ac.shu.webarch.eregister.*;

class ClassesController {

  def index() { 

    def result=[:]

    result.classList = []

    RegClass.findAll().each { cls ->
      result.classList.add([instructorName:cls.classInstructor.name,
                            courseCode:cls.course.courseCode, 
                            courseName:cls.course.courseName,
                            classCode:cls.code, 
                            className:cls.name])
    }

    withFormat {
      html result
      xml { render result as XML }
      json { render result as JSON }
    }
  }

  def courseHome() {
    println("ClassesController::courseHome ${params}");
    def result = [:]
    result.course = Course.findByCourseCode(params.courseCode)
    if ( result.course == null ) {
      response.sendError(404)
    }
  
    result
  }

  def classHome() {
    def result = [:]
    result.cls = RegClass.findByCode(params.classCode)
    if ( result.cls == null ) {
      response.sendError(404)   
    }

    println("classHome - method was ${request.method} shortcode=${params.shortcode}");

    switch ( request.method ) {
      case 'POST':
        println("Create new sheet");
        def new_sheet = new RegistrationSheet(regClass:result.cls,
                                              shortcode:params.shortcode,
                                              sheetDate:new Date()).save();
        redirect(mapping:'sheetHome', params:[courseCode:params.courseCode,classCode:params.classCode,sheetCode:params.shortcode])
        break;
      case 'GET':
        println("Create new sheet");
        break;
    }
 
    result
  }

  def sheetHome() {
    def result = [:]
    result.sheet = RegistrationSheet.findByShortcode(params.sheetCode)

    if ( result.sheet == null ) {
      response.sendError(404)   
    }

    println("sheetHome ${params.studentNumber}");

    switch ( request.method ) {
      case 'POST':
        if ( params.regAction=='sign' ) {
          println("Sign register for \"${params.studentNumber}\"");
          Student s = Student.findByStudentNumber(params.studentNumber)
          if ( s ) {
            RegisterEntry re = new RegisterEntry(regSheet:result.sheet,student:s,timestamp:System.currentTimeMillis()).save();
          }
          else {
            println("Unknown student");
            flash.message = "Unknown student";
          }
        }
        break;
      case 'GET':
        break;
    }

    result
  }
}
