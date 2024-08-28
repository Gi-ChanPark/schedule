
### Schedule API 명세서

| HTTP Method | URI                     | Description                        | Request Body                         | Response Body                                  | Status Code        |
|-------------|-------------------------|------------------------------------|--------------------------------------|------------------------------------------------|---------------------|
| POST        | /schedules              | 일정을 저장                      | `{ "title": "일정 제목", "contents": "일정 내용" }` | `{ "id": 1, "title": "일정 제목", "contents": "일정 내용" }` | 201 Created         |
| GET         | /schedules              | 일정 목록 조회                   | (없음)                             | `[ { "id": 1, "title": "일정 제목", "contents": "일정 내용" }, ...]` | 200 OK              |
| GET         | /schedules/{scheduleId} | 특정 일정 조회                   | (없음)                             | `{ "id": 1, "title": "일정 제목", "contents": "일정 내용" }` | 200 OK              |
| PUT         | /schedules/{scheduleId}         | 일정 수정                        | `{ "title": "수정된 제목", "contents": "수정된 내용" }` | `{ "id": 1, "title": "수정된 제목", "contents": "수정된 내용" }` | 200 OK              |
| DELETE      | /schedules/{scheduleId}         | 일정 삭제                        | (없음)                             | (없음)                                         | 204 No Content      |

### Comment API 명세서

| HTTP Method | URI                      | Description                        | Request Body                         | Response Body                                  | Status Code        |
|-------------|--------------------------|------------------------------------|--------------------------------------|------------------------------------------------|---------------------|
| POST        | /schedules/{scheduleId}/comments | 댓글 추가                        | `{ "contents": "댓글 내용" }`      | `{ "id": 1, "schedule_id": 1, "contents": "댓글 내용" }` | 201 Created         |
| GET         | /schedules/comments | 특정 일정의 댓글 목록 조회      | (없음)                             | `[ { "id": 1, "schedule_id": 1, "contents": "댓글 내용" }, ...]` | 200 OK              |
