document.addEventListener('DOMContentLoaded', () => {
    const temperatureTableBody = document.getElementById('temperature-table-body');

    // Fetch real-time temperature data from the backend using AJAX
    fetch('/analysis')
        .then(response => response.json())
        .then(data => {
            // Populate the table with the fetched temperature data
            data.forEach(item => {
                const row = createTableRow(item.date, item.temperature, item.analysisResult);
                temperatureTableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error fetching real-time temperature data:', error);
        });

    // create a table row with temperature data
    function createTableRow(date, temperature, analysis) {
        const row = document.createElement('tr');

        const dateCell = document.createElement('td');
        dateCell.textContent = date;
        row.appendChild(dateCell);

        const temperatureCell = document.createElement('td');
        temperatureCell.textContent = temperature;
        row.appendChild(temperatureCell);

        const analysisCell = document.createElement('td');
        analysisCell.textContent = analysis;
        row.appendChild(analysisCell);

        return row;
    }
});
