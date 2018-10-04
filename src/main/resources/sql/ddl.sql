create table html_page(
	uuid uuid not null primary key,
	url text not null,
	crawl_timestamp timestamp not null,
	html_compressed bytea,
	processed timestamp,
	processing_failed timestamp,
	topic_id integer not null
		constraint html_page_topic_id_fkey
			references topic
);

create unique index html_page_uuid_uindex
	on html_page (uuid)
;

create index html_page_url_index
	on html_page (url)
;

create index html_page_crawl_timestamp_index
	on html_page (crawl_timestamp)
;

create index html_page_processed_index
	on html_page (processed)
;

create table source(
	id integer not null
		constraint news_source_pkey
			primary key,
	name varchar(255),
	language text
);


create table topic (
	id serial not null primary key,
	name text not null,
	url text not null,
	source_id integer
		constraint html_link_source_id_fkey
			references source
);