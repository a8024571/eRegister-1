<html>
  <body>
    This is classes::index.gsp<br/>

    <table>
      <thead>
        <tr>
          <td>Course Name</td>
          <td>Class Name</td>
          <td>Instructor</td>
        </tr>
      </thead>
      <tbody>
        <g:each in="${classList}" var="c">
          <tr>
            <td>${c.courseName}</td>
            <td>${c.className}</td>
            <td>${c.instructorName}</td>
          </tr>
        </g:each>
      </tbody>
    </table>

  </body>
</html>
