<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>부트스트랩 입력 폼</title>
  <!-- Bootstrap 5 CSS CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- FontAwesome CDN -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
  <div class="container mt-5">
  <!-- 홈 아이콘 버튼 -->
  <a href="/" class="btn btn-link">
     <i class="fas fa-home fa-2x"></i> 홈으로 가기
  </a>
        
    <h2 class="mb-4">정보 수정 폼</h2>
    <form action="/phonebook/update" method="post">
     <div class="mb-3">
        <label for="id" class="form-label">아이디</label>
        <input type="text" class="form-control" id="id" name="id" value="${pb.id}" readonly disabled>
        <input type="hidden" class="form-control" id="id" name="id" value="${pb.id}">
      </div>
      
      <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input type="text" class="form-control" id="name" name="name" value="${pb.name}">
      </div>

      <div class="mb-3">
        <label for="hp" class="form-label">휴대폰</label>
        <input type="tel" class="form-control" id="hp" name="hp" value="${pb.hp}">
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">이메일</label>
        <input type="email" class="form-control" id="email" name="email" value="${pb.email}">
      </div>

      <div class="mb-3">
        <label for="memo" class="form-label">메모</label>
        <textarea class="form-control" id="memo" name="memo" rows="4" >${pb.memo}</textarea>
      </div>

      <button type="submit" class="btn btn-primary">전화번호수정</button>
    </form>
  </div>

  <!-- Bootstrap 5 JS (선택 사항) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>