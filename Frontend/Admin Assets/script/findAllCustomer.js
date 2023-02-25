async function findAllCustomer() {

  try {
    let res = await fetch(`http://localhost:8888/allCustomer`, {
      method: "GET",
    
      headers: {
        "Content-Type": "application/json",
      },
   
    });
    console.log(res);
    if (res.ok) {
      console.log("sucesss");
      let data = await res.json();

     
      let d = JSON.stringify(data);

      console.log(d);
      appendData(data);

    } else {
      let data = await res.json();
      let error = JSON.stringify(data);

      let msg = JSON.parse(error);

      console.log(msg);
      alert(msg.message);
    }
  } catch (error) {
    console.log(error);
   
  }
}

window.onload(findAllCustomer())

function appendData(data) {
  data.map(function (el) {
    
    let tr = document.createElement("tr");

   
    let opid = document.createElement("td");
    opid.innerText = el.customerID;

    let opratorName = document.createElement("td");
    opratorName.innerText = el.user_Name;

    let email = document.createElement("td");
    email.innerText = el.email;

    let mobile = document.createElement("td");
    mobile.innerText = el.mobileNumber;

    let address = document.createElement("td");
    address.innerText = el.address;

    let pass = document.createElement("td");
    pass.innerText = el.password;

 
    tr.append(opid,opratorName,email,mobile,address,pass);


    document.querySelector("#tbody").append(tr);


  });
}
