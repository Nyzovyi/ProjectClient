<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<h1 style="padding-left: 453px;">CLIENT BASE</h1>
<security:authorize access="!isAuthenticated()">



<div class="row-fluid">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="collapse navbar-collapse" id="">
							<ul class="nav navbar-nav">
								<li><a href="/registration">Register</a></li>
								<li><a href="/admin">Home</a></li>
							</ul>
						</div>
					</div>
				</nav>
</div>


</security:authorize>
<security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">

</security:authorize>


<script>
	this.name();
	
	var a = {};
	
	function name() {
		alert("Hello")
	}
</script>

<script>
	function show() {
		if (trigger) {
			var trigger = true;
			trigger = false;
			alert("Hi")
			
		}
	}
	
	function trigger(trigger){
		
	}

</script>



