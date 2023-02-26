let removeAdmin = async () => {

    let adid = document.querySelector("#adminId").value;
   
    console.log(adid);
    let res = await fetch(`http://localhost:8888/deleteadmin/${adid}`, {
      method: "DELETE",
 
      headers: {
        "Content-Type": "application/json",
      },
    })
 
    alert("Admin deleted successfuly with the Id " +adid)
    window.location.href = "index.html";
    return res;
  
  };
  
  