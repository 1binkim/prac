<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <title>사용자 ${user.userId == null ? "등록" : "수정"}</title>

  <!-- ✅ Bootstrap CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body class="container py-5">

  <h1 class="mb-4">사용자 ${user.userId == null ? "등록" : "수정"}</h1>

  <form action="<c:url value='${user.userId == null ? "/admin/users/add" : "/admin/users/edit"}'/>"
        method="post"
        autocomplete="off">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <c:if test="${user.userId != null}">
      <input type="hidden" name="userId" value="${user.userId}" />
    </c:if>

    <!-- ✅ 아이디 -->
    <div class="mb-3">
      <label for="newUsername" class="form-label">아이디</label>
      <c:if test="${user.userId == null}">
        <input type="text" id="newUsername" name="newUsername"
               class="form-control"
               placeholder="아이디 입력"
               required />
      </c:if>

      <c:if test="${user.userId != null}">
        <input type="text"
               class="form-control-plaintext"
               readonly
               value="${user.username}" />
      </c:if>
    </div>

    <!-- ✅ 비밀번호 (등록 시에만) -->
    <c:if test="${user.userId == null}">
      <div class="mb-3">
        <label for="password" class="form-label">비밀번호</label>
        <input type="password"
               id="password"
               name="password"
               class="form-control"
               placeholder="비밀번호 입력"
               required />
      </div>
    </c:if>

    <!-- ✅ 이메일 -->
    <div class="mb-3">
      <label for="email" class="form-label">이메일</label>
      <input type="email" id="email" name="email"
             class="form-control"
             value="${user.email}" required />
    </div>

    <!-- ✅ 연락처 -->
    <div class="mb-3">
      <label for="phone" class="form-label">연락처</label>
      <input type="text" id="phone" name="phone"
             class="form-control"
             value="${user.phone}" />
    </div>

    <!-- ✅ 권한 -->
    <div class="mb-4">
      <label for="role" class="form-label">권한</label>
      <select id="role" name="role" class="form-select">
        <option value="CUSTOMER" ${user.role == 'CUSTOMER' ? 'selected' : ''}>CUSTOMER</option>
        <option value="ADMIN" ${user.role == 'ADMIN' ? 'selected' : ''}>ADMIN</option>
      </select>
    </div>

    <button type="submit" class="btn btn-primary">
      ${user.userId == null ? "등록" : "수정"}
    </button>
    <a href="<c:url value='/admin/users'/>" class="btn btn-secondary ms-2">목록으로</a>

  </form>

  <!-- ✅ Bootstrap JS Bundle (선택) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
