/*создаем объект WebSocked и указываем путь для подключения.
      * Подключение произойдет сразу после создания компонента.
      */

var webSocket = new WebSocket("ws://localhost:8080/scoreboard/websocket");

//обработчик события открытия соединения с сервером


webSocket.onopen=function(){
};
//обработчик события закрытия соединения с сервером
webSocket.onclose=function(){
}
//обработчик ошибки при работе с сокетом.
webSocket.onerror=function (){
}
//обработчик нажатия кнопки отправки сообщения
function sendMessage(){
    //отправляем сообщение на сервер

    webSocket.send("aaaaaaaaaaaaaaaaaaaaaa");


}
//обработчик получения сообщения ОТ сервера.
webSocket.onmessage=function(){
    location.reload();
}

