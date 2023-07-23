# Smaffy-Bootcamp-Individual-Projetc

The Smaffy Demo version is a simple web application that provides real-time temperature sensor data visualization and analysis for a smart factory.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The goal of this demo version of project is to build a web application that collects real-time temperature data from Arduino-based sensors in a smart factory and visualizes it on a dashboard. The application will also offer data analysis for temperature trends and patterns.

## Features

- Real-time temperature data visualization with charts.
- Historical temperature data analysis.
- User-friendly web interface.
- Secure login and logout functionality.

## Technologies

- Frontend: React, 
- Backend: Spring MVC (Java), Webserver on Arduino E-board (C++)
- Database: MongoDB
- Chart Library: Chart.js
- Arduino E-board for collecting real-time temperature data

## Setup

1. Clone the repository.
2. Set up the backend by [linking to your backend setup instructions].
3. Set up the frontend by [linking to your frontend setup instructions].
4. Connect the Arduino E-board to your sensors and configure it with back-end real time data listener.

## Usage

1. Start the backend server.
2. Access the web application from your browser by IP address.
3. Login using your credentials. (Try this-> user: user1 // password: user01)
4. The dashboard will display real-time temperature data in the form of charts.
5. Navigate to the analysis page to view historical temperature data trends.

## API Endpoints

- `GET /api/temperature/realtime`: Fetch real-time temperature data.
- `GET /api/temperature/history/{genre}`: Fetch historical temperature data by genre for analysis.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

[MIT License](LICENSE)
