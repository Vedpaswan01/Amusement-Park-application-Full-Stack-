document.querySelector("form").addEventListener("submit",adminSignup)


 function adminSignup(event){

    event.preventDefault();
  

    let name =document.getElementById("username").value
    let email = document.getElementById("email").value
    let password = document.getElementById("password").value
    let mobile = document.getElementById("mobile").value
    let address = document.getElementById("Address").value

    console.log(name);





    let obj={};

    obj["username"] = name
    obj["email"]= email
    obj["password"]=password
    obj["address"]=address
    obj["mobileNumber"]=mobile

    

    console.log(obj);
    userSignUpFun(obj)

}

async function userSignUpFun(obj){

    try {

        let res = await fetch(`http://localhost:8888/registerAdmin`, {
            method: "POST",
            body:JSON.stringify(obj),
            headers: {
                "Content-Type": "application/json"
            }
           
        })
        console.log(res)
        if (res.ok) {
            console.log("sucesss")
            let data = await res.json();

           
            let d = JSON.stringify(data)


            console.log(d);
            alert("admin created successfuly")
            

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("admin created successfuly")
        window.location.href = "/Frontend/Admin Assets/login.html";

    }


}
