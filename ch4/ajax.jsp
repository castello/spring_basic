<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
    <h2>{name:"abc", age:10}</h2>
    <button id="sendBtn" type="button">SEND</button>
    <h2>Data From Server :</h2>
    <div id="data"></div>
    <script>
        $(document).ready(function(){
            let person = {name:"abc", age:10};
            let person2 = {};

            $("#sendBtn").click(function(){
                $.ajax({
                    type:'POST',       // 요청 메서드
                    url: '/ch4/send',  // 요청 URI
                    headers : { "content-type": "application/json"}, // 요청 헤더
                    dataType : 'text', // 전송받을 데이터의 타입
                    data : JSON.stringify(person),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                    success : function(result){
                        person2 = JSON.parse(result);    // 서버로부터 응답이 도착하면 호출될 함수
                        alert("received="+result);       // result는 서버가 전송한 데이터
                        $("#data").html("name="+person2.name+", age="+person2.age);
                    },
                    error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax()

                alert("the request is sent")
            });
        });
    </script>
</body>
</html>
