document.querySelector("#logoutBtn").addEventListener("click", customerLogout);

const sKey= localStorage.getItem("sessionKey")

async function customerLogout() {
  
    console.log("working");
  
  
    try {
      const logindata = await userlogoutUpFun();
    
      alert("Logout successful!");
      window.location.href = "/index.html";
    } catch (error) {
      console.error(error);
      alert("Error: " + error.message);
    }
  
  }
  
  let userlogoutUpFun = async (obj) => {

    const params = new URLSearchParams();
    params.append("key",sKey);
    
  
    try {
      const res = await fetch('http://localhost:8888/login/customerLogout?' + params.toString(), {
        method: "PATCH",
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
  


