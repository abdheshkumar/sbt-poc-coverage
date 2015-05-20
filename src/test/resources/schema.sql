CREATE TABLE `user`(
  `id` integer NOT NULL AUTO_INCREMENT,
  `name` character varying(254) NOT NULL,
  `email` character varying(254) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id)
);
