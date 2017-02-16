<%@ include file="/WEB-INF/views/include.jsp"%>
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
			<li class="tab active"><a href="#login"><spring:message code="label.submit"/></a></li>
			<li class="tab"><a href="#signup"><spring:message code="label.signup"/></a></li>
		</ul>

		<div class="tab-content">
		
		<p style="text-align:center"><font color="white"><spring:message code="label.welcome"></spring:message><br>
		<spring:message code="label.language"></spring:message>: <a href="?language=es">Español</a> | <a href="?language=en">English</a><br/></font></p>

			<div id="login">
				<h1><spring:message code="label.welcomeback"/></h1>

				<form action="/usuarios" method="post">

					<div class="field-wrap">
						<label><spring:message code="label.email"/><span class="req">*</span>
						</label> <input type="email" name="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> <spring:message code="label.password"/><span class="req">*</span>
						</label> <input type="password" name="password" required autocomplete="off" />
					</div>

					<p class="forgot">
						<a href="#"><spring:message code="label.forgotpassword"/></a>
					</p>

					<button class="button button-block" name="login"><spring:message code="label.submit"/></button> 

				</form>

			</div>

			<div id="signup">
				<h1><spring:message code="label.signupMessage"/></h1>

				<form action="/usuarios" method="post">

					<div class="top-row">
						<div class="field-wrap">
							<label> <spring:message code="label.name"/><span class="req">*</span>
							</label> <input type="text" name="name" required autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> <spring:message code="label.lastname"/><span class="req">*</span>
							</label> <input type="text" name="lastname" required autocomplete="off" />
						</div>
					</div>

					<div class="field-wrap">
						<label> <spring:message code="label.email"/><span class="req">*</span>
						</label> <input type="email" name="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> <spring:message code="label.password"/><span class="req">*</span>
						</label> <input type="password" name="password" required autocomplete="off" />
					</div>

					<button type="submit" class="button button-block" name="signup">
					<spring:message code="label.letsstart"/>
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
