<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="<c:url value="/resources/js/office.js" />"></script>
<title>Oficinas::Delete</title>
</head>
<body class="px-1">
  <h3>Eliminar oficina</h3>

  <c:if test="${error}">
    <div class="alert alert-danger" role="alert">
      <h3>Error:</h3>
      <br>C&oacute;digo: ${errorCode.code} <br>Descripci&oacute;n: ${errorMessage}
    </div>
  </c:if>

  <form method="post" action="<c:url value="/office_delete" />">
    <input type="hidden" value="${office.officeCode}" id="officeCode" name="officeCode">

    <div class="form-group row">
      <label for="city" class="col-sm-2 col-form-label">Ciudad</label>
      <div class="col-sm-4">
        <label class="col-sm-2 col-form-label">${office.city}</label>
      </div>
    </div>

    <div class="form-group row">
      <label for="phone" class="col-sm-2 col-form-label">Tel&eacute;fono</label>
      <div class="col-sm-4">
        <label class="col-sm-2 col-form-label">${office.phone}</label>
      </div>
    </div>

    <div class="form-group row">
      <label for="addressLine1" class="col-sm-2 col-form-label">Direcci&oacute;n 1</label>
      <div class="col-sm-4">
        <label class="col-sm-2 col-form-label">${office.addressLine1}</label>
      </div>
    </div>

    <div class="form-group row">
      <label for="addressLine2" class="col-sm-2 col-form-label">Direcci&oacute;n 2</label>
      <div class="col-sm-4">
        <label class="col-sm-2 col-form-label">${office.addressLine2}</label>
      </div>
    </div>

    <div class="form-group row">
      <label for="state" class="col-sm-2 col-form-label">Estado</label>
      <div class="col-sm-4">
        <label class="col-sm-2 col-form-label">${office.state}</label>
      </div>
    </div>

    <div class="form-group row">
      <label for="country" class="col-sm-2 col-form-label">Pa&iacute;s</label>
      <div class="col-sm-4">
        <label class="col-sm-2 col-form-label">${office.country}</label>
      </div>
    </div>

    <div class="form-group row">
      <label for="postalCode" class="col-sm-2 col-form-label">C&oacute;digo Postal</label>
      <div class="col-sm-4">
        <label class="col-sm-2 col-form-label">${office.postalCode}</label>
      </div>
    </div>

    <div class="form-group row">
      <label for="territory" class="col-sm-2 col-form-label">Territorio</label>
      <div class="col-sm-4">
        <label class="col-sm-2 col-form-label">${office.territory}</label>
      </div>
    </div>

    <br>

    <div class="row">
      <div class="col-sm-2">&nbsp;</div>
      <div class="col-sm-2">
        <a href="./office">
          <button type="button" class="btn btn-outline-danger" aria-label="Left Align">
            <span class="fa fa-undo" aria-hidden="true"></span>Cancelar
          </button>
        </a>
      </div>
      <div class="col-sm-2">
        <button type="submit" class="btn btn-outline-warning">
          <span class="fa fa-edit" aria-hidden="true"></span> Eliminar
        </button>
      </div>
    </div>




  </form>

  <br>
  <br>

  <p>
</body>
</html>