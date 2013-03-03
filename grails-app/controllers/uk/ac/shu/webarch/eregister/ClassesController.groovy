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
    result
  }

  def newAttendanceSheet() {
    println("classes::newAttendanceSheet(${params})");
    def result = [:]
    def cls = RegClass.findByCode(params.classCode)
    if ( cls ) {
      println("Got class");
    }

  }
}
