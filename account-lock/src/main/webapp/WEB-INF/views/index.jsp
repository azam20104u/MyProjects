<<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login and Registration Page</title>
    
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <!-- Login Section -->
            <div class="col-md-6">
                <form action="login" method="post">
                    <h2 class="text-center">Login</h2>
                    <div class="mb-3">
                        <label for="login-username" class="form-label">Username</label>
                        <input type="text" id="login-username" name="username" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="login-password" class="form-label">Password</label>
                        <input type="password" id="login-password" name="password" class="form-control" />
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary btn-block">Login</button>
                    </div>
                    <div class="text-center">
                         <h3>${loginMsg }</h3>
                    </div>
                </form>
            </div>
            
            <!-- Registration Section -->
            <div class="col-md-6">
                <form action="registration" method="post">
                    <h2 class="text-center">Register</h2>
                    <div class="mb-3">
                        <label for="register-username" class="form-label">Full Name</label>
                        <input type="text" id="register-username" name="fullname" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="register-username" class="form-label">Username</label>
                        <input type="text" id="register-username" name="username" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="register-password" class="form-label">Password</label>
                        <input type="password" id="register-password" name="password" class="form-control" />
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-success btn-block">Register</button>
                    </div>
                    <div class="text-center">
                        <h3>${msg }</h3>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Add Bootstrap JS link (optional) -->
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script> -->
</body>
</html>
