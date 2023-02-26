let updateOperator = async () => {



    let AdminID =document.getElementById("adminId").value
    let name =document.getElementById("username").value
    let email = document.getElementById("email").value
    let password = document.getElementById("password").value
    let mobile = document.getElementById("mobile").value
    let address = document.getElementById("Address").value

    localStorage.setItem("email", email);

    console.log(name);





    let obj={};
    obj["adminID"] = AdminID
    obj["username"] = name
    obj["email"]= email
    obj["password"]=password
    obj["address"]=address
    obj["mobileNumber"]=mobile
    
  
    try {

        let res = await fetch(`http://localhost:8888/updateadmins`, {
            method: "PUT",
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
            alert("Admin updated successfully")

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("Admin updated successfully")
       

    }
  
  
  };
  
  