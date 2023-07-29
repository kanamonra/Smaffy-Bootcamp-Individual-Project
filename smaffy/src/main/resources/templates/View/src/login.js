// to do for log out part + think about error method
document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('login-form');

    loginForm.addEventListener('submit', (event) => {
        event.preventDefault();

        const formData = new FormData(loginForm);
        const email = formData.get('userid');
        const password = formData.get('pw');

        // Replace this with your actual login API endpoint
        const loginEndpoint = '/api/login';

        fetch(loginEndpoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Login failed. Incorrect input.');
                }
            })
            .then(data => {
                // Successful login, redirect to the dashboard or other pages
                console.log('Logged in:', data);

                window.location.href = '/dashboard';
            })
            .catch(error => {
                console.error('Login error:', error);

            });
    });
});
