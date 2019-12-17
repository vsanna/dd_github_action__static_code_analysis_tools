CREATE TABLE IF NOT EXISTS `users`
(
    `id`        bigint(13) AUTO_INCREMENT,
    `user_name` varchar(255) not null,
    PRIMARY KEY (`id`),
    KEY `user_name_on_users` (`user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE IF NOT EXISTS `messages`
(
    `id`           bigint(13) AUTO_INCREMENT,
    `encrypted_id` varchar(255)  not null,
    `body`         varchar(1024) not null,
    `sender_id`    bigint(13)    not null,
    `receiver_id`  bigint(13)    not null,
    `sent_at`      timestamp     not null,
    PRIMARY KEY (`id`),
    KEY `encrypted_id_on_messages` (`encrypted_id`),
    FOREIGN KEY `sender_id_on_messages` (`sender_id`) REFERENCES `users` (`id`),
    FOREIGN KEY `receiver_id_on_messages` (`receiver_id`) REFERENCES `users` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;