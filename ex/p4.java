package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import programmers.level.level1.inner;

public class p4 {

	/*
Enter your query below.
Please append a semicolon ";" at the end of the query
*/

	/*select
		a.party, count(a.party) as partyCount
	from candidates a
	inner join (
			select a.candidate_id, a.votes
			from Results a
					inner join (
					select constituency_id, max(votes) as maxVote
	from Results
	group by constituency_id
		) b on b.maxVote = a.votes
	) b on b.candidate_id = a.id
	group by party
	order by partyCount desc;*/


}
