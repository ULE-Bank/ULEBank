<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenid@ a ULeBank office</title>
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


<link rel="stylesheet" href="resources/css/style.css">

<script src="resources/js/ChangingBackground.js"></script>
</head>

<body onload='changeimage(3)'>

	<div
		style='position: fixed; width: 100%; height: 100%; left: 0px; top: 0px; z-index: -100;'
		align='center'>
		<img width='1920' height='1080' id='myimage' />
	</div>
	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#login">Log In</a></li>
			<li class="tab"><a href="#signup">Sign Up</a></li>
		</ul>

		<div class="tab-content">


			<div id="login">
				<h1>Welcome Back!</h1>

				<form action="/usuarios" method="post">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label> <input type="password" name="password" required autocomplete="off" />
					</div>

					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>

					<button class="button button-block" name="login">Log In</button>

				</form>

			</div>

			<div id="signup">
				<h1>Sign Up for Free!</h1>

				<form action="/usuarios" method="post">

					<div class="top-row">
						<div class="field-wrap">
							<label> First Name<span class="req">*</span>
							</label> <input type="text" name="name" required autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> Last Name<span class="req">*</span>
							</label> <input type="text" name="lastname" required autocomplete="off" />
						</div>
					</div>

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Set A Password<span class="req">*</span>
						</label> <input type="password" name="password" required autocomplete="off" />
					</div>

					<button type="submit" class="button button-block" name="signup">
					Get Started
					</button>

				</form>

			</div>


		</div>
		<!-- tab-content -->




	</div>
	<!-- /form -->

	<a href="originalIndex.html"><button class="button button-block" />Back
		to original index
		</button></a>
		<br>
		<a href="indexprueba.htm"><button class="button button-block" />Try Spring MVC. Redirect to indexprueba.htm which is controlled by DispatcherServlet delegating to hellocontroller
		</button></a>

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="resources/js/index.js"></script>


</body>
</html>
