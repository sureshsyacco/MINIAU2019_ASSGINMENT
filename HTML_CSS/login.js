// Name and Password from the register-form
var uname = document.getElementById('username');
var pass_word = document.getElementById('password');

// storing input from register-form
function register() {
    localStorage.setItem('name', uname.value);
    localStorage.setItem('pass_word', pass_word.value);
}

// check if stored data from register-form is equal to entered data in the   login-form
function verify() {

    // stored data from the register-form
    var storedName = localStorage.getItem('name');
    var storedPw = localStorage.getItem('pass_word');

    // entered data from the login-form
    var userName = document.getElementById('username1');
    var userPw = document.getElementById('password1');
    // check if stored data from register-form is equal to data from login form
    if(userName.value == storedName && userPw.value == storedPw) {
        alert('You are loged in.');
    }else {
        alert('ERROR.');
    }
}