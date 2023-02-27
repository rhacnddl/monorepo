CREATE TABLE `user`
(
    `id`         bigint       NOT NULL AUTO_INCREMENT comment 'user ID',
    `role_id`    bigint       NOT NULL comment 'role ID',
    `email`      varchar(255) NOT NULL comment 'email',
    `password`   varchar(255) NOT NULL comment '비밀번호',
    `name`       varchar(255) NOT NULL comment '유저 이름',

    `created_at` timestamp    NOT NULL comment '생성일',
    `updated_at` timestamp    NOT NULL comment '수정일',
    `created_by` varchar(255) NOT NULL comment '생성주체',
    `updated_by` varchar(255) NOT NULL comment '수정주체',
    `is_deleted` bit(1)       NOT NULL DEFAULT b'0' comment '삭제여부',
    PRIMARY KEY (`id`),
    KEY          `user_idx_01` (`updated_at`),
    KEY          `user_idx_02` (`created_at`),
    KEY          `user_idx_03` (`role_id`)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

CREATE TABLE `user_history`
(
    `id`         bigint       NOT NULL AUTO_INCREMENT comment 'user history ID',
    `role_id`    bigint       NOT NULL comment 'role ID',
    `user_id`    bigint       NOT NULL comment 'user ID',
    `email`      varchar(255) NOT NULL comment 'email',
    `password`   varchar(255) NOT NULL comment '비밀번호',
    `name`       varchar(255) NOT NULL comment '유저 이름',

    `created_at` timestamp    NOT NULL comment '생성일',
    `updated_at` timestamp    NOT NULL comment '수정일',
    `created_by` varchar(255) NOT NULL comment '생성주체',
    `updated_by` varchar(255) NOT NULL comment '수정주체',
    `is_deleted` bit(1)       NOT NULL DEFAULT b'0' comment '삭제여부',
    PRIMARY KEY (`id`),
    KEY          `user_history_idx_01` (`updated_at`),
    KEY          `user_history_idx_02` (`created_at`),
    KEY          `user_history_idx_03` (`role_id`),
    KEY          `user_history_idx_04` (`user_id`)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;
