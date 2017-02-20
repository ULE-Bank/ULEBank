<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="description" content="Cálculo de TAE.">
<meta name="keywords"
	content="ULe-Bank, calculos, tae, tasa, anual, equivalente">
<meta name="author" content="Alexis Gutiérrez & Camino Fernández">
<meta name="robots" content="index,follow">

<link rel="alternate" hreflang="es" href="http://ule-bank.appspot.com/" />

<link rel="shortcut icon" type="image/x-icon"
	href="/resources/img/favicon.ico" />

<link rel="stylesheet" href="/resources/services/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/resources/services/css/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/resources/services/css/styles-responsive.css">

<script src="/resources/services/js/jquery.min.js"></script>
<script src="/resources/services/js/bootstrap.min.js"></script>

<script src="/resources/services/js/jquery-cookie.js"></script>

<script src="/resources/services/js/script.js"></script>

<!-- Favicon -->
<link rel="shortcut icon" href="images/favicon.ico" />

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

<title><spring:message code="label.siteservice1" /></title>

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
		
			<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<!--=================================
 inner-intro-->

<section class="inner-intro grayscale bg-2 bg-opacity-black-70">
  <div class="container">
     <div class="row text-center intro-title">
            <h1 class="text-blue"><spring:message code="label.siteservice1"/></h1>
            <p class="text-white"><spring:message code="label.siteservice1description"/></p>
            <ul class="page-breadcrumb">
              <li><a href="./"><i class="fa fa-home"></i> <spring:message code="label.sitehome"/></a> <i class="fa fa-angle-double-right"></i></li>
              <li><a href="./#services"><spring:message code="label.siteservices"/></a> <i class="fa fa-angle-double-right"></i></li>
              <li><span><spring:message code="label.siteservice1" /></span> </li>
           </ul>
     </div>
  </div>
</section>

<!--=================================
 inner-intro-->

			<main class="general-class">

			<div class="container">

				<div class="global-header"></div>

				<ol class="breadcrumb">
					<li><a href="/">Inicio</a></li>
				</ol>

				<div class="page-header">
					<h1>Cálculo de TAE</h1>
				</div>

				<form:form role="form" method="post" modelAttribute="tae">
					<div class="row">
						<div class="col-md-4">
							<label for="i">Tipo de interés:</label> <span
								class="fa fa-info pull-right hidden-md hidden-lg"
								data-toggle="tooltip" data-placement="left"
								title="Interés nominal anual. Mayor o igual que 0."></span>
							<div class="input-group">
								<form:input class="form-control" path="i" />
								<span class="input-group-addon"><i class="fa fa-percent"
									aria-hidden="true"></i></span>
							</div>
							<form:errors path="i"></form:errors>
						</div>
						<span class="fa fa-info input-info hidden-sm hidden-xs"
							data-toggle="tooltip" data-placement="right"
							title="Interés nominal anual. Mayor o igual que 0."></span>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4">
							<label for="p">Tipo de periodo:</label> <span
								class="fa fa-info pull-right hidden-md hidden-lg"
								data-toggle="tooltip" data-placement="left"
								title="Número de pagos en el año."></span>
							<form:select class="form-control" path="p">
								<form:option value="1" label="1 - anual" />
								<form:option value="2" label="2 - semestral" />
								<form:option value="3" label="3 - cuatrimestral" />
								<form:option value="4" label="4 - trimestral" />
								<form:option value="6" label="6 - bimensual" />
								<form:option value="12" label="12 - mensual" />
							</form:select>
						</div>
						<span class="fa fa-info input-info hidden-sm hidden-xs"
							data-toggle="tooltip" data-placement="right"
							title="Número de pagos en el año."></span>
					</div>
					<br>
					<input type="submit" class="btn btn-default" value="Calcular">
					
					
					############################
					<section class="register-2 page-section-ptb">
					<div class="container">
    <div class="row">
      <div class="col-md-8 col-md-offset-2">
        <div id="register-form" class="register-form">
           <div class="row">
           <div class="section-field col-md-6">
             <label for="name"><spring:message code="label.typeofinterest"/></label>
             </div>
             </div>
             <div class="row">
           <div class="section-field col-md-6">
              <div class="field-widget">
                <i class="fa fa-percent"></i>
                <input  type="text" placeholder="0.0" name="name">
              </div>  
            </div> 
			<span class="tooltip-content text-blue" data-original-title="<spring:message code="label.typeofinterestinfo"/>" 
				data-toggle="tooltip" data-placement="top"><i class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
            </div>
            <div class="row">
            <div class="section-field col-md-6">
             <label for="name"><spring:message code="label.typeofperiod"/></label>
             </div>
             </div>
             <div class="field-widget">
              <i class="fa fa-pencil"></i>
              <form:select path="p">
								<form:option value="1" label="1 - anual" />
								<form:option value="2" label="2 - semestral" />
								<form:option value="3" label="3 - cuatrimestral" />
								<form:option value="4" label="4 - trimestral" />
								<form:option value="6" label="6 - bimensual" />
								<form:option value="12" label="12 - mensual" />
			 </form:select>
              </div>
             </div>
            </div>
    </section>
					
					<!--=================================
 Register-->

<section class="white-bg page-section-ptb">
  <div class="container">
    <div class="row">
      <div class="col-md-8 col-md-offset-2">
        <div id="register-form" class="register-form">
           <div class="row">
           <div class="section-field col-md-6">
             <label for="name"><spring:message code="label.typeofinterest"/></label>
              </div>  
            </div>
           <div class="row">
           <div class="section-field col-md-6">
              <div class="field-widget">
                <i class="fa fa-percent"></i>
                <input  type="text" placeholder="0.0" name="name">
              </div>  
            </div> 
            <div class="section-field col-md-6">
            <span class="tooltip-content text-blue" data-original-title="<spring:message code="label.typeofinterestinfo"/>" 
			data-toggle="tooltip" data-placement="top"><i class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
            </div> 
            </div>
            <div class="row">
            <div class="section-field col-md-6">
             <label for="name"><spring:message code="label.typeofperiod"/></label>
            </div>
            </div>
            <div class="row">
            <div class="section-field col-md-6">
             <div class="field-widget">
             <spring:message code="label.annual" var="variable1"/>
             <spring:message code="label.biannual" var="variable2"/>
             <spring:message code="label.cuatrimestral" var="variable3"/>
             <spring:message code="label.quarterly" var="variable4"/>
             <spring:message code="label.bimonthly" var="variable5"/>
             <spring:message code="label.monthly" var="variable6"/>
              		<form:select path="p">
								<form:option value="1" label="1 - ${variable1} " />
								<form:option value="2" label="2 - ${variable2}" />
								<form:option value="3" label="3 - ${variable3}" />
								<form:option value="4" label="4 - ${variable4}" />
								<form:option value="6" label="6 - ${variable5}" />
								<form:option value="12" label="12 - ${variable6}" />
					</form:select>
              </div>
             </div>
             <div class="section-field col-md-6">
            <span class="tooltip-content text-blue" data-original-title="<spring:message code="label.typeofperiodinfo"/>" 
			data-toggle="tooltip" data-placement="top"><i class="fa fa-question-circle fa-2x" aria-hidden="true"></i></span>
            </div>
            </div>
           
           <div class="section-field">
             <label for="name">User name* </label>
              <div class="field-widget">
               <i class="fa fa-user"></i>
               <input  class="web" type="text" placeholder="Choose your user name" name="web">
              </div> 
            </div>
            <div class="section-field">
             <label for="Password">Password* </label>
              <div class="field-widget">
               <i class="fa fa-unlock-alt"></i>
               <input class="Password" type="password" placeholder="Password" name="Password">
              </div> 
            </div>
            <div class="section-field">
             <label for="Password">Re-enter Password*</label>
              <div class="field-widget">
               <i class="fa fa-unlock-alt"></i>
               <input class="Password" type="password" placeholder="Password" name="Password">
              </div> 
            </div>
            <div class="section-field">
             <label for="email">Email *</label>
              <div class="field-widget">
               <i class="fa fa-envelope"></i>
               <input  class="email" type="text" placeholder="Enter your email" name="email">
              </div> 
            </div>
            <div class="section-field">
             <label for="phone">Mobile phone *</label>
              <div class="field-widget">
               <i class="fa fa-mobile"></i>
               <input id="phone" class="phone" type="text" placeholder="Enter your mobile no" name="phone">
              </div> 
            </div>
            <label for="phone">Your birthday *</label>
            <div class="row">
             <div class="section-field col-xs-4 col-md-4">
                <div class="field-widget">
                    <select>
                        <option value="Day">Day</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>  
                        <option value="17">17</option>  
                        <option value="18">18</option>  
                        <option value="19">19</option>  
                        <option value="20">20</option>  
                        <option value="21">21</option>  
                        <option value="22">22</option>  
                        <option value="23">23</option>  
                        <option value="24">24</option>  
                        <option value="25">25</option>  
                        <option value="26">26</option>  
                        <option value="27">27</option>  
                        <option value="28">28</option>  
                        <option value="29">29</option>  
                        <option value="30">30</option>  
                        <option value="31">31</option>  
                    </select>
                 </div>
                </div>
                <div class="section-field col-xs-4 col-md-4">
                 <div class="field-widget">
                    <select>
                        <option value="Month">Month</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                 </div>
                </div>
                <div class="section-field col-xs-4 col-md-4">
                  <div class="field-widget">
                    <select>
                        <option value="Year">Year</option>
                        <option value="1990">1990</option>
                        <option value="1991">1991</option>
                        <option value="1992">1992</option>
                        <option value="1993">1993</option>
                        <option value="1994">1994</option>
                        <option value="1995">1995</option>
                        <option value="1996">1996</option>
                        <option value="1997">1997</option>
                        <option value="1998">1998</option>
                        <option value="1999">1999</option>
                        <option value="2001">2001</option>
                        <option value="2002">2002</option>
                        <option value="2003">2003</option>
                        <option value="2004">2004</option>
                        <option value="2005">2005</option>
                        <option value="2006">2006</option>
                        <option value="2007">2007</option>
                        <option value="2008">2008</option>
                        <option value="2009">2009</option>
                        <option value="2010">2010</option>
                        <option value="2011">2011</option>
                        <option value="2012">2012</option>
                        <option value="2013">2013</option>
                        <option value="2014">2014</option>
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                    </select>
                  </div>
                 </div>
                </div>
                <div class="section-field">
                 <label for="phone">Select Country *</label>
                  <div class="field-widget">
                    <select>
                        <option value="Country">Select Country...</option>
                        <option value="AF">Afghanistan</option>
                        <option value="AL">Albania</option>
                        <option value="DZ">Algeria</option>
                        <option value="AS">American Samoa</option>
                        <option value="AD">Andorra</option>
                        <option value="AG">Angola</option>
                        <option value="AI">Anguilla</option>
                        <option value="AG">Antigua &amp; Barbuda</option>
                        <option value="AR">Argentina</option>
                        <option value="AA">Armenia</option>
                        <option value="AW">Aruba</option>
                        <option value="AU">Australia</option>
                        <option value="AT">Austria</option>
                        <option value="AZ">Azerbaijan</option>
                        <option value="BS">Bahamas</option>
                        <option value="BH">Bahrain</option>
                        <option value="BD">Bangladesh</option>
                        <option value="BB">Barbados</option>
                        <option value="BY">Belarus</option>
                        <option value="BE">Belgium</option>
                        <option value="BZ">Belize</option>
                        <option value="BJ">Benin</option>
                        <option value="BM">Bermuda</option>
                        <option value="BT">Bhutan</option>
                        <option value="BO">Bolivia</option>
                        <option value="BL">Bonaire</option>
                        <option value="BA">Bosnia &amp; Herzegovina</option>
                        <option value="BW">Botswana</option>
                        <option value="BR">Brazil</option>
                        <option value="BC">British Indian Ocean Ter</option>
                        <option value="BN">Brunei</option>
                        <option value="BG">Bulgaria</option>
                        <option value="BF">Burkina Faso</option>
                        <option value="BI">Burundi</option>
                        <option value="KH">Cambodia</option>
                        <option value="CM">Cameroon</option>
                        <option value="CA">Canada</option>
                        <option value="IC">Canary Islands</option>
                        <option value="CV">Cape Verde</option>
                        <option value="KY">Cayman Islands</option>
                        <option value="CF">Central African Republic</option>
                        <option value="TD">Chad</option>
                        <option value="CD">Channel Islands</option>
                        <option value="CL">Chile</option>
                        <option value="CN">China</option>
                        <option value="CI">Christmas Island</option>
                        <option value="CS">Cocos Island</option>
                        <option value="CO">Colombia</option>
                        <option value="CC">Comoros</option>
                        <option value="CG">Congo</option>
                        <option value="CK">Cook Islands</option>
                        <option value="CR">Costa Rica</option>
                        <option value="CT">Cote D'Ivoire</option>
                        <option value="HR">Croatia</option>
                        <option value="CU">Cuba</option>
                        <option value="CB">Curacao</option>
                        <option value="CY">Cyprus</option>
                        <option value="CZ">Czech Republic</option>
                        <option value="DK">Denmark</option>
                        <option value="DJ">Djibouti</option>
                        <option value="DM">Dominica</option>
                        <option value="DO">Dominican Republic</option>
                        <option value="TM">East Timor</option>
                        <option value="EC">Ecuador</option>
                        <option value="EG">Egypt</option>
                        <option value="SV">El Salvador</option>
                        <option value="GQ">Equatorial Guinea</option>
                        <option value="ER">Eritrea</option>
                        <option value="EE">Estonia</option>
                        <option value="ET">Ethiopia</option>
                        <option value="FA">Falkland Islands</option>
                        <option value="FO">Faroe Islands</option>
                        <option value="FJ">Fiji</option>
                        <option value="FI">Finland</option>
                        <option value="FR">France</option>
                        <option value="GF">French Guiana</option>
                        <option value="PF">French Polynesia</option>
                        <option value="FS">French Southern Ter</option>
                        <option value="GA">Gabon</option>
                        <option value="GM">Gambia</option>
                        <option value="GE">Georgia</option>
                        <option value="DE">Germany</option>
                        <option value="GH">Ghana</option>
                        <option value="GI">Gibraltar</option>
                        <option value="GB">Great Britain</option>
                        <option value="GR">Greece</option>
                        <option value="GL">Greenland</option>
                        <option value="GD">Grenada</option>
                        <option value="GP">Guadeloupe</option>
                        <option value="GU">Guam</option>
                        <option value="GT">Guatemala</option>
                        <option value="GN">Guinea</option>
                        <option value="GY">Guyana</option>
                        <option value="HT">Haiti</option>
                        <option value="HW">Hawaii</option>
                        <option value="HN">Honduras</option>
                        <option value="HK">Hong Kong</option>
                        <option value="HU">Hungary</option>
                        <option value="IS">Iceland</option>
                        <option value="IN">India</option>
                        <option value="ID">Indonesia</option>
                        <option value="IA">Iran</option>
                        <option value="IQ">Iraq</option>
                        <option value="IR">Ireland</option>
                        <option value="IM">Isle of Man</option>
                        <option value="IL">Israel</option>
                        <option value="IT">Italy</option>
                        <option value="JM">Jamaica</option>
                        <option value="JP">Japan</option>
                        <option value="JO">Jordan</option>
                        <option value="KZ">Kazakhstan</option>
                        <option value="KE">Kenya</option>
                        <option value="KI">Kiribati</option>
                        <option value="NK">Korea North</option>
                        <option value="KS">Korea South</option>
                        <option value="KW">Kuwait</option>
                        <option value="KG">Kyrgyzstan</option>
                        <option value="LA">Laos</option>
                        <option value="LV">Latvia</option>
                        <option value="LB">Lebanon</option>
                        <option value="LS">Lesotho</option>
                        <option value="LR">Liberia</option>
                        <option value="LY">Libya</option>
                        <option value="LI">Liechtenstein</option>
                        <option value="LT">Lithuania</option>
                        <option value="LU">Luxembourg</option>
                        <option value="MO">Macau</option>
                        <option value="MK">Macedonia</option>
                        <option value="MG">Madagascar</option>
                        <option value="MY">Malaysia</option>
                        <option value="MW">Malawi</option>
                        <option value="MV">Maldives</option>
                        <option value="ML">Mali</option>
                        <option value="MT">Malta</option>
                        <option value="MH">Marshall Islands</option>
                        <option value="MQ">Martinique</option>
                        <option value="MR">Mauritania</option>
                        <option value="MU">Mauritius</option>
                        <option value="ME">Mayotte</option>
                        <option value="MX">Mexico</option>
                        <option value="MI">Midway Islands</option>
                        <option value="MD">Moldova</option>
                        <option value="MC">Monaco</option>
                        <option value="MN">Mongolia</option>
                        <option value="MS">Montserrat</option>
                        <option value="MA">Morocco</option>
                        <option value="MZ">Mozambique</option>
                        <option value="MM">Myanmar</option>
                        <option value="NA">Nambia</option>
                        <option value="NU">Nauru</option>
                        <option value="NP">Nepal</option>
                        <option value="AN">Netherland Antilles</option>
                        <option value="NL">Netherlands (Holland, Europe)</option>
                        <option value="NV">Nevis</option>
                        <option value="NC">New Caledonia</option>
                        <option value="NZ">New Zealand</option>
                        <option value="NI">Nicaragua</option>
                        <option value="NE">Niger</option>
                        <option value="NG">Nigeria</option>
                        <option value="NW">Niue</option>
                        <option value="NF">Norfolk Island</option>
                        <option value="NO">Norway</option>
                        <option value="OM">Oman</option>
                        <option value="PK">Pakistan</option>
                        <option value="PW">Palau Island</option>
                        <option value="PS">Palestine</option>
                        <option value="PA">Panama</option>
                        <option value="PG">Papua New Guinea</option>
                        <option value="PY">Paraguay</option>
                        <option value="PE">Peru</option>
                        <option value="PH">Philippines</option>
                        <option value="PO">Pitcairn Island</option>
                        <option value="PL">Poland</option>
                        <option value="PT">Portugal</option>
                        <option value="PR">Puerto Rico</option>
                        <option value="QA">Qatar</option>
                        <option value="ME">Republic of Montenegro</option>
                        <option value="RS">Republic of Serbia</option>
                        <option value="RE">Reunion</option>
                        <option value="RO">Romania</option>
                        <option value="RU">Russia</option>
                        <option value="RW">Rwanda</option>
                        <option value="NT">St Barthelemy</option>
                        <option value="EU">St Eustatius</option>
                        <option value="HE">St Helena</option>
                        <option value="KN">St Kitts-Nevis</option>
                        <option value="LC">St Lucia</option>
                        <option value="MB">St Maarten</option>
                        <option value="PM">St Pierre &amp; Miquelon</option>
                        <option value="VC">St Vincent &amp; Grenadines</option>
                        <option value="SP">Saipan</option>
                        <option value="SO">Samoa</option>
                        <option value="AS">Samoa American</option>
                        <option value="SM">San Marino</option>
                        <option value="ST">Sao Tome &amp; Principe</option>
                        <option value="SA">Saudi Arabia</option>
                        <option value="SN">Senegal</option>
                        <option value="RS">Serbia</option>
                        <option value="SC">Seychelles</option>
                        <option value="SL">Sierra Leone</option>
                        <option value="SG">Singapore</option>
                        <option value="SK">Slovakia</option>
                        <option value="SI">Slovenia</option>
                        <option value="SB">Solomon Islands</option>
                        <option value="OI">Somalia</option>
                        <option value="ZA">South Africa</option>
                        <option value="ES">Spain</option>
                        <option value="LK">Sri Lanka</option>
                        <option value="SD">Sudan</option>
                        <option value="SR">Suriname</option>
                        <option value="SZ">Swaziland</option>
                        <option value="SE">Sweden</option>
                        <option value="CH">Switzerland</option>
                        <option value="SY">Syria</option>
                        <option value="TA">Tahiti</option>
                        <option value="TW">Taiwan</option>
                        <option value="TJ">Tajikistan</option>
                        <option value="TZ">Tanzania</option>
                        <option value="TH">Thailand</option>
                        <option value="TG">Togo</option>
                        <option value="TK">Tokelau</option>
                        <option value="TO">Tonga</option>
                        <option value="TT">Trinidad &amp; Tobago</option>
                        <option value="TN">Tunisia</option>
                        <option value="TR">Turkey</option>
                        <option value="TU">Turkmenistan</option>
                        <option value="TC">Turks &amp; Caicos Is</option>
                        <option value="TV">Tuvalu</option>
                        <option value="UG">Uganda</option>
                        <option value="UA">Ukraine</option>
                        <option value="AE">United Arab Emirates</option>
                        <option value="GB">United Kingdom</option>
                        <option value="US">United States of America</option>
                        <option value="UY">Uruguay</option>
                        <option value="UZ">Uzbekistan</option>
                        <option value="VU">Vanuatu</option>
                        <option value="VS">Vatican City State</option>
                        <option value="VE">Venezuela</option>
                        <option value="VN">Vietnam</option>
                        <option value="VB">Virgin Islands (Brit)</option>
                        <option value="VA">Virgin Islands (USA)</option>
                        <option value="WK">Wake Island</option>
                        <option value="WF">Wallis &amp; Futana Is</option>
                        <option value="YE">Yemen</option>
                        <option value="ZR">Zaire</option>
                        <option value="ZM">Zambia</option>
                        <option value="ZW">Zimbabwe</option>
                    </select>
                 </div>
                </div>
                <div class="section-field">
                 <label for="phone">Gender *</label>
                  <div class="field-widget">
                    <select>
                        <option value="">I am</option>
                        <option value="male">male</option>
                        <option value="female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                 </div>
                </div>
                <div class="section-field">
                 <label for="email">Please enter an answer in digits:</label>
                  <div class="field-widget">
                   <input  class="email gui-input" type="text" placeholder="" name="email">
                   <label class="button" for="verify">5 + Two</label>
                  </div> 
                </div>
                 <div class="section-field">
                  <div class="remember-checkbox">
                     <input type="checkbox" name="two" id="two" />
                      <label for="two">Accept our <a href="#"> privacy policy</a> and <a href="#"> customer agreement</a></label>
                     </div>
                     </div>
               </div>
              <a href="#" class="button mt-20">
                <span>Register an account</span>
                <i class="fa fa-check"></i>
             </a>
         </div>
      </div>
    </div>
</section>

<!--=================================
 Register-->
					###############################
				</form:form>

				<br>

				<div class="bg-info">
					<h3>
						<c:out value="${model.resultado}" />
					</h3>
				</div>

				<p class="modal-link last-element">
					<a href="#" data-toggle="modal" data-target="#modalExplicativo">¿Qué
						es la TAE?</a>
				</p>

			</div>
			</main>

			<jsp:include page="/WEB-INF/views/footer.jsp">
				<jsp:param name="lastUpdate" value="7 de Junio de 2016" />
			</jsp:include>

			<!-- Modal -->
			<div class="modal fade" id="modalExplicativo" tabindex="-1"
				role="dialog" aria-labelledby="modalExplicativoLabel">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="modalExplicativoLabel">TAE -
								Tasa Anual Equivalente</h4>
						</div>
						<div class="modal-body">La Tasa Anual Equivalente se utiliza
							para denotar el tipo de interés asociado a una inversión o a un
							crédito.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cerrar</button>
						</div>
					</div>
				</div>
			</div>
			<!-- Fin Modal -->

			<!-- MODAL RESULTADOS -->
			<div class="modal fade" id="modalResultados" tabindex="-1"
				role="dialog" aria-labelledby="modalResultadosLabel">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="modalResultadosLabel">Resultado
								de la simulación</h4>
						</div>
						<div class="modal-body">
							<table class="table">
								<thead>
									<tr>
										<th>Tipo de interés</th>
										<th>Pagos anuales</th>
										<th>Tasa Anual Equivalente (TAE)</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="fila" items="${tabla}">
										<tr>
											<c:forEach var="itemFila" items="${fila}">
												<td><c:out value="${itemFila}" /></td>
											</c:forEach>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- FIN MODAL RESULTADOS -->

	<script src="/resources/services/js/tooltip-script.js"></script>
	<!-- jquery  -->
	<script type="text/javascript"
		src="resources/template/js/jquery.min.js"></script>

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