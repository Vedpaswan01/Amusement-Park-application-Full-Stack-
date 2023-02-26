let updateticket = async () => {



    let activity_id=document.getElementById("actId").value
    let ticket_id =document.getElementById("tid").value
  
   

  
    try {

        let res = await fetch(`http://localhost:8888/ticketBooking/updateTicket/${ticket_id}/${activity_id}`, {
            method: "PUT",
          
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
            alert("Ticket updated successfuly")

        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
       
       

    }
  
  
  };
  
  