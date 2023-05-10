-- Average trip duration per user type (member or casual)
SELECT member_casual, AVG(trip_duration_seconds) AS average_duration
FROM citibike_trips
GROUP BY member_casual;

/*
 member_casual |  average_duration  
---------------+--------------------
 member_casual |               NULL 
 member        |  686.7771900485335 
 casual        | 1254.2422477773778 
(3 rows)
*/


-- Top 10 busiest start stations
SELECT start_station_name, COUNT(*) AS num_trips
FROM citibike_trips
GROUP BY start_station_name
ORDER BY num_trips DESC
LIMIT 10;

/*
   start_station_name    | num_trips 
-------------------------+-----------
 W 21 St & 6 Ave         |     59535 
 University Pl & E 14 St |     49630 
 1 Ave & E 68 St         |     46978 
 Broadway & W 58 St      |     46206 
 6 Ave & W 33 St         |     44230 
 W 31 St & 7 Ave         |     43791 
 Broadway & W 25 St      |     40970 
 8 Ave & W 33 St         |     40771 
 E 33 St & 1 Ave         |     40685 
 11 Ave & W 41 St        |     40208 
(10 rows)
*/



-- Trips count by day of the week
SELECT day_of_week, COUNT(*) AS num_trips
FROM citibike_trips
GROUP BY day_of_week
ORDER BY day_of_week;

/*
 day_of_week | num_trips 
-------------+-----------
           1 |   1566580 
           2 |   1749328 
           3 |   1864922 
           4 |   2048148 
           5 |   2001348 
           6 |   1932323 
           7 |   1736968 
        NULL |        18 
(8 rows)
*/



-- Average distance traveled by hour of the day
SELECT hour, AVG(distance_km) AS avg_distance
FROM citibike_trips
GROUP BY hour
ORDER BY hour;

/*
 hour |    avg_distance    
------+--------------------
    0 | 1.8620774297153007 
    1 | 1.8224185589044593 
    2 | 1.8088468888650273 
    3 | 1.8133200968913064 
    4 | 1.7924840513283185 
    5 | 1.7775975865876108 
    6 | 1.8169782607512346 
    7 | 1.8421740277680925 
    8 |  1.817337094083028 
    9 | 1.7212680913834089 
   10 | 1.6909592655620764 
   11 | 1.6909897232309585 
   12 |  1.680919974305129 
   13 | 1.7014453474954496 
   14 | 1.7341407472336823 
   15 | 1.7424099565738487 
   16 | 1.7754549367595018 
   17 |  1.806213904550052 
   18 | 1.7588870494774507 
   19 |  1.689069751765895 
   20 | 1.6668336435910702 
   21 | 1.7140675208684866 
   22 | 1.7877259359417124 
   23 | 1.8438768644979764 
 NULL |               NULL 
(25 rows)
*/



-- Top 10 most common routes (start station to end station)
SELECT start_station_name, end_station_name, COUNT(*) AS num_trips
FROM citibike_trips
GROUP BY start_station_name, end_station_name
ORDER BY num_trips DESC
LIMIT 10;

/*
        start_station_name         |         end_station_name          | num_trips 
-----------------------------------+-----------------------------------+-----------
 Central Park S & 6 Ave            | Central Park S & 6 Ave            |      4071 
 Grand Army Plaza & Central Park S | Grand Army Plaza & Central Park S |      3837 
 7 Ave & Central Park South        | 7 Ave & Central Park South        |      3425 
 Broadway & W 58 St                | Broadway & W 58 St                |      3250 
 W 21 St & 6 Ave                   | 9 Ave & W 22 St                   |      3149 
 North Moore St & Greenwich St     | Vesey St & Church St              |      2870 
 St Marks Pl & 2 Ave               | St Marks Pl & 1 Ave               |      2814 
 1 Ave & E 62 St                   | 1 Ave & E 68 St                   |      2606 
 Broadway & W 41 St                | Broadway & W 41 St                |      2606 
 5 Ave & E 72 St                   | 5 Ave & E 72 St                   |      2562 
(10 rows)
*/



-- Busiest hours of the day
SELECT hour, COUNT(*) AS num_trips
FROM citibike_trips
GROUP BY hour
ORDER BY num_trips DESC;

/*
 hour | num_trips 
------+-----------
   17 |   1160533 
   18 |   1029486 
   16 |   1019159 
   15 |    941426 
   14 |    861539 
    8 |    845294 
   13 |    785936 
   19 |    743039 
   12 |    732118 
    9 |    696272 
   11 |    647385 
   10 |    600340 
    7 |    576658 
   20 |    521592 
   21 |    395985 
   22 |    326241 
    6 |    264641 
   23 |    242352 
    0 |    162086 
    1 |    101722 
    5 |     97428 
    2 |     64817 
    3 |     43457 
    4 |     40111 
 NULL |        18 
(25 rows)
*/



-- Distribution of trip durations
SELECT
    CASE
        WHEN trip_duration_seconds <= 300 THEN '0-5 minutes'
        WHEN trip_duration_seconds > 300 AND trip_duration_seconds <= 600 THEN '5-10 minutes'
        WHEN trip_duration_seconds > 600 AND trip_duration_seconds <= 1200 THEN '10-20 minutes'
        WHEN trip_duration_seconds > 1200 AND trip_duration_seconds <= 1800 THEN '20-30 minutes'
        ELSE 'Above 30 minutes'
    END AS duration_range,
    COUNT(*) AS num_trips
FROM citibike_trips
GROUP BY 1
ORDER BY 1;

/*
  duration_range  | num_trips 
------------------+-----------
 0-5 minutes      |   3423943 
 10-20 minutes    |   3462547 
 20-30 minutes    |   1140785 
 5-10 minutes     |   4024933 
 Above 30 minutes |    847427 
(5 rows)
*/



-- Average speed in kmph
SELECT AVG(distance_km / NULLIF(trip_duration_seconds / 3600.0, 0)) AS overall_average_speed_kmph
FROM citibike_trips
WHERE trip_duration_seconds > 0 AND distance_km > 0;

/*
 overall_average_speed_kmph 
----------------------------
          9.898149225550748 
(1 row)
*/



-- The average speed during rush hours from 5pm - 7pm
SELECT AVG(distance_km / NULLIF(trip_duration_seconds / 3600.0, 0)) AS average_speed_kmph_rush_hours
FROM citibike_trips
WHERE trip_duration_seconds > 0 AND distance_km > 0
      AND hour >= 17 AND hour <= 19;

/*
 average_speed_kmph_rush_hours 
-------------------------------
             9.714653864851439 
(1 row)
*/
