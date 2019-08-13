
var user_id;

var btn_delete = document.getElementById("deleteUser");
btn_delete.addEventListener("click", function () {
    $.ajax({
        type: 'GET',
        url: "/admin/gerir/utilizador/deletar/" + user_id,
        success: function (data) {
            $("#" + user_id).remove("tr");
            $("#deleteModal").modal('hide');
        }
    }
    );

});

function modalRemover(id) {

    $("#modal-deletar-user-id").val(id); //set id value to input hidden into modal
    $("#deleteModal").modal('show');
    user_id = id;
}

function openModalUpdate(id) {

    var Id = parseInt(id);

    $.ajax({
        type: 'GET',
        url: "/admin/gerir/utilizador/" + Id,
        success: function (data) {
            console.log(data)
        }

    })

    $("#updateModal").modal('show');
}
