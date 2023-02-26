async function calculateBill() {
    try {
      let res = await fetch(`http://localhost:8888/calculateBill`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });
      if (res.ok) {
        let data = await res.json();

        // Update HTML elements with response data
        document.getElementById("customerId").textContent = data.customer.customerID;
        document.getElementById("username").textContent = data.customer.username;
       
        document.getElementById("address").textContent = data.customer.address;
        document.getElementById("mobileNumber").textContent = data.customer.mobileNumber;
        document.getElementById("email").textContent = data.customer.email;

        // Loop through tickets and append to HTML element
        let tickets = data.tickets;
        let ticketsList = document.getElementById("tickets");
        for (let i = 0; i < tickets.length; i++) {
          let ticket = tickets[i];
          let dateTime = ticket.dateTime.join("-");
          let ticketId = ticket.ticketId;
          let li = document.createElement("li");
          li.textContent = `Ticket ID: ${ticketId}, Date/Time: ${dateTime}`;
          ticketsList.appendChild(li);
        }

        // Update total amount HTML element
        document.getElementById("totalAmount").textContent = data.totalAmount;

      } else {
        let data = await res.json();
        let error = JSON.stringify(data);
        let msg = JSON.parse(error);
        alert(msg.message);
    }
} catch (error) {
  console.log(error);
}
}

window.onload(calculateBill())
