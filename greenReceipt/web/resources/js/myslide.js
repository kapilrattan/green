/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 5000); // Change image every 2 seconds
}

function showMessage(){
    alert("Hello");
}


var input = document.querySelector('input[type=file]'); // see Example 4

input.onchange = function () {
  var file = input.files[0];

  upload(file);
  drawOnCanvas(file);   // see Example 6
  displayAsImage(file); // see Example 7
};

function upload(file) {
  var form = new FormData(),
      xhr = new XMLHttpRequest();

  form.append('image', file);
  xhr.open('post', 'server.php', true);
  xhr.send(form);
}