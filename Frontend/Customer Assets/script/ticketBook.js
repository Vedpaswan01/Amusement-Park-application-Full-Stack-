document.querySelector("form").addEventListener("submit",insertticket)


 function insertticket(){



   let activity_id=document.getElementById("actId").value
   let date=document.getElementById("date").value

 

   


   let obj={};

   obj["dateTime"] = date
  

    
   insertTkt(obj,activity_id)


}

async function  insertTkt(obj ,activity_id){

    
   console.log(activity_id);

    try {

        let res = await fetch(`http://localhost:8888/ticketBooking/${activity_id}`, {
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
        alert(error.message)
      

    }


}
