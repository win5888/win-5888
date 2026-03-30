// server.js (Node.js snippet)
const express = require('express');
const app = express();
app.use(express.json());

// Mock Database
let predictions = [
    { user: "User01", number: "1234" },
    { user: "User02", number: "5588" }
];

let pointsBoard = {};

// ADMIN API: Update Results and Calculate Winners
app.post('/admin/update-results', (req, res) => {
    const { winningNumbers } = req.body; // Array: ["1234", "8888", "9999"]
    
    predictions.forEach(entry => {
        if (winningNumbers.includes(entry.number)) {
            // Match found! Give points
            pointsBoard[entry.user] = (pointsBoard[entry.user] || 0) + 1000;
        }
    });

    res.json({ message: "Scores updated!", currentBoard: pointsBoard });
});

app.listen(3000, () => console.log('Server running on port 3000'));
