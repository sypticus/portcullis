<%--
  Created by IntelliJ IDEA.
  User: kyle
  Date: 4/6/11
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Configure Motes</title></head>
  <body>
  <div><g:link action="newMote" controller="mote">Add</g:link> </div>
  <table>
      <tr>
          <td>
              Id
          </td>
          <td>
              Name
          </td>
          <td>Settings</td>
      </tr>
      <g:each in="${motes}" var="mote">
         <tr>
          <td>${mote.mid}</td>
          <td>${mote.name}</td>
          <td><g:link controller="mote" action="config" id="${mote.id}">config</g:link> | <g:link action="sensors" controller="mote" id="${mote.id}">sensors</g:link> </td>
      </tr>
      </g:each>

  </table>
  </body>
</html>