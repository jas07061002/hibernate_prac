<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

First Name: <form:input path="firstName"/>
<br><br>

Last Name: <form:input path="lastName"/>
<br><br>

Country: 

<form:select path="country">
<!-- we are changing this to get the options from Java class instead of hardcoding it here -->
<%-- <form:option value="Brazil" label="Brazil" /> --%>
<%-- <form:option value="France" label="France" /> --%>
<%-- <form:option value="Germany" label="Germany" /> --%>
<%-- <form:option value="India" label="India" /> --%>

<%-- <form:options items="${student.countryOptions}" /> --%>
<form:options items="${theCountryOptions}" />


</form:select>
<br> <br>

Favorite Language:

Java <form:radiobutton path="favoriteLanguage" value="Java"/>
C# <form:radiobutton path="favoriteLanguage" value="C#"/>
PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>

<br> <br>

Operating Systems:

Linux <form:checkbox path="operatingSystems" value="Linux"/>
Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>

 

<br><br>
<input type="submit" value="Submit"/>
</form:form>



</body>
</html>
