let TicketDelete = async () => {
  let ticketId = document.querySelector("#ticketId").value;

  let res = await fetch(
    `http://localhost:8888/ticketBooking/deleteTicket/${ticketId}`,
    {
      method: "DELETE",

      headers: {
        "Content-Type": "application/json",
      },
    }
  );

  alert("Activity deleted successfuly with the Id " + ticketId);
  return res;
};
