<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="lbl.title"/></title>
<style>
 .error{
     color:red
 }
</style>

</head>
<body>

<h2>create new account</h2>

<form:form action="saveAccount" modelAttribute="account">

<table>
  <tr>
     <td><spring:message code="lbl.accountNo"/> </td>
     <td> <form:input path="accountNo" size="30"/></td>
     <form:errors path="accountNo" cssClass="error"/>
  </tr>
    <tr>
     <td><spring:message code="lbl.accountHolderName"/> </td>
     <td><form:input path ="accountHolderName" size="30" /></td>  
     <form:errors path="accountHolderName" cssClass="error"/>
     
  </tr>
  <tr>
     <td><spring:message code="lbl.balance"/> </td>
     <td><form:input path ="balance" size="30"/></td>
     <form:errors path="balance" cssClass="error"/>
       
  </tr>
  
  <tr>
     <td><spring:message code="lbl.accountType"/> </td>
     <td> <form:select path="accountType">
          <form:option value="">Select Account Type</form:option>
          <form:option value="SAVINGS">Savings</form:option>
          <form:option value="CURRENT">Current</form:option>
          </form:select>  
     </td>
       <form:errors path="accountType" cssClass="error"/>
  
  </tr>
  
  <tr>
     <td><spring:message code="lbl.dob"/> </td>
     <td><form:input path ="dateOfBirth" size="30" /></td>  
       <form:errors path="dateOfBirth" cssClass="error"/>
  
  </tr>
  
  <tr>
     <td><spring:message code="lbl.psCode"/> </td>
     <td><form:input path ="psCode" size="30"/></td>  
       <form:errors path="psCode" cssClass="error"/>
  
  </tr>
    
  <tr>
  <td colspan="2" align ="center">
  <input type="submit" value="create account" name ="btnSubmit" />
  </tr>
  
  
</table>
</form:form>
</body>
</html>