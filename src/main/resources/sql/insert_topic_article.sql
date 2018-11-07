insert into felix_spon_topic_article (
  topic_id,
  article_id
)
select *
from (
  select
    ? as topic_id,
    ? as article_id
)  x
where
  not exists (
    select *
    from felix_spon_topic_article fsta
    where
      x.topic_id = fsta.topic_id
      and x.article_id = fsta.article_id
  );
