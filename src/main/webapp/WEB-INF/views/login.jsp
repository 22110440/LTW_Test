<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>Đăng nhập - Quản lý Video</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">

	<style>
		body {
			min-height: 100vh;
			display: flex;
			flex-direction: column;
			background: linear-gradient(135deg, #74ebd5, #ACB6E5);
		}
		header {
			flex-shrink: 0;
		}
		main {
			flex: 1;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		.login-card {
			border: none;
			border-radius: 24px;
			overflow: hidden;
			box-shadow: 0 10px 30px rgba(0,0,0,0.25);
			width: 100%;
			max-width: 700px;
		}
		.login-header {
			background: #4e73df;
			color: #fff;
		}
		.login-header h2 {
			font-weight: bold;
			font-size: 2rem;
		}
		.form-control {
			border-radius: 14px;
			font-size: 1.2rem;
			padding: 14px 16px;
		}
		.btn-primary {
			border-radius: 14px;
			font-size: 1.2rem;
			padding: 14px;
		}
		footer {
			flex-shrink: 0;
			background: #f8f9fa;
			padding: 15px 0;
			text-align: center;
			border-top: 1px solid #ddd;
		}
	</style>
</head>
<body>

<main>
	<div class="card login-card">
		<div class="card-header text-center py-4 login-header">
			<h2 class="mb-0"><i class="bi bi-person-circle"></i> Đăng nhập</h2>
		</div>
		<div class="card-body p-5 bg-white">
			<form method="post" action="${pageContext.request.contextPath}/login">
				<div class="mb-4">
					<label class="form-label fs-5">Tên đăng nhập</label>
					<div class="input-group input-group-lg">
						<span class="input-group-text"><i class="bi bi-person"></i></span>
						<input type="text" name="username" class="form-control"
							   placeholder="Nhập tên đăng nhập" required>
					</div>
				</div>
				<div class="mb-4">
					<label class="form-label fs-5">Mật khẩu</label>
					<div class="input-group input-group-lg">
						<span class="input-group-text"><i class="bi bi-lock"></i></span>
						<input type="password" name="password" class="form-control"
							   placeholder="Nhập mật khẩu" required>
					</div>
				</div>
				<button type="submit" class="btn btn-primary btn-lg w-100">Đăng nhập</button>
			</form>
			<div class="text-center mt-4">
				<p class="mb-1">
					Chưa có tài khoản?
					<a href="${pageContext.request.contextPath}/register" class="fw-bold">Đăng ký ngay</a>
				</p>
				<p><a href="#">Quên mật khẩu?</a></p>
			</div>
		</div>
	</div>
</main>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>