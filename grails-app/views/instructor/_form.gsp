<%@ page import="uk.ac.shu.webarch.eregister.Instructor" %>



<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'classes_taught_by_this_instructor', 'error')} ">
	<label for="classes_taught_by_this_instructor">
		<g:message code="instructor.classes_taught_by_this_instructor.label" default="Classestaughtbythisinstructor" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${instructorInstance?.classes_taught_by_this_instructor?}" var="c">
    <li><g:link controller="regClass" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="regClass" action="create" params="['instructor.id': instructorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'regClass.label', default: 'RegClass')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="instructor.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${instructorInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'staffNumber', 'error')} ">
	<label for="staffNumber">
		<g:message code="instructor.staffNumber.label" default="Staff Number" />
		
	</label>
	<g:textField name="staffNumber" value="${instructorInstance?.staffNumber}"/>
</div>

