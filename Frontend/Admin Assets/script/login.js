


document.querySelector("form").addEventListener("submit", adminLogin);

async function adminLogin(e) {
  e.preventDefault();
  console.log("working");

  let Email = document.getElementById("Email").value;
  let Password = document.getElementById("password").value;

  const loginData = {
    email: Email,
    password: Password,
   
  };

  try {
    const sessionKey = await userSignUpFun(loginData);
    localStorage.setItem('sessionKey', sessionKey);
    console.log(sessionKey);
    alert("Login successfuly !");
    window.location.href = "./adminDashboard.html";
  } catch (error) {
    console.error(error);
    alert("Error: " + error.message);
  }

}

let userSignUpFun = async (obj) => {

  try {
    const res = await fetch("http://localhost:8888/login/adminLogin", {
      method: "POST",
      body: JSON.stringify(obj),
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (res.ok) {
      console.log("success");
      const data = await res.json();
      return data
      

    } else {

      const data = await res.json();
      const error = JSON.stringify(data);
      const msg = JSON.parse(error);
      console.log(msg);
      throw new Error(msg.message);

    }
  } catch (error) {
    console.log(error);
    throw new Error(error);
  }

};
