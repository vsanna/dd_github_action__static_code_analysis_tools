CREATE TABLE IF NOT EXISTS `users`
  (
      `id`  bigint(13) AUTO_INCREMENT,
      `user_name` varchar(255) not null,
      PRIMARY KEY (`id`),
      KEY `user_name_on_users` (`user_name`)
  );


CREATE TABLE IF NOT EXISTS `messages`
(
    `id`  bigint(13) AUTO_INCREMENT,
    `encrypted_id`
    `body` varchar(1024) not null,
    `sender_id` bigint(13) not null,
    `receiver_id` bigint(13) not null,
    `sent_at` timestamp not null,
    PRIMARY KEY (`id`),
    KEY `sender_id_on_users` (`sender_id`),
    KEY `receiver_id_on_users` (`receiver_id`)
);