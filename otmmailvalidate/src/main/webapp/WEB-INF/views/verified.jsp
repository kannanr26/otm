<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<div class="container">
	<c:if test="${status.status==REG_VERIFIED}">
		<div class="alert alert-success " role="alert">
			<strong>${msg}</strong>
			Please Login to <a href="http://localhost:8080\login"></a>
		</div>
	</c:if>
	<c:if test="${status.status==PWD_VERIFIED}">
		<div class="alert alert-success " role="alert">
			<strong>${msg}</strong>
			Please Login to <a href="http://localhost:8080"></a>
		</div>
	</c:if>
	<c:if test="${status.status==EXPIRED}">
		<div class="alert alert-warning " role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	<c:if test="${status.status==expired}">
		<div class="alert alert-danger" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>


</div>

</body>
</html>