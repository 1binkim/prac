<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>사용자 ${user.userId == null ? "등록" : "수정"}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h1>사용자 ${user.userId == null ? "등록" : "수정"}</h1>

<form action="<c:url value='${user.userId == null ? "/admin/users/add" : "/admin/users/edit"}'/>"
      method="post" autocomplete="off">

  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

  <c:if test="${user.userId != null}">
    <input type="hidden" name="userId" value="${user.userId}" />
  </c:if>

  <div class="mb-3">
    <label class="form-label">아이디</label>
    <c:choose>
      <c:when test="${user.userId == null}">
        <input type="text" class="form-control" name="newUsername" required />
      </c:when>
      <c:otherwise>
        <p>${user.username}</p>
      </c:otherwise>
    </c:choose>
  </div>

  <c:if test="${user.userId == null}">
    <div class="mb-3">
      <label class="form-label">비밀번호</label>
      <input type="password" class="form-control" name="password" required />
    </div>
  </c:if>

  <div class="mb-3">
    <label class="form-label">이메일</label>
    <input type="email" class="form-control" name="email" value="${user.email}" required />
  </div>

  <div class="mb-3">
    <label class="form-label">연락처</label>
    <input type="text" class="form-control" name="phone" value="${user.phone}" />
  </div>

  <div class="mb-3">
    <label class="form-label">권한</label>
    <select name="role" class="form-select">
      <option value="CUSTOMER" ${user.role == 'CUSTOMER' ? 'selected' : ''}>CUSTOMER</option>
      <option value="ADMIN" ${user.role == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
    </select>
  </div>

  <button type="submit" class="btn btn-primary">${user.userId == null ? "등록" : "수정"}</button>
  <a href="<c:url value='/admin/users'/>" class="btn btn-secondary">목록으로</a>

</form>

</body>
</html>