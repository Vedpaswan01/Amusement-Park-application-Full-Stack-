let removeCustomer = async () => {

    let customerId = document.querySelector("#customerId").value;
   
   
    let res = await fetch(`http://localhost:8888/deleteCustomer/${customerId}`, {
      method: "DELETE",

      headers: {
        "Content-Type": "application/json",
      },
    })
  
   
    alert("Customer deleted successfuly with the Id " +customerId )
    return res;
  
  };
  
  