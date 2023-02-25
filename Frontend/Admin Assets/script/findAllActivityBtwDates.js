 async function findactivityByCustomerId() {

    let cid = document.querySelector("#cid").value;
    let from_date = document.querySelector("#from_date").value;
    let to_date = document.querySelector("#to_date").value;
 

  try {

      let res = await fetch(`http://localhost:8888/getActivitybyDateAndCustomerid/${cid}/${from_date}/${to_date}`, {
          method: "GET",
         
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
          appendData(data)

      } else {

          let data = await res.json();
          let error = JSON.stringify(data)

          let msg = JSON.parse(error);

          console.log(msg)
          alert(msg.message)
      }

  } catch (error) {
      console.log(error)
      alert("Connection failed")
     

  }


}


function appendData(data) {
  data.map(function (ac) {
    
    let tr = document.createElement("tr");

   
    let activityid = document.createElement("td");
    activityid.innerText = ac.activityId;

    let  ActivityNAme = document.createElement("td");
    ActivityNAme.innerText =ac.description;

    let charge = document.createElement("td");
    charge.innerText = ac.charge;


    
    tr.append(activityid,ActivityNAme,charge);

   
    document.querySelector("#tbody").append(tr);


  });



}
