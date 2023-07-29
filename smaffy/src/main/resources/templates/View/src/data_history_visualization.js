// Sensor history by genre visual
import React, { useState } from 'react';
import { Line } from 'react-chartjs-2';

const History = () => {
    const [genre, setGenre] = useState('');
    const [historicalData, setHistoricalData] = useState([]);

    const fetchHistoricalData = async () => {
        if (genre) {
            const response = await fetch(`/api/temperature/history/${genre}`);
            const data = await response.json();
            setHistoricalData(data);
        }
    };

    // Extract temperature and timestamp from historicalData to be used in the chart
    const temperatures = historicalData.map((data) => data.temperature);
    const timestamps = historicalData.map((data) => data.timestamp);

    const chartData = {
        labels: timestamps,
        datasets: [
            {
                label: `Temperature Data - ${genre}`,
                data: temperatures,
                fill: false,
                borderColor: 'rgb(54, 162, 235)',
                tension: 0.1,
            },
        ],
    };

    const chartOptions = {
        scales: {
            x: {
                type: 'time',
                time: {
                    unit: 'day',
                },
            },
            y: {
                beginAtZero: true,
            },
        },
    };

    return (
        <div>
            <h1>Temperature History</h1>
            <label>
                Select Genre:
                <input type="text" value={genre} onChange={(e) => setGenre(e.target.value)} />
            </label>
            <button onClick={fetchHistoricalData}>Fetch Data</button>
            {historicalData.length > 0 && <Line data={chartData} options={chartOptions} />}
        </div>
    );
};

export default History;
