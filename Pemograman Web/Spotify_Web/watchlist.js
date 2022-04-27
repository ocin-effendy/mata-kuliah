$(document).ready(function () {
  printData();$("#content tr")
  $("#search").on("keyup", function () {
    var searchinput = $(this).val().toLowerCase();
    $("#content tr").filter(function () {
      $(this).toggle($(this).text().toLocaleLowerCase().indexOf(searchinput) > -1);
    });
  });
});
  
function printData() {
  var data = localStorage.getItem("data");
 if (data) {
    var arrai = JSON.parse(data);
    $("#content").empty();
    arrai.forEach((e) => {
      $("#content").append('<tr  data-id=' + e.id + "><td>" + e.nameMovie + "</td>\n<td>" + e.ratingMovie + '</td>\n<td><button id="delete" onclick="deleteMovie(this)">Delete</button></td>\n</tr>');
    });
  }
}
  
function addMovie() {
  var data = localStorage.getItem("data");
  if($("#nameMovie").val() != '' && $("#ratingMovie").val() != ''){
    if (data) {
      var arrai = JSON.parse(data);
      var newData = {
        id: arrai.length + 1,
        nameMovie: $("#nameMovie").val(),
        ratingMovie: parseInt($("#ratingMovie").val()),
      };
    } else {
      var arrai = [];
      var newData = {
        id: 1,
        nameMovie: $("#nameMovie").val(),
        ratingMovie: parseInt($("#ratingMovie").val()),
      };
    }
  }else{
    alert('inputan masih kosong')
  }

  arrai.push(newData);
  localStorage.setItem("data", JSON.stringify(arrai));
  printData();
}
  
function deleteMovie(context) {
  $(context).closest("tr").remove();
  var data = localStorage.getItem("data");
  if (data) {
    var arrai = JSON.parse(data);
    var i = 0;
    while (i < arrai.length) {
      if (arrai[i].id == $(context).closest("tr").attr("data-id")) {
        arrai.splice(i, 1);
        break;
      } else i++;
    }
    localStorage.setItem("data", JSON.stringify(arrai));
  }
}
  
function sortMovie(attribut) {
  var data = localStorage.getItem("data");
  if (data) {
    var arrai = JSON.parse(data);
    arrai.sort(function (a, b) {
      return a[attribut] > b[attribut] ? 1 : a[attribut] < b[attribut] ? -1 : 0;
    });
    localStorage.setItem("data", JSON.stringify(arrai));
  }
  printData();
}
