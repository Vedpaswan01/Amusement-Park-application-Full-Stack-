async function findAllActivity() {

  try {
    let res = await fetch(`http://localhost:8888/getallactivity`, {
      method: "GET",
      // body:JSON.stringify(obj),
      headers: {
        "Content-Type": "application/json",
      },
      // body:JSON.stringify(obj)
    });
    console.log(res);
    if (res.ok) {
      console.log("sucesss");
      let data = await res.json();

      // To get data from response   // user data
      // let userData=JSON.stringify(data)
      let d = JSON.stringify(data);

      console.log(d);
      appendData(data);

    } else {
      let data = await res.json();
      let error = JSON.stringify(data);

      let msg = JSON.parse(error);

      console.log(msg);
      alert(msg.message);
    }
  } catch (error) {
    console.log(error);
    // alert("Connection failed");
  }
}

window.onload(findAllActivity())

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
