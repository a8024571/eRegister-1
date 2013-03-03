<html>
  <body>
    This is classes::classHome.gsp<br/>

    Class Name : ${cls.name}<br/>
    Course : ${cls.course.courseName}<br/>
    Class code : ${cls.code}<br/>
    Taught By : ${cls.classInstructor?.name}<br/>
    <hr/>
    Current Sheets
    <g:form mapping="classHome" params="${[courseCode:cls.course.courseCode,classCode:cls.code]}" method="POST">
      New Sheet Shortcode: <input type="text" name="shortcode"/> 
      <input type="submit"/>
    </g:form>
    <br/>
    <table>
      <tr><th>Code</th><th>Date</th><th>Attendance</th></tr>
      <g:each in="${cls.registrationSheets}" var="sheet">
        <tr>
          <td><g:link mapping="sheetHome" params="${[courseCode:cls.course.courseCode,classCode:cls.code,sheetCode:sheet.shortcode]}">${sheet.shortcode}</g:link></td>
          <td><g:link mapping="sheetHome" params="${[courseCode:cls.course.courseCode,classCode:cls.code,sheetCode:sheet.shortcode]}">${sheet.sheetDate}</g:link></td>
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
