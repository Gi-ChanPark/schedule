CREATE TABLE `schedule`
(
    `id`           BIGINT NOT NULL AUTO_INCREMENT,
    `title`        VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '제목',
    `description`  TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '설명',
    `start_date`   DATE COMMENT '시작 날짜',
    `end_date`     DATE COMMENT '종료 날짜',
    `created_at`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
    `updated_at`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  COMMENT = '일정';

CREATE TABLE `comment`
(
    `id`           BIGINT NOT NULL AUTO_INCREMENT,
    `schedule_id`  BIGINT NOT NULL COMMENT '일정 ID',
    `content`      TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '내용',
    `created_at`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
    `updated_at`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    PRIMARY KEY (`id`),
    FOREIGN KEY (`schedule_id`) REFERENCES `schedule`(`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  COMMENT = '댓글';
