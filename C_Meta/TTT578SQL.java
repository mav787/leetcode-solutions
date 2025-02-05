package C_Meta;

public class TTT578SQL {
//	SELECT question_id as survey_log
//	FROM
//	(
//		SELECT question_id, SUM(case when action="show" THEN 1 ELSE 0 END) as num_show,    
//	    SUM(case when action="answer" THEN 1 ELSE 0 END) as num_answer
//		FROM survey_log
//		GROUP BY question_id
//	) as tbl
//	ORDER BY (num_answer / num_show) DESC LIMIT 1
}
