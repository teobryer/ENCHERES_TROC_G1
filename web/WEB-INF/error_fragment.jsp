<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Téo
  Date: 05/05/2021
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <div  class="toast" data-delay="5000" style="position: absolute; width: 300px; bottom: 5px; right: 10px;">
        <div class="toast-header">
            <img src="<c:url value="/img/attention.ico" />" class="rounded mr-2" alt="...">
            <strong id="title" class="mr-auto">Bootstrap</strong>

            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div id="text" class="toast-body">

        </div>
    </div>

<script>
function notifier(text, title){
    $('#text').text(text);
    $('#title').text(title);
    $('.toast').toast('show');
}

</script>



