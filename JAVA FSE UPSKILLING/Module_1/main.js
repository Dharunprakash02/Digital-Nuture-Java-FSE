console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
    alert("Community Portal Loaded Successfully");
});

const eventName = "Music Festival";
const eventDate = "2026-06-15";
let availableSeats = 100;

console.log(`Event: ${eventName}, Date: ${eventDate}, Seats: ${availableSeats}`);

availableSeats--;

const events = [
    {
        name: "Music Festival",
        category: "Music",
        seats: 50
    },
    {
        name: "Sports Meet",
        category: "Sports",
        seats: 0
    },
    {
        name: "Workshop",
        category: "Education",
        seats: 25
    }
];

events.forEach(event => {
    if (event.seats > 0) {
        console.log(`${event.name} is available`);
    }
});

function registerSeat(eventObj) {
    try {
        if (eventObj.seats <= 0) {
            throw new Error("No seats available");
        }

        eventObj.seats--;
        console.log(`Registered for ${eventObj.name}`);
    }
    catch (error) {
        console.error(error.message);
    }
}

function addEvent(name, category, seats) {
    events.push({
        name,
        category,
        seats
    });
}

function registerUser(eventName) {
    console.log(`User registered for ${eventName}`);
}

function filterEventsByCategory(category, callback) {
    const filtered = events.filter(
        event => event.category === category
    );

    callback(filtered);
}

function registrationCounter() {
    let total = 0;

    return function () {
        total++;
        return total;
    };
}

const countRegistration = registrationCounter();

console.log(countRegistration());
console.log(countRegistration());

class Event {
    constructor(name, date, seats) {
        this.name = name;
        this.date = date;
        this.seats = seats;
    }
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0 ? "Available" : "Full";
};

const musicEvent = new Event(
    "Music Festival",
    "2026-06-15",
    20
);

console.log(musicEvent.checkAvailability());

Object.entries(musicEvent).forEach(([key, value]) => {
    console.log(`${key}: ${value}`);
});

addEvent(
    "Food Carnival",
    "Food",
    40
);

const musicEvents = events.filter(
    event => event.category === "Music"
);

console.log(musicEvents);

const eventCards = events.map(
    event => `Workshop on ${event.name}`
);

console.log(eventCards);

function displayEvents() {

    const container =
        document.querySelector("#eventContainer");

    if (!container) return;

    container.innerHTML = "";

    events.forEach(event => {

        const card =
            document.createElement("div");

        card.className =
            "card p-3 mb-2";

        card.innerHTML = `
            <h5>${event.name}</h5>
            <p>${event.category}</p>
            <p>Seats: ${event.seats}</p>
            <button onclick="registerUser('${event.name}')" class="btn btn-primary">
                Register
            </button>
        `;

        container.appendChild(card);
    });
}

function showFee() {

    const event =
        document.getElementById("event");

    const feeDisplay =
        document.getElementById("fee");

    if (!event || !feeDisplay) return;

    let fee = "";

    if (event.value === "Music") {
        fee = "₹500";
    }
    else if (event.value === "Sports") {
        fee = "₹300";
    }
    else {
        fee = "₹700";
    }

    feeDisplay.innerHTML =
        "Event Fee: " + fee;
}

document.addEventListener(
    "keydown",
    function (event) {
        console.log("Key Pressed:", event.key);
    }
);

function fetchEventsPromise() {

    fetch("https://jsonplaceholder.typicode.com/posts")
        .then(response => response.json())
        .then(data => {
            console.log(data.slice(0, 3));
        })
        .catch(error => {
            console.error(error);
        });
}

async function fetchEventsAsync() {

    try {

        const response =
            await fetch(
                "https://jsonplaceholder.typicode.com/posts"
            );

        const data =
            await response.json();

        console.log(data.slice(0, 3));
    }

    catch (error) {
        console.error(error);
    }
}

const communityEvent = {
    title: "Music Festival",
    location: "Salem",
    seats: 100
};

const {
    title,
    location,
    seats
} = communityEvent;

console.log(title, location, seats);

const copiedEvents = [...events];

console.log(copiedEvents);

const form =
    document.getElementById(
        "registrationForm"
    );

if (form) {

    form.addEventListener(
        "submit",
        function (event) {

            event.preventDefault();

            const name =
                form.elements["name"]?.value;

            const email =
                form.elements["email"]?.value;

            if (!name || !email) {

                alert(
                    "Please fill all fields"
                );

                return;
            }

            document.getElementById(
                "message"
            ).innerHTML =
                "Registration Successful";
        }
    );
}

function submitRegistration() {

    const userData = {

        name: "John",

        email:
            "john@gmail.com"
    };

    setTimeout(() => {

        fetch(
            "https://jsonplaceholder.typicode.com/posts",

            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body:
                    JSON.stringify(userData)
            }
        )

            .then(response =>
                response.json()
            )

            .then(data => {
                console.log(data);
            })

            .catch(error => {
                console.error(error);
            });

    }, 2000);
}

let testVariable = 100;

console.log(testVariable);

function savePreference() {

    const eventType =
        document.getElementById(
            "eventType"
        );

    if (!eventType) return;

    localStorage.setItem(
        "preferredEvent",
        eventType.value
    );
}

function loadPreference() {

    const saved =
        localStorage.getItem(
            "preferredEvent"
        );

    const eventType =
        document.getElementById(
            "eventType"
        );

    if (saved && eventType) {
        eventType.value = saved;
    }
}

function clearPreferences() {

    localStorage.clear();

    sessionStorage.clear();

    alert("Preferences Cleared");
}

function findLocation() {

    if (navigator.geolocation) {

        navigator.geolocation.getCurrentPosition(

            function (position) {

                document.getElementById(
                    "location"
                ).innerHTML =

                    "Latitude: " +
                    position.coords.latitude +

                    "<br>Longitude: " +
                    position.coords.longitude;
            },

            function () {

                alert(
                    "Location Error"
                );
            },

            {
                enableHighAccuracy: true,
                timeout: 5000
            }
        );
    }
}

$(document).ready(function () {

    $("#registerBtn").click(function () {

        $(".eventCard")
            .fadeOut(1000)
            .fadeIn(1000);
    });

});

displayEvents();
loadPreference();