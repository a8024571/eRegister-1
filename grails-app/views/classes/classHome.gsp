<html>
  <body>
    This is classes::classHome.gsp<br/>

    Class Name : ${cls.name}<br/>
    Course : ${cls.course.courseName}<br/>
    Class code : ${cls.code}<br/>
    Taught By : ${cls.classInstructor?.name}<br/>
    <hr/>
    Current Sheets
    <g:form mapping="clsact" 
            params="${[courseCode:cls.course.courseCode,classCode:cls.code]}"
            action='newAttendanceSheet'>
      New Sheet Shortcode: <input type="text" name="shortcode"/> 
      <input type="submit"/>
    </g:form>
    <br/>
    <table>
      <tr><th>Date</th><th>Attendance</th></tr>
      <g:each in="${cls.registrationSheets}" var="sheet">
        <tr>
          <td>${sheet.sheetDate}</td>
          <td>${sheet.signatories?.size()}</td>
        </tr>
      </g:each>    
    </table>
    
    <hr/>
    Students
    <table>
      <g:each in="${cls.enrolledSudents}" var="student">
        <tr>
          <td>${student.name}</td>
        </tr>
      </g:each>    
    </table>

    
  </body>
</html>
