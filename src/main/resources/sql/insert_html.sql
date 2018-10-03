insert into html_page (
  uuid,
  url,
  crawl_timestamp,
  html_compressed
)
select *
from (
  select
    ? as uuid,
    ? as url,
    ? as crawl_timestamp,
    ? as html_compressed
)  x
where
  not exists (
    select *
    from html_page h
    where
      x.url = h.url
      and x.crawl_timestamp < h.crawl_timestamp
  );
