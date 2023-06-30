//select t3.name
//		from (
//		select name, count(*) cnt
//		from (
//		select (ROW_NUMBER() OVER()) AS rownum, t2.name, t2.year
//		from (
//		select name, year from participation order by name, year
//		) t2
//		) t
//		group by name, year - t.rownum
//		) t3
//		where t3.cnt >=3
//		order by t3.name