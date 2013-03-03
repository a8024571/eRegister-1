import uk.ac.shu.webarch.eregister.*;

class BootStrap {

  def init = { servletContext ->

    println("BootStrap::init");
    
    def ian_instructor = Instructor.findByStaffId('646345d') ?: new Instructor(staffId:'646345d', name:'Ian Ibbotson').save();
    def matthew_instructor = Instructor.findByStaffId('253425') ?: new Instructor(staffId:'253425', name:'Matthew Love').save();

    def web_arch_course = Course.findByCourseCode('55-5571-00L-A-20123') ?: new Course(courseCode:'55-5571-00L-A-20123', 
                                                                            courseName:'Web Architectures', 
                                                                            description:'Headache for students').save();

 
    def im_course = Course.findByCourseCode('443343d4') ?: new Course(courseCode:'443343d4', 
                                                                            courseName:'Interactive Multimedia', 
                                                                            description:'Interactive Multimedia').save();

    def monday_pm_class = RegClass.findByCourseAndCode(web_arch_course, 'WebArchOne') ?: 
                  new RegClass(name:'Web Architectures Group One',
                               code:'WebArchOne',
                               classInstructor:ian_instructor, 
                               course:web_arch_course).save();

    def tuesday_pm_class = RegClass.findByCourseAndCode(web_arch_course, 'WebArchTwo') ?: 
                  new RegClass(name:'Web Architectures Group Two',
                               code:'WebArchTwo',
                               classInstructor:ian_instructor, 
                               course:web_arch_course).save();

    def inter_multi_c1 = RegClass.findByCourseAndCode(im_course, 'IMOne') ?:
                  new RegClass(name:'Interactive Multimedia Group One',
                               code:'IMOne',
                               classInstructor:matthew_instructor,
                               course:im_course).save();


    def student_a = Student.findByStudentNumber('A111') ?:
                  new Student(studentNumber:'A111', fullStudentName:'Student Fred', notes:'Student Fred Notes').save();

    def student_b = Student.findByStudentNumber('B111') ?:
                  new Student(studentNumber:'B111', fullStudentName:'Student James', notes:'Student Fred Notes').save();

    def student_c = Student.findByStudentNumber('C111') ?:
                  new Student(studentNumber:'C111', fullStudentName:'Student Gill', notes:'Student Gill Notes').save();

    def student_d = Student.findByStudentNumber('D111') ?:
                  new Student(studentNumber:'D111', fullStudentName:'Student Freda', notes:'Student Freda Notes').save();

    def student_e = Student.findByStudentNumber('E111') ?:
                  new Student(studentNumber:'E111', fullStudentName:'Student Janine', notes:'Student Janine Notes').save();

    def student_f = Student.findByStudentNumber('F111') ?:
                  new Student(studentNumber:'F111', fullStudentName:'Student Graham', notes:'Student Graham Notes').save();

    def student_g = Student.findByStudentNumber('G111') ?:
                  new Student(studentNumber:'G111', fullStudentName:'Student Wibble', notes:'Student Wibble Notes').save();

    println("Find or create by...")

    def student_a_web_arch = Enrollment.findOrCreateByStudentAndRegClass(student_a,monday_pm_class)

    def student_b_web_arch = Enrollment.findOrSaveByStudentAndRegClass(student_b,monday_pm_class)

    def student_c_web_arch = Enrollment.findOrSaveByStudentAndRegClass(student_c,tuesday_pm_class)

    def student_d_web_arch = Enrollment.findOrSaveByStudentAndRegClass(student_d,tuesday_pm_class)

    def student_e_web_arch = Enrollment.findOrSaveByStudentAndRegClass(student_e,tuesday_pm_class)

    def student_f_web_arch = Enrollment.findOrSaveByStudentAndRegClass(student_f,monday_pm_class)

    def student_g_web_arch = Enrollment.findOrSaveByStudentAndRegClass(student_g,tuesday_pm_class)

    println("Done...");

  }

  def destroy = {
  }

}
