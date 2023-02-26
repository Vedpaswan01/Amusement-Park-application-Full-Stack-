document.querySelector("form").addEventListener("submit", customerLogin);

async function customerLogin(e) {
  e.preventDefault();
  console.log("working");

  let Email = document.getElementById("email").value;
  let Password = document.getElementById("password").value;

  localStorage.setItem("email", Email);

  const loginData = {
    email: Email,
    password: Password,
   
  };

  try {
    const logindata = await userSignUpFun(loginData);
    const uuid=logindata.uuid
    localStorage.setItem('sessionKey', uuid);
    console.log(uuid);
    console.log(logindata)
    alert("Login successful!");
   window.location.href = "./customerDashboard.html";
  } catch (error) {
    console.error(error);
    alert("Error: " + error.message);
  }

}

let userSignUpFun = async (obj) => {

  try {
    const res = await fetch("http://localhost:8888/login/customerLogin", {
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