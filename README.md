# Aplicación WebSocket
Spring boot websocket en el backend y reactjs como cliente frontend.

Para comenzar:
    
### React
        - npm install (en la carpeta websocket-frontend)
        - npm run dev
Iniciar en:

[http://localhost:5173/](http://localhost:5173/)

### Spring boot
        - mvn spring-boot:run (en la carpeta websocket-backend)


Para el ejemplo Utilizar un REST Client (Postman) con el siguiente endpoint (POST) y su data

http://localhost:8060/api/tickets

        {
           "numero":"TIC-011"
        }

Una vez enviada la data tenemos un respuesta del end point (ver en Postman) y una respuesta del websocket (ver en el frontend)


![Frontend](/img/front.png)
![ClienteRest](/img/insomnia.png)