// Function to show the popup
function showPopup(message) {
    // Update the popup message based on the passed parameter
    const popupMessage = document.querySelector('.popup-content p');
    popupMessage.textContent = message;
    popup.style.display = 'block';
}

// Close the popup when the user clicks the close button
const closePopup = document.getElementById('closePopup');
closePopup.onclick = function() {
    popup.style.display = 'none';
}

// Function to check for 'signup=success' in the URL
function checkSignupSuccess() {
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('signup') && urlParams.get('signup') === 'success') {
        showPopup("Your registration has been successfully completed!");
    }
}

// Check if the query parameter exists when the page loads
window.onload = function() {
    checkSignupSuccess();
};

// Sidebar toggle functionality
const sidebarToggle = document.getElementById('sidebarToggle');
const sidebar = document.getElementById('sidebar');

// When the sidebar icon is clicked, open/close the sidebar
sidebarToggle.onclick = function() {
    if (sidebar.style.width === '250px') {
        sidebar.style.width = '0';
    } else {
        sidebar.style.width = '250px';
    }
};
