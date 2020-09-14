/* INSERT USERS */ INSERT INTO users
(
   username,
   password,
   enabled
)
values
(
   'dasarathi',
   'dasarathiDB',
   true
);
INSERT INTO users
(
   username,
   password,
   enabled
)
values
(
   'admin',
   'adminDB',
   true
);
/* INSERT USERS ROLES */ INSERT INTO authorities
(
   username,
   authority
)
values
(
   'dasarathi',
   'ROLE_USER'
);
INSERT INTO authorities
(
   username,
   authority
)
values
(
   'admin',
   'ROLE_ADMIN'
)