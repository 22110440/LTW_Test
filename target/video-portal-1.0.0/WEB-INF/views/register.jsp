<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>Đăng ký - Quản lý Video</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">

	<style>
		body {
			min-height: 100vh;
			display: flex;
			flex-direction: column;
			background: linear-gradient(135deg, #74ebd5, #ACB6E5);
		}
		main {
			flex: 1;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		.register-card {
			border: none;
			border-radius: 24px;
			overflow: hidden;
			box-shadow: 0 10px 30px rgba(0,0,0,0.25);
			width: 100%;
			max-width: 750px;
		}
		.register-header {
			background: #28a745;
			color: #fff;
		}
		.register-header h2 {
			font-weight: bold;
			font-size: 2rem;
		}
		.form-control {
			border-radius: 14px;
			font-size: 1.1rem;
			padding: 14px 16px;
		}
		.btn-success {
			border-radius: 14px;
			font-size: 1.2rem;
			padding: 14px;
		}
	</style>
</head>
<body>

<!-- ✅ MAIN (REGISTER FORM) -->
<main>
	<div class="card register-card">
		<div class="card-header text-center py-4 register-header">
			<h2 class="mb-0"><i class="bi bi-person-plus-fill"></i> Đăng ký tài khoản</h2>
		</div>
		<div class="card-body p-5 bg-white">
			<form method="post" action="${pageContext.request.contextPath}/register">
				<div class="mb-4">
					<label class="form-label fs-5">Họ và tên</label>
					<div class="input-group input-group-lg">
						<span class="input-group-text"><i class="bi bi-person"></i></span>
						<input type="text" name="fullname" class="form-control" placeholder="Nhập họ và tên" required>
					</div>
				</div>
				<div class="mb-4">
					<label class="form-label fs-5">Email</label>
					<div class="input-group input-group-lg">
						<span class="input-group-text"><i class="bi bi-envelope"></i></span>
						<input type="email" name="email" class="form-control" placeholder="Nhập email" required>
					</div>
				</div>
				<div class="mb-4">
					<label class="form-label fs-5">Tên đăng nhập</label>
					<div class="input-group input-group-lg">
						<span class="input-group-text"><i class="bi bi-person-badge"></i></span>
						<input type="text" name="username" class="form-control" placeholder="Nhập tên đăng nhập" required>
					</div>
				</div>
				<div class="mb-4">
					<label class="form-label fs-5">Mật khẩu</label>
					<div class="input-group input-group-lg">
						<span class="input-group-text"><i class="bi bi-lock"></i></span>
						<input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required>
					</div>
				</div>
				<button type="submit" class="btn btn-success btn-lg w-100">Đăng ký</button>
			</form>
			<div class="text-center mt-4">
				<p>Đã có tài khoản?
					<a href="${pageContext.request.contextPath}/login" class="fw-bold">Đăng nhập</a>
				</p>
			</div>
		</div>
	</div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
