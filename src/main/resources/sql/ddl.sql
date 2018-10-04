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

insert into source (id, name, "language") values (1, 'SpiegelOnline', 'de')
insert into topic (name, url, source_id) values ('Flüchtlinge', 'http://www.spiegel.de/thema/fluechtlinge/archiv.html',1)
insert into topic (name, url, source_id) values ('Brexit', 'http://www.spiegel.de/thema/brexit/archiv.html',1)
insert into topic (name, url, source_id) values ('Börse', 'http://www.spiegel.de/thema/boerse/archiv.html',1);
insert into topic (name, url, source_id) values ('Bundeswehr', 'http://www.spiegel.de/thema/boerse/archiv.html',1);
insert into topic (name, url, source_id) values ('Chemnitz', 'http://www.spiegel.de/thema/chemnitz/dossierarchiv-2.html',1);
insert into topic (name, url, source_id) values ('Erneuerbare Energien', 'http://www.spiegel.de/thema/erneuerbare_energien/archiv.html',1);
insert into topic (name, url, source_id) values ('Griechenland', 'http://www.spiegel.de/thema/griechenland/dossierarchiv-2.html',1);
insert into topic (name, url, source_id) values ('Islam', 'http://www.spiegel.de/thema/islam/dossierarchiv-2.html',1);
insert into topic (name, url, source_id) values ('Polizei', 'http://www.spiegel.de/thema/polizei/dossierarchiv-2.html',1);
insert into topic (name, url, source_id) values ('Religion', 'http://www.spiegel.de/thema/religion/dossierarchiv-2.html',1);
insert into topic (name, url, source_id) values ('Russland', 'http://www.spiegel.de/thema/russland/dossierarchiv-2.html',1);
insert into topic (name, url, source_id) values ('Steuern', 'http://www.spiegel.de/thema/steuern/dossierarchiv-2.html',1);
insert into topic (name, url, source_id) values ('Syrien', 'http://www.spiegel.de/thema/syrien/dossierarchiv-2.html',1);
insert into topic (name, url, source_id) values ('Überwachung', 'http://www.spiegel.de/thema/ueberwachung/archiv.html',1);
insert into topic (name, url, source_id) values ('Ukraine', 'http://www.spiegel.de/thema/ukraine/dossierarchiv-2.html',1);