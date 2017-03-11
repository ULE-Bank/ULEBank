<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        
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
<link rel="shortcut icon" href="../favicon.ico" type="image/gif" />

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
        
        <title><spring:message code="label.newquery" /></title>
        
        <!-- GOOGLE ANALYTICS TRACKER -->
        <script>
  			(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  			(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  			m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  			})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  			ga('create', 'UA-72492123-1', 'auto');
  			ga('send', 'pageview');
		</script>
        
    </head>

    <body>
        
        <div class="page-wrapper">
		<!--=================================
 preloader -->

		<div id="preloader">
			<div class="clear-loading loading-effect">
				<span></span>
			</div>
		</div>

		<!--=================================
 preloader -->

		<!--=================================
 header -->
		<jsp:include page="/WEB-INF/views/header.jsp" />

		<!--=================================
 header -->


		<!--=================================
 inner-intro-->

		<section
			class="inner-intro grayscale bg-newquery bg-opacity-black-70">
			<div class="container">
				<div class="row text-center intro-title">
					<h1 class="text-blue">
						<spring:message code="label.newquery" />
					</h1>
					<p class="text-white">
						<spring:message code="label.siteservice3description" />
					</p>
					<ul class="page-breadcrumb">
						<li><a href="./"><i class="fa fa-home"></i> <spring:message
									code="label.sitehome" /></a> <i class="fa fa-angle-double-right"></i></li>
						<li><a href="/offersconsulting"><spring:message code="label.siteservice3" /></a><i class="fa fa-angle-double-right"></i></li>
						<li><span><spring:message code="label.newquery" /></span></li>
					</ul>
				</div>
			</div>
		</section>
		
		<!--=================================
 inner-intro-->
		
		<section class="white-bg page-section-ptb">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<form:form role="form" method="post" modelAttribute="newQuestion"
							id="servicesform">
							<div id="register-form" class="register-form">

								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.name" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<i class="fa fa-pencil"></i>
											<form:input type="text" value="" path="nombre" />
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi1"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="nombre"></form:errors>
									</div>
								</div>




								<!-- --------- -->
								
								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.lastname" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<i class="fa fa-pencil"></i>
											<form:input type="text" value="" path="apellidos" />
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi2"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="apellidos"></form:errors>
									</div>
								</div>




								<!-- --------- -->
								
								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.age" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<i class="fa fa-calendar"></i>
											<form:input type="text" value="" path="edad" />
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi3"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="edad"></form:errors>
									</div>
								</div>




								<!-- --------- -->
								
								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.socialclass" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<spring:message code="label.sc1" var="variable1" />
											<spring:message code="label.sc2" var="variable2" />
											<spring:message code="label.sc3" var="variable3" />
											<spring:message code="label.sc4" var="variable4" />
											<spring:message code="label.sc5" var="variable5" />
											<spring:message code="label.sc6" var="variable6" />
											<spring:message code="label.sc7" var="variable7" />
											<form:select path="claseSocial">
												<form:option value="aa" label="${variable1}" />
												<form:option value="ab" label="${variable2}" />
												<form:option value="ma" label="${variable3}" />
												<form:option value="m" label="${variable4}" />
												<form:option value="t" label="${variable5}" />
												<form:option value="ba" label="${variable6}" />
												<form:option value="bb" label="${variable7}" />
											</form:select>
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi4"/>"
											data-toggle="tooltip" data-placement="top" ><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="claseSocial"></form:errors>
									</div>
								</div>




								<!-- --------- -->
								
								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.civilstatus" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<spring:message code="label.single" var="variable1" />
											<spring:message code="label.engaged" var="variable2" />
											<spring:message code="label.married" var="variable3" />
											<spring:message code="label.separated" var="variable4" />
											<spring:message code="label.divorced" var="variable5" />
											<spring:message code="label.widowed" var="variable6" />
											<form:select path="estadoCivil">
												<form:option value="soltero" label="${variable1}" />
												<form:option value="comprometido" label="${variable2}" />
												<form:option value="casado" label="${variable3}" />
												<form:option value="separado" label="${variable4}" />
												<form:option value="divorciado" label="${variable5}" />
												<form:option value="viudo" label="${variable6}" />
											</form:select>
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi5"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="estadoCivil"></form:errors>
									</div>
								</div>




								<!-- --------- -->
								
								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.familyburdens" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<spring:message code="label.yes" var="variable1" />
											<spring:message code="label.no" var="variable2" />
											<form:select path="cargas">
												<form:option value="si-cargas" label="${variable1}" />
												<form:option value="no-cargas" label="${variable2}" />
											</form:select>
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi6"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="cargas"></form:errors>
									</div>
								</div>




								<!-- --------- -->
								
								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.querytitle" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<i class="fa fa-pencil"></i>
											<form:input type="text" value="" path="titulo" />
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi7"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="titulo"></form:errors>
									</div>
								</div>




								<!-- --------- -->
								
								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.comments" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<form:textarea path="comentarios" rows="4"/>
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi8"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="comentarios"></form:errors>
									</div>
								</div>




								<!-- --------- -->
								
								<!-- --------- -->

								<div class="row">
									<div class="section-field col-md-6">
										<label for="name"><spring:message
												code="label.contractlink" />:</label>
									</div>
								</div>
								<div class="row">
									<div class="section-field col-md-6">
										<div class="field-widget">
											<i class="fa fa-link"></i>
											<form:input type="text" value="" path="url" />
										</div>
									</div>
									<div class="section-field col-md-6">
										<span class="tooltip-content text-blue"
											data-original-title="<spring:message code="label.qi9"/>"
											data-toggle="tooltip" data-placement="top"><i
											class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
									</div>
								</div>

								<div class="row">
									<div class="section-field col-md-6">
										<form:errors style="color: red;" path="url"></form:errors>
									</div>
								</div>
								
								<a class="button mt-20" id="submitservices"
											onclick="document.getElementById('servicesform').submit()">
											<span><spring:message code="label.sendquery" /></span> <i
											class="fa fa-paper-plane"></i>
										</a>
										<!-- En caso de que algún usuario tenga desactivado javascript, saldrá este mensaje por defecto. -->
										<noscript>
											<input type="submit"
												value="<spring:message code="label.sendquery"/>" />
										</noscript>
							</div>
					
				</form:form>
			</div>
	</div>
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