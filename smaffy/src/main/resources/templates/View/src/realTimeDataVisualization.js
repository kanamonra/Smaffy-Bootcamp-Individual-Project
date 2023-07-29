// Sensor Data real time visualization for dashboard

import React, { useState, useEffect } from 'react';
import { Line } from 'react-chartjs-2';

const Dashboard = () => {
    const [realTimeData, setRealTimeData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch('/api/temperature/realtime');
            const data = await response.json();
            setRealTimeData(data);
        };

        const intervalId = setInterval(fetchData, 5000); // Fetch data every 5 seconds (adjust as needed)

        return () => clearInterval(intervalId); // Clean up the interval on component unmount
    }, []);

    // Extract temperature and timestamp from realTimeData to be used in the chart
    const temperatures = realTimeData.map((data) => data.temperature);
    const timestamps = realTimeData.map((data) => data.timestamp);

    const chartData = {
        labels: timestamps,
        datasets: [
            {
                label: 'Real-time Temperature',
                data: temperatures,
                fill: false,
                borderColor: 'rgb(75, 192, 192)',
                tension: 0.1,
            },
        ],
    };

    const chartOptions = {
        scales: {
            x: {
                type: 'time',
                time: {
                    unit: 'second',
                },
            },
            y: {
                beginAtZero: true,
            },
        },
    };

    return (
        <div>
            <h1>Real-time Temperature Dashboard</h1>
            <Line data={chartData} options={chartOptions} />
        </div>
    );
};

export default Dashboard;
