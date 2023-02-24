async function findAllCustomer() {

  try {
    let res = await fetch(`http://localhost:8888/allCustomer`, {
      method: "GET",
    
      headers: {
        "Content-Type": "application/json",
      },
      // body:JSON.stringify(obj)
    });
    console.log(res);
    if (res.ok) {
      console.log("sucesss");
      let data = await res.json();

      // To get data from response   // user data
      // let userData=JSON.stringify(data)
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
    // alert("Connection failed");
  }
}

window.onload(findAllCustomer())

function appendData(data) {
  data.map(function (el) {
    
    let tr = document.createElement("tr");

    // creating td to append tr
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

    // appending td to tr
    tr.append(opid,opratorName,email,mobile,address,pass);

    //appending tr to tbody
    document.querySelector("#tbody").append(tr);


  });
}
