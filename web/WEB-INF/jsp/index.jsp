<%--
  Created by IntelliJ IDEA.
  User: Ganon
  Date: 2/4/2017
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>Email List Deduper</title>
    <style>
      .flex-container {
        display: -webkit-flex;
        display: flex;
        text-align: center;
      }
      .flex-container.alignment{
        -webkit-justify-content: center;
        justify-content: center;
        width: 100%;
        flex-direction: column;
      }
      .flex-container.textarea-container{
        -webkit-justify-content: center;
        justify-content: center;
        width: 100%;
        height: 200px;
      }
      .flex-container.buttons{
        -webkit-justify-content: center;
        justify-content: center;
        width: 100%;
        flex-direction: row;
      }
      .button {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 12px;
        margin: 4px 2px;
        cursor: pointer;
      }
      textarea {
        width: 100%;
        height: 150px;
        padding: 12px 20px;
        box-sizing: border-box;
        border: 2px solid #ccc;
        border-radius: 4px;
        background-color: #f8f8f8;
        font-size: 16px;
        resize: none;
      }
      table {
        border-collapse: collapse;
        width: 100%;
      }
      th, td {
        text-align: left;
        padding: 8px;
      }
    </style>
  </head>
  <body>
    <div class="flex-container alignment">
      <header>
        <h1>Email List Deduper</h1>
        <h4>Insert comma separated list of emails to dedupe, or click Generate Emails to generate 10000 emails containing ~50%
        duplicates.</h4>
        <h4>Then click Dedupe! to dedupe the list and see processing time and the two lists.</h4>
      </header>
      <div class="flex-container textarea-container">
        <form:form modelAttribute="emails" action="/emails" method="POST">
          <form:textarea path="emails"></form:textarea>
          <div class="flex-container buttons">
            <input type="submit" class="button" name="generate" value="Generate Random Emails">
            <input type="submit" class="button" name="dedupe" value="Dedupe!">
          </div>
        </form:form>
      </div>
      <c:if test="${fn:length(dedupedEmails)>0}">
        <h4>Time to Dedupe: ${duration} ms</h4>
        <table>
          <tr>
            <th>Original List Email</th>
            <th>Original List Index</th>
            <th>Deduped List Email</th>
            <th>Deduped List Index</th>
          </tr>
          <c:set var="j" value="-1" />
          <c:forEach items="${originalEmails}" var="email" varStatus="loop">
            <tr>
              <th>${email}</th>
              <th>${loop.index}</th>
              <c:if test="${dedupedEmails[j+1]==email}">
                <th>${dedupedEmails[j+1]}</th>
                <th>${j = j + 1}</th>
              </c:if>
            </tr>
          </c:forEach>
        </table>
      </c:if>
    </div>
  </body>
</html>