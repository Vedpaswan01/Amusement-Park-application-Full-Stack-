document.querySelector("form").addEventListener("submit",insertActivity)


 function insertActivity(){



   let desc=document.getElementById("Description").value
   let charge = document.getElementById("charge").value
   


   let obj={};
   obj["description"] = desc
   obj["charge"]= charge

 
    
   insertAct(obj)


}

async function insertAct(obj){

    
   console.log(obj);

    try {

        let res = await fetch(`http://localhost:8888/insertActivity`, {
            method: "POST",
            body:JSON.stringify(obj),
            headers: {
                "Content-Type": "application/json"
            }
            
        })
        console.log(res)
        if (res.ok) {
            console.log("sucesss !")
            let data = await res.json();

        
            let d = JSON.stringify(data)


            console.log(d);
            alert("Activity Inserted !")
            

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("Activity Inserted !")
      

    }


}
