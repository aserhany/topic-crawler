create table news_url
(
	nid serial not null
		constraint news_url_pkey
			primary key,
	url varchar,
	html varchar,
	source_id integer
		constraint news_url_source_id_fkey
			references source,
	is_article boolean,
	is_opinion boolean
);

create table source
(
	id serial not null
		constraint news_source_pkey
			primary key,
	name varchar(255),
	language text
);

insert into source (name, language) values ('SpiegelOnline', 'de');