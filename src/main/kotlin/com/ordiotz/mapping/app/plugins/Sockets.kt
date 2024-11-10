package com.ordiotz.mapping.app.plugins

import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.serialization.json.Json
import java.util.Collections
import kotlin.time.Duration.Companion.seconds

fun Application.configureSockets() {
    install(WebSockets) {
        // 데이터를 자동으로 JSON 형식으로 직렬화 및 역직렬화하기 위한 설정
        contentConverter = KotlinxWebsocketSerializationConverter(Json)
        // 서버와 클라이언트 간의 연결 상태를 확인하기 위한 Ping 주기
        pingPeriod = 15.seconds
        // 서버에서 클라이언트 응답을 기다리는 타임아웃(15초 경과 시, 연결 종료)
        timeout = 15.seconds
        // 전송 가능한 최대 프레임 크기 설정 (Long.MAX_VALUE = 무제한)
        maxFrameSize = Long.MAX_VALUE
        // 데이터 프레임 마스킹 여부 (데이터 마스킹 = 데이터 프레임 암호화 전송(데이터 전송 시, 특정 패턴을 적용하여 내용을 감춤))
        masking = false
    }
    routing {
        // Example
        // incoming = 클라이언트의 WebSocket 메시지
        // outgoing = 클라이언트로 보내는 WebSocket 메시지
        webSocket("/ws") {
            for (frame in incoming) {
                if (frame is Frame.Text) {
                    val text = frame.readText()
                    outgoing.send(Frame.Text("YOU SAID: $text"))
                    if (text.equals("bye", ignoreCase = true)) { // ignoreCase = true, 대소문자 구별X
                        close(CloseReason(CloseReason.Codes.NORMAL, "Client said BYE"))
                    }
                    // 객체를 JSON 형식으로 자동 직렬화하여 전송(매개변수로는 데이터 클래스가 들어감.)
                    // sendSerialized()

                    // 동시 접속 구현 기초 예제
//                    val sessions =
//                        Collections.synchronizedList<WebSocketServerSession>(ArrayList())
//                    sessions.add(this)
//                    for(session in sessions) {
//                        session.sendSerialized()
//                    }
                }
            }
        }
    }
}