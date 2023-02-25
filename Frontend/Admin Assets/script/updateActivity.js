let updateActivity = async () => {



    let ActivityId =document.getElementById("actId").value
    let desc=document.getElementById("Description").value
    let charge = document.getElementById("charge").value
   

    console.log(name);





    let obj={};
    obj["activityId"] = ActivityId
    obj["description"] = desc
    obj["charge"]= charge
 
    
  
    try {

        let res = await fetch(`http://localhost:8888/updateActivity`, {
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
            alert("Activity updated successfuly")

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("Activity updated successfuly")
       

    }
  
  
  };
  
  