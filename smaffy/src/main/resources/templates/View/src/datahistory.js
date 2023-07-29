function fetchHistoricalData(daysAgo) {
    // fetching method
    fetch(`/api/getHistoricalData?daysAgo=${daysAgo}`)
        .then(response => response.json())
        .then(data => {
            // Remove previous data from the table body
            const tableBody = document.getElementById('data-table-body');
            tableBody.innerHTML = '';

            // Loop through the historical data and insert each record into the table
            for (const record of data) {
                const row = tableBody.insertRow();
                const dateCell = row.insertCell();
                const temperatureCell = row.insertCell();
                dateCell.textContent = record.timestamp;
                temperatureCell.textContent = record.temperature;
            }
        })
        .catch(error => {
            console.error('Error fetching historical temperature data:', error);
        });
}
