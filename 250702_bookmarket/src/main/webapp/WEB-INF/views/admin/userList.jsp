<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원 목록</title>

  <!-- ✅ Bootstrap CSS CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="container mt-4">
  <h1 class="mb-4">북마켓회원 목록</h1>

  <a href="<c:url value='/admin/users/add'/>" class="btn btn-primary mb-3">새 사용자 등록</a>

  <table class="table table-striped table-bordered">
    <thead class="table-dark">
      <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Role</th>
        <th>가입일</th>
        <th>수정일</th>
        <th>관리</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="u" items="${users}">
      <tr>
        <td>${u.userId}</td>
        <td>${u.username}</td>
        <td>${u.email}</td>
        <td>${u.phone}</td>
        <td>${u.role}</td>
        <td>${u.createdAtStr}</td>
        <td>${u.updatedAtStr}</td>
        <td>
          <a href="<c:url value='/admin/users/edit/${u.userId}'/>" class="btn btn-sm btn-secondary">수정</a>
          <form action="<c:url value='/admin/users/delete/${u.userId}'/>" method="post" style="display:inline">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <!-- ✅ Bootstrap JS Bundle (선택, 필요하면 모달 등 쓸 때) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>