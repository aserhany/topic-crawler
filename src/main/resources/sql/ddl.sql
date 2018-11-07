create table aser_multisource_article(
	uuid uuid not null primary key,
	url text not null,
	crawl_timestamp timestamp not null,
	html text,
	html_compressed bytea,
	source_id integer constraint felix_spon_topic_source_id_fkey references source
);