 async function findactivityByCustomerId() {

  let cid = document.querySelector("#cusId").value;
  console.log(cid)

  try {

      let res = await fetch(`http://localhost:8888/getAllactivitybycustomerid/${cid}`, {
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


    // appending td to tr
    tr.append(activityid,ActivityNAme,charge);

    //appending tr to tbody
    document.querySelector("#tbody").append(tr);


  });



}
