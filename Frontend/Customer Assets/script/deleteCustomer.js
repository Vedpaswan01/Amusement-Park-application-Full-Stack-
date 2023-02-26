let removeCustomer = async () => {

    let customerId = document.querySelector("#customerId").value;
   
   
    let res = await fetch(`http://localhost:8888/customer/deleteCustomerById/${customerId}`, {
      method: "DELETE",

      headers: {
        "Content-Type": "application/json",
      },
    })
  
   
    alert("Customer deleted successfully with the Id " +customerId )
    window.location.href = "index.html";
    return res;
    
  };