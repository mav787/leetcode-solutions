package old.C_Meta;

public class TTT597SQL {
//	select if( f.ct = 0, 0.00, cast(r.ct/f.ct as decimal(4,2) ) ) as accept_rate
//	from
//	(select count(distinct sender_id, send_to_id) as ct
//	from friend_request) as f
//	join
//	(select count(distinct requester_id, accepter_id) as ct
//	from request_accepted) as r
}
