insert into felix_spon_article (
  url,
  text,
  source_id
)
select *
from (
  select
    ? as url,
    ? as text,
    ? as source_id
)  x
where
  not exists (
    select *
    from felix_spon_article fsa
    where
      x.url = fsa.url
  );

