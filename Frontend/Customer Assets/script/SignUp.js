document.querySelector("form").addEventListener("submit",adminSignup)


 function adminSignup(event){

    event.preventDefault();
   // console.log("working")

    let name =document.getElementById("name").value
    let email = document.getElementById("email").value
    let password = document.getElementById("password").value
    let mobile = document.getElementById("mobile").value
    let address = document.getElementById("address").value

    console.log(name);

    let obj={};

    obj["username"]=name
    obj["email"]= email
    obj["password"]=password
    obj["address"]=address
    obj["mobileNumber"]=mobile
    console.log(obj);
    userSignUpFun(obj)

}

async function userSignUpFun(obj){

    try {

        let res = await fetch(`http://localhost:8888/customer/registerCustomer`, {
            method: "POST",
            body:JSON.stringify(obj),
            headers: {
                "Content-Type": "application/json"
            }
            // body:JSON.stringify(obj)
        })
        console.log(res)
        if (res.ok) {
            console.log("sucesss")
            let data = await res.json();

            // To get data from response   // user data
            // let userData=JSON.stringify(data)
            let d = JSON.stringify(data)


            console.log(d);
            alert("Customer created successfully!")
            

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("Customer created successfully!")
       

    }

    window.location.href = "./Login.html";

}

