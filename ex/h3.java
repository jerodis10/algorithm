//SELECT
//	PLACE_ID
//	SUM(PRICE) AS ADDITIONAL_SALES
//FROM SCHEDULES
//WHERE SCHEDULED_AT >= '2019-05-01'
//GROUP BY PLACE_ID
//HAVING SUM(PRICE) >= 5000