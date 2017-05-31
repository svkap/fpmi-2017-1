function redirectFunc() {
    var search = document.getElementById('search').value;
    var searchEncoded = encodeURIComponent(search);
    console.log(window.location.href);
    window.location.href = location.href + "api/forecast/" + searchEncoded;
}