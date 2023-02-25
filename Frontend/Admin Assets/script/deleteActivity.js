let removeAdmin = async () => {

    let activityid = document.querySelector("#activityId").value;
   
  
    let res = await fetch(`http://localhost:8888/deleteActivity/${activityid}`, {
      method: "DELETE",
 
      headers: {
        "Content-Type": "application/json",
      },
    })
  
  
    alert("Activity deleted successfuly with the Id " +activityid)
    return res;
  
  };
  
  