document.getElementById("contactForm").addEventListener("submit", function (e) {
    e.preventDefault(); // prevent form from reloading the page
  
    // get values from the form
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const message = document.getElementById("message").value;
  
    // send POST request to backend
    fetch("/api/contact", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ name, email, message })
    })
      .then(response => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.text(); // or .json() depending on your backend
      })
      .then(data => {
        alert("Message sent successfully!");
        // optionally clear form
        document.getElementById("contactForm").reset();
      })
      .catch(error => {
        alert("There was a problem submitting the form: " + error.message);
      });
  });
  