<%-- 
    Document   : index.jsp
    Created on : Feb 14, 2023, 1:49:55 PM
    Author     : sparshramchandani
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Tags</title>
    </head>
    <body  >
        <h1 style=" text-decoration: underline" ><c:out value="${'Welcome to Assignment 3 - Part 3'}"/></h1>
        <h2><c:out value="Examples for jstl Core tags" /></h2>
        <h3><c:out value="${'This is an example of <c:out> tag'}"/></h3>
        <h3><c:out value="This is an example for <c:set> and <c:remove> tag" /></h3>
        <c:set var="income" scope="session" value="$ ${5000*4}"/>  
        <p>Before Remove Value is: <c:out value="${income}"/></p>  
        <c:remove var="income"/>  
        <p>After Remove Value is: <c:out value="${income}"/></p>  
        <h3><c:out value="${'This is an example of <c:if> tag'}"/></h3>
        <c:set var="income" scope="session" value="${5000*4}"/>  
        <c:if test="${income > 8000}">  
            <p>My income is: <c:out value="${income}"/><p>
            </c:if>


        <h2><c:out value="Examples for jstl Formatting tags" /></h2>
        <h3><c:out value="This is an example for <fmt:parseNumber> tag"/></h3>
        <c:set var="Amount" value="786.970" />  
        <fmt:parseNumber var="j" type="number" value="${Amount}" />  
        <p><i>Amount is:</i>  <c:out value="${j}" /></p>  
        <fmt:parseNumber var="j" integerOnly="true" type="number" value="${Amount}" />  
        <p><i>Amount is:</i>  <c:out value="${j}" /></p>  

        <h3><c:out value="Examples for <fmt:formatNumber> tag" /></h3>  
        <c:set var="Amount" value="9850.14115" />  
        <p> Formatted Number-1:  
            <fmt:formatNumber value="${Amount}" type="currency" /></p>  
        <p>Formatted Number-2:  
            <fmt:formatNumber type="number" groupingUsed="true" value="${Amount}" /></p>  
        <p>Formatted Number-3:  
            <fmt:formatNumber type="number" maxIntegerDigits="3" value="${Amount}" /></p>  
        <p>Formatted Number-4:  
            <fmt:formatNumber type="number" maxFractionDigits="6" value="${Amount}" /></p>  
        <p>Formatted Number-5:  
            <fmt:formatNumber type="percent" maxIntegerDigits="4" value="${Amount}" /></p>  
        <p>Formatted Number-6:  
            <fmt:formatNumber type="number" pattern="###.###$" value="${Amount}" /></p>

        <h3><c:out value="Examples for <fmt:formatDate> tag" /></h3>  
        <c:set var="Date" value="<%=new java.util.Date()%>" />  
        <p>  
            Formatted Time :  
            <fmt:formatDate type="time" value="${Date}" />  
        </p>  
        <p>  
            Formatted Date :  
            <fmt:formatDate type="date" value="${Date}" />  
        </p>  
        <p>  
            Formatted Date and Time :  
            <fmt:formatDate type="both" value="${Date}" />  
        </p>  
        <p>  
            Formatted Date and Time in short style :  
            <fmt:formatDate type="both" dateStyle="short" timeStyle="short"  
                            value="${Date}" />  
        </p>  
        <p>  
            Formatted Date and Time in medium style :  
            <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  
                            value="${Date}" />  
        </p>  
        <p>  
            Formatted Date and Time in long style :  
            <fmt:formatDate type="both" dateStyle="long" timeStyle="long"  
                            value="${Date}" />  
        </p>  


        <h2><c:out value="Examples for jstl Function tags" /></h2>
        <h3><c:out value="Examples for <fn:split> tag" /></h3>  
        <c:set var="str1" value="Welcome-to-JSP-Programming."/>  
        <c:set var="str2" value="${fn:split(str1, '-')}" />  
        <c:set var="str3" value="${fn:join(str2, ' ')}" />  

        <p>String-3 : ${str3}</p>  
        <c:set var="str4" value="${fn:split(str3, ' ')}" />  
        <c:set var="str5" value="${fn:join(str4, '-')}" />  

        <p>String-5 : ${str5}</p>  

        <h3><c:out value="Examples for <fn:toLowerCase> tag" /></h3>  
        <c:set var="string" value="Welcome to JSP Programming"/>  
        ${fn:toLowerCase("HELLO,")}  
        ${fn:toLowerCase(string)}  

        <h3><c:out value="Examples for <fn:substring> tag" /></h3> 
        <c:set var="string" value="This is the first string."/>  
        <c:out value="${string}"/><br>
        ${fn:substring(string, 5, 17)}  
    </body>  
</body>
</html>