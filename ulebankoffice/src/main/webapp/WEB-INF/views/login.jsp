<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="description" content="Buscador de ULe-Bank. Busca contenido en ULe-Bank.">
      <meta name="keywords" content="ULe-Bank, buscador, contenidos">
      <meta name="author" content="Alexis Gutiérrez, Camino Fernández, Razvan Raducu">
      <meta name="robots" content="index,follow">
      <meta name="google-signin-client_id" content="412665771229-fiplfjnpg26j63hut5bdc3vnd7s5spah.apps.googleusercontent.com">
      <link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />
      <link rel="stylesheet"
         href="/resources/services/css/font-awesome/css/font-awesome.min.css">
      <link rel="stylesheet"
         href="/resources/services/css/styles-responsive.css">
      <script src="/resources/services/js/jquery.min.js"></script>
      <!-- <script src="/resources/services/js/bootstrap.min.js"></script> -->
      <script src="/resources/services/js/jquery-cookie.js"></script>
      <script src="/resources/services/js/script.js"></script>
      <script src="/resources/services/js/Chart.js"></script>
      <!-- Favicon -->
      <link rel="shortcut icon" href="../favicon.ico" />
      <!-- bootstrap -->
      <link href="resources/template/css/bootstrap.min.css" rel="stylesheet"
         type="text/css" />
      <!-- plugins -->
      <link href="resources/template/css/plugins-css.css" rel="stylesheet"
         type="text/css" />
      <!-- mega menu -->
      <link href="resources/template/css/mega-menu/mega_menu.css"
         rel="stylesheet" type="text/css" />
      <!-- default -->
      <link href="resources/template/css/default.css" rel="stylesheet"
         type="text/css" />
      <!-- main style -->
      <link href="resources/template/css/style.css" rel="stylesheet"
         type="text/css" />
      <!-- responsive -->
      <link href="resources/template/css/responsive.css" rel="stylesheet"
         type="text/css" />
      <!-- custom style -->
      <link href="resources/template/css/custom.css" rel="stylesheet"
         type="text/css" />
      <title>
         <spring:message code="label.ulebanksearch"/>
      </title>
      <!-- GOOGLE ANALYTICS TRACKER -->
      <script>
         (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
         (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
         m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
         })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
         
         ga('create', 'UA-72492123-1', 'auto');
         ga('send', 'pageview');
      </script>
      
      <!-- Inicializar el objeto GoogleAuth para Google SignIn -->
      <script>
    function start() {
      gapi.load('auth2', function() {
        auth2 = gapi.auth2.init({
          client_id: '412665771229-fiplfjnpg26j63hut5bdc3vnd7s5spah.apps.googleusercontent.com',
          // Scopes to request in addition to 'profile' and 'email'
          //scope: 'additional_scope'
        });
      });
    }
  </script>

</head>

<body onload="startAuthenticator()">

<div class="page-wrapper">

<!--=================================
 preloader -->
 
<div id="preloader">
  <div class="clear-loading loading-effect"> <span></span> </div>
</div>

<!--=================================
 preloader -->


<!--=================================
 header -->
		<jsp:include page="/WEB-INF/views/header.jsp" />

		<!--=================================
 header -->

<!--=================================
 mega menu -->




<!--=================================
 inner-intro-->

<section class="inner-intro bg-contactform bg-opacity-black-70">
  <div class="container">
     <div class="row text-center intro-title">
            <h1 class="text-blue"><spring:message code="label.contactways"/></h1>
            <p class="text-white"><spring:message code="label.contacttogether"/></p>
            <ul class="page-breadcrumb">
              <li><a href="/"><i class="fa fa-home"></i> <spring:message code="label.sitehome"/></a> <i class="fa fa-angle-double-right"></i></li>
              <li><span><spring:message code="label.contactform"/></span> </li>
           </ul>
     </div>
  </div>
</section>

<!--=================================
 inner-intro-->
 <section class="faq white-bg page-section-ptb">
         <div class="container">

<!--=================================
 Google Login-->
<script src="https://apis.google.com/js/platform.js" async defer>
</script>


				<a href="" class="button mt-20" onClick="signOut()" > <span>
				<spring:message code="label.closesession" /></span> 
							<i class="fa fa-sign-out"></i>
				</a>
				<script>
					var GoogleAuth;
					console.log('El valor de la varialbe en 1 es ' + GoogleAuth + ' y ademas ');
					console.log(GoogleAuth==null);
					
					
					
					function signOut() {
						var auth2 = gapi.auth2.getAuthInstance();
						auth2.signOut().then(function() {
							console.log('User signed out.');
						});
					}

					function startAuthenticator() {
						GoogleAuth = gapi.auth2
								.init({
									client_id : '412665771229-fiplfjnpg26j63hut5bdc3vnd7s5spah.apps.googleusercontent.com'

								});
						
						
						console.log('El valor de la varialbe en 2 es ' + GoogleAuth);
						console.log('El valor de el metodo get instance en 2 es '+ gapi.auth2.getAuthInstance());
						var GoogleUser = GoogleAuth.currentUser.get();
						
						var id_token = GoogleUser.getAuthResponse().id_token;
						console.log('Este es id_token' + id_token);
						
						console.log('Hay usuario logeado? '
								+ GoogleUser.isSignedIn())
						if (!GoogleAuth.isSignedIn.get())
							console.log('El usuario no tiene sesión iniciada. '
									+ 'Habría que redireccionar.');
						else
							GoogleAuth.then(isAuth());
					}

					function isAuth() {

						var user = GoogleAuth.currentUser.get(); //Para obtener el usuario
						var profile = user.getBasicProfile();
						console.log('El usuario ' + profile.getName()
								+ ' tiene la sesión iniciada.');
						console.log('ID: ' + profile.getId());
						console.log('Email: ' + profile.getEmail());
						console.log('El usuario tiene sesión iniciada? '
								+ GoogleAuth.isSignedIn.get());
					}
					  function onSignIn(googleUser) {
						  console.log('*/************************************/' + id_token);
						  var profile = googleUser.getBasicProfile();
						  var id_token = googleUser.getAuthResponse().id_token;
						  console.log('Este es id_token' + id_token);
						  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
						  console.log('Name: ' + profile.getName());
						  console.log('Image URL: ' + profile.getImageUrl());
						  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
						  console.log('Given name: ' + profile.getGivenName());
						  console.log('Family Name: ' + profile.getFamilyName());
						  
						  var xhr = new XMLHttpRequest();
						  xhr.open('POST', '/tokensignin');
						  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
						  xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
						  xhr.onload = function() {
						    console.log('Signed in as: ' + xhr.responseText);
						  };
						  xhr.send('idtoken=' + id_token);
						}
				</script>
<div class="g-signin2" data-onsuccess="onSignIn"></div>
<!--=================================
 Google Login-->
 </div>
      </section>



<!--=================================
	 Footer-->
		<jsp:include page="/WEB-INF/views/footer.jsp" />
		<!--=================================
	 Footer-->
	       </div>
	       	<script src="resources/services/js/tooltip-script.js"></script>

		<!-- bootstrap -->
		<script type="text/javascript"
			src="resources/template/js/bootstrap.min.js"></script>

		<!-- plugins-jquery -->
		<script type="text/javascript"
			src="resources/template/js/plugins-jquery.js"></script>

		<!-- mega menu -->
		<script type="text/javascript"
			src="resources/template/js/mega-menu/mega_menu.js"></script>

		<!-- custom -->
		<script type="text/javascript" src="resources/template/js/custom.js"></script>

	       
	    </body>
	</html>