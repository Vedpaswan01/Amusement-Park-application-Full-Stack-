let email = localStorage.getItem("email");
async function dashboard(){


  try {

      let res = await fetch(`http://localhost:8888/customer/getCustomerByEmail/${email}` , {
          method: "GET",
         
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
          appendData(data)

      } else {

          let data = await res.json();
          let error = JSON.stringify(data)

          let msg = JSON.parse(error);

          console.log(msg)
          alert(msg.message)
      }

  } catch (error) {
      console.log(error)
      alert("Connection failed")
     

  }


}
dashboard();

function appendData(dat) {
      
     let user = document.getElementById("user-info");

     let customerID = document.createElement("p");
     customerID.innerText = "Customer ID: " + dat.customerID;
     

     let name = document.createElement("p");
     name.innerText = "Name: " + dat.username;

     let emaill = document.createElement("p");
     emaill.innerText = "Email: " + dat.email;

     let mobile = document.createElement("p");
     mobile.innerText = "Mobile: " + dat.mobileNumber;

     let address = document.createElement("p");
     address.innerText = "Address: " + dat.address;

     user.append(customerID, name, emaill, mobile, address);
  
  
 
  
  
  
  }