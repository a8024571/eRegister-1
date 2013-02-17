import uk.ac.shu.webarch.eregister.*;

class BootStrap {

  def init = { servletContext ->

    println("BootStrap::init");
    
    def ian_instructor = Instructor.findByStaffId('646345d') ?: new Instructor(staffId:'646345d', name:'Ian Ibbotson').save();
    def matthew_instructor = Instructor.findByStaffId('253425') ?: new Instructor(staffId:'253425', name:'Matthew Love').save();

    def web_arch_course = Course.findByCourseCode('443343dd') ?: new Course(courseCode:'443343dd', 
                                                                            courseName:'Web Architectures', 
                                                                            description:'Headache for students').save();

 
    def monday_pm_class = RegClass.findByCourseAndName(web_arch_course, 'WebArch-Mondays') ?: 
                  new RegClass(name:'WebArch-Mondays',
                               classInstructor:ian_instructor, 
                               course:web_arch_course).save();

    def tuesday_pm_class = RegClass.findByCourseAndName(web_arch_course, 'WebArch-Mondays') ?: 
                  new RegClass(name:'WebArch-Tuesday',
                               classInstructor:ian_instructor, 
                               course:web_arch_course).save();

    def student_a = Student.findByStudentNumber('A111') ?:
                  new Student(studentNumber:'A111', fullStudentName:'Student Fred', notes:'Student Fred Notes').save();

    def student_b = Student.findByStudentNumber('B111') ?:
                  new Student(studentNumber:'B111', fullStudentName:'Student James', notes:'Student Fred Notes').save();

    def student_c = Student.findByStudentNumber('C111') ?:
                  new Student(studentNumber:'C111', fullStudentName:'Student Gill', notes:'Student Gill Notes').save();

    def student_d = Student.findByStudentNumber('D111') ?:
                  new Student(studentNumber:'D111', fullStudentName:'Student Freda', notes:'Student Freda Notes').save();

    
    def student_a_web_arch = Enrollment.lookupOrCreateByStudentAndRegClass(student:student_a,regClass:monday_pm_class)

    def student_b_web_arch = Enrollment.lookupOrCreateByStudentAndRegClass(student:student_b,regClass:monday_pm_class)

    def student_c_web_arch = Enrollment.lookupOrCreateByStudentAndRegClass(student:student_c,regClass:tuesday_pm_class)

    def student_d_web_arch = Enrollment.lookupOrCreateByStudentAndRegClass(student:student_c,regClass:tuesday_pm_class)
  }

  def destroy = {
  }

}
