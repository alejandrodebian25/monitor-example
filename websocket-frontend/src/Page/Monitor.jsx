import React, { useEffect, useState } from 'react'
import { over } from 'stompjs';
import SockJS from "sockjs-client/dist/sockjs"

const Monitor = () => {

    let stompClient = null;
    const [isConnected, setIsConnected] = useState(false)
    const [receivedData, setReceivedData] = useState([])

    useEffect(() => { connect() }, [])

    const connect = () => {
        let Sock = new SockJS('http://localhost:8060/websocket-ticketero');
        stompClient = over(Sock);
        stompClient.connect({}, onConnected, onError);
    }

    const onConnected = () => {
        setIsConnected(true);
        stompClient.subscribe('/ticketero/monitor', onMessageReceived);

    }
    const onError = (err) => {
        setIsConnected(false)
    }

    const onMessageReceived = (payload) => {
        const payloadData = JSON.parse(payload.body);
        receivedData.push(payloadData)
        setReceivedData([...receivedData])
    }
    return (
        <div>
            <h1>Monitor</h1>
            <p>Estado: {isConnected ? 'CONECTADO' : 'Desconectado'}</p>
            <hr />
            <ul>{receivedData.map((data, index) => <li key={index}>{data.id}-{data.numero}</li>)}</ul>
        </div>
    )
}

export default Monitor