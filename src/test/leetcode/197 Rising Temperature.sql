# find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.

SELECT b.Id FROM Weather a, Weather b WHERE a.Temperature<b.Temperature AND b.Date = a.Date + Interval 1 Day