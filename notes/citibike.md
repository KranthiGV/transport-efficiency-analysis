# Citibike trip data

## Data download

## Merging csv files

The columns have changes over the years:
Group ('tripduration', 'starttime', 'stoptime', 'start station id', 'start station name', 'start station latitude', 'start station longitude', 'end station id', 'end station name', 'end station latitude', 'end station longitude', 'bikeid', 'usertype', 'birth year', 'gender'):
  ../data/citibike/201306-citibike-tripdata.csv
  ../data/citibike/201307-citibike-tripdata.csv
  ../data/citibike/201308-citibike-tripdata.csv
  ../data/citibike/201309-citibike-tripdata.csv
  ../data/citibike/201310-citibike-tripdata.csv
  ../data/citibike/201311-citibike-tripdata.csv
  ../data/citibike/201312-citibike-tripdata.csv
  ../data/citibike/201401-citibike-tripdata.csv
  ../data/citibike/201402-citibike-tripdata.csv
  ../data/citibike/201403-citibike-tripdata.csv
  ../data/citibike/201404-citibike-tripdata.csv
  ../data/citibike/201405-citibike-tripdata.csv
  ../data/citibike/201406-citibike-tripdata.csv
  ../data/citibike/201407-citibike-tripdata.csv
  ../data/citibike/201408-citibike-tripdata.csv
  ../data/citibike/201409-citibike-tripdata.csv
  ../data/citibike/201410-citibike-tripdata.csv
  ../data/citibike/201411-citibike-tripdata.csv
  ../data/citibike/201412-citibike-tripdata.csv
  ../data/citibike/201501-citibike-tripdata.csv
  ../data/citibike/201502-citibike-tripdata.csv
  ../data/citibike/201503-citibike-tripdata.csv
  ../data/citibike/201504-citibike-tripdata.csv
  ../data/citibike/201505-citibike-tripdata.csv
  ../data/citibike/201506-citibike-tripdata.csv
  ../data/citibike/201507-citibike-tripdata.csv
  ../data/citibike/201508-citibike-tripdata.csv
  ../data/citibike/201509-citibike-tripdata.csv
  ../data/citibike/201510-citibike-tripdata.csv
  ../data/citibike/201511-citibike-tripdata.csv
  ../data/citibike/201512-citibike-tripdata.csv
  ../data/citibike/201601-citibike-tripdata.csv
  ../data/citibike/201602-citibike-tripdata.csv
  ../data/citibike/201603-citibike-tripdata.csv
  ../data/citibike/201604-citibike-tripdata.csv
  ../data/citibike/201605-citibike-tripdata.csv
  ../data/citibike/201606-citibike-tripdata.csv
  ../data/citibike/201607-citibike-tripdata.csv
  ../data/citibike/201608-citibike-tripdata.csv
  ../data/citibike/201609-citibike-tripdata.csv
  ../data/citibike/201704-citibike-tripdata.csv
  ../data/citibike/201705-citibike-tripdata.csv
  ../data/citibike/201706-citibike-tripdata.csv
  ../data/citibike/201707-citibike-tripdata.csv
  ../data/citibike/201708-citibike-tripdata.csv
  ../data/citibike/201709-citibike-tripdata.csv
  ../data/citibike/201710-citibike-tripdata.csv
  ../data/citibike/201711-citibike-tripdata.csv
  ../data/citibike/201712-citibike-tripdata.csv
  ../data/citibike/201801-citibike-tripdata.csv
  ../data/citibike/201802-citibike-tripdata.csv
  ../data/citibike/201803-citibike-tripdata.csv
  ../data/citibike/201804-citibike-tripdata.csv
  ../data/citibike/201805-citibike-tripdata.csv
  ../data/citibike/201806-citibike-tripdata.csv
  ../data/citibike/201807-citibike-tripdata.csv
  ../data/citibike/201808-citibike-tripdata.csv
  ../data/citibike/201809-citibike-tripdata.csv
  ../data/citibike/201810-citibike-tripdata.csv
  ../data/citibike/201811-citibike-tripdata.csv
  ../data/citibike/201812-citibike-tripdata.csv
  ../data/citibike/201901-citibike-tripdata.csv
  ../data/citibike/201902-citibike-tripdata.csv
  ../data/citibike/201903-citibike-tripdata.csv
  ../data/citibike/201904-citibike-tripdata.csv
  ../data/citibike/201905-citibike-tripdata.csv
  ../data/citibike/201906-citibike-tripdata.csv
  ../data/citibike/201907-citibike-tripdata.csv
  ../data/citibike/201908-citibike-tripdata.csv
  ../data/citibike/201909-citibike-tripdata.csv
  ../data/citibike/201910-citibike-tripdata.csv
  ../data/citibike/201911-citibike-tripdata.csv
  ../data/citibike/201912-citibike-tripdata.csv
  ../data/citibike/202001-citibike-tripdata.csv
  ../data/citibike/202002-citibike-tripdata.csv
  ../data/citibike/202003-citibike-tripdata.csv
  ../data/citibike/202004-citibike-tripdata.csv
  ../data/citibike/202005-citibike-tripdata.csv
  ../data/citibike/202006-citibike-tripdata.csv
  ../data/citibike/202007-citibike-tripdata.csv
  ../data/citibike/202008-citibike-tripdata.csv
  ../data/citibike/202009-citibike-tripdata.csv
  ../data/citibike/202010-citibike-tripdata.csv
  ../data/citibike/202011-citibike-tripdata.csv
  ../data/citibike/202012-citibike-tripdata.csv
  ../data/citibike/202101-citibike-tripdata.csv
Group ('Trip Duration', 'Start Time', 'Stop Time', 'Start Station ID', 'Start Station Name', 'Start Station Latitude', 'Start Station Longitude', 'End Station ID', 'End Station Name', 'End Station Latitude', 'End Station Longitude', 'Bike ID', 'User Type', 'Birth Year', 'Gender'):
  ../data/citibike/201610-citibike-tripdata.csv
  ../data/citibike/201611-citibike-tripdata.csv
  ../data/citibike/201612-citibike-tripdata.csv
  ../data/citibike/201701-citibike-tripdata.csv
  ../data/citibike/201702-citibike-tripdata.csv
  ../data/citibike/201703-citibike-tripdata.csv
Group ('ride_id', 'rideable_type', 'started_at', 'ended_at', 'start_station_name', 'start_station_id', 'end_station_name', 'end_station_id', 'start_lat', 'start_lng', 'end_lat', 'end_lng', 'member_casual'):
  ../data/citibike/202102-citibike-tripdata.csv
  ../data/citibike/202103-citibike-tripdata.csv
  ../data/citibike/202104-citibike-tripdata.csv
  ../data/citibike/202105-citibike-tripdata.csv
  ../data/citibike/202106-citibike-tripdata.csv
  ../data/citibike/202107-citibike-tripdata.csv
  ../data/citibike/202108-citibike-tripdata.csv
  ../data/citibike/202109-citibike-tripdata.csv
  ../data/citibike/202110-citibike-tripdata.csv
  ../data/citibike/202111-citibike-tripdata.csv
  ../data/citibike/202112-citibike-tripdata.csv
  ../data/citibike/202201-citibike-tripdata.csv
  ../data/citibike/202202-citibike-tripdata.csv
  ../data/citibike/202203-citibike-tripdata.csv
  ../data/citibike/202204-citibike-tripdata.csv
  ../data/citibike/202205-citibike-tripdata.csv
  ../data/citibike/202206-citibike-tripdata.csv
  ../data/citibike/202207-citibike-tripdata.csv
  ../data/citibike/202208-citibike-tripdata.csv
  ../data/citibike/202209-citibike-tripdata.csv
  ../data/citibike/202210-citibike-tripdata.csv
  ../data/citibike/202211-citibike-tripdata.csv
  ../data/citibike/202212-citibike-tripdata.csv
  ../data/citibike/202301-citibike-tripdata.csv
  ../data/citibike/202302-citibike-tripdata.csv
  ../data/citibike/202303-citibike-tripdata.csv


Extracted the largest subgroups:

Largest subgroups with no missing months:
Group 1: ['tripduration', 'starttime', 'stoptime', 'start station id', 'start station name', 'start station latitude', 'start station longitude', 'end station id', 'end station name', 'end station latitude', 'end station longitude', 'bikeid', 'usertype', 'birth year', 'gender']
  Largest subgroup length: 46
  Largest subgroup: ['../data/citibike/201704-citibike-tripdata.csv', '../data/citibike/201705-citibike-tripdata.csv', '../data/citibike/201706-citibike-tripdata.csv', '../data/citibike/201707-citibike-tripdata.csv', '../data/citibike/201708-citibike-tripdata.csv', '../data/citibike/201709-citibike-tripdata.csv', '../data/citibike/201710-citibike-tripdata.csv', '../data/citibike/201711-citibike-tripdata.csv', '../data/citibike/201712-citibike-tripdata.csv', '../data/citibike/201801-citibike-tripdata.csv', '../data/citibike/201802-citibike-tripdata.csv', '../data/citibike/201803-citibike-tripdata.csv', '../data/citibike/201804-citibike-tripdata.csv', '../data/citibike/201805-citibike-tripdata.csv', '../data/citibike/201806-citibike-tripdata.csv', '../data/citibike/201807-citibike-tripdata.csv', '../data/citibike/201808-citibike-tripdata.csv', '../data/citibike/201809-citibike-tripdata.csv', '../data/citibike/201810-citibike-tripdata.csv', '../data/citibike/201811-citibike-tripdata.csv', '../data/citibike/201812-citibike-tripdata.csv', '../data/citibike/201901-citibike-tripdata.csv', '../data/citibike/201902-citibike-tripdata.csv', '../data/citibike/201903-citibike-tripdata.csv', '../data/citibike/201904-citibike-tripdata.csv', '../data/citibike/201905-citibike-tripdata.csv', '../data/citibike/201906-citibike-tripdata.csv', '../data/citibike/201907-citibike-tripdata.csv', '../data/citibike/201908-citibike-tripdata.csv', '../data/citibike/201909-citibike-tripdata.csv', '../data/citibike/201910-citibike-tripdata.csv', '../data/citibike/201911-citibike-tripdata.csv', '../data/citibike/201912-citibike-tripdata.csv', '../data/citibike/202001-citibike-tripdata.csv', '../data/citibike/202002-citibike-tripdata.csv', '../data/citibike/202003-citibike-tripdata.csv', '../data/citibike/202004-citibike-tripdata.csv', '../data/citibike/202005-citibike-tripdata.csv', '../data/citibike/202006-citibike-tripdata.csv', '../data/citibike/202007-citibike-tripdata.csv', '../data/citibike/202008-citibike-tripdata.csv', '../data/citibike/202009-citibike-tripdata.csv', '../data/citibike/202010-citibike-tripdata.csv', '../data/citibike/202011-citibike-tripdata.csv', '../data/citibike/202012-citibike-tripdata.csv', '../data/citibike/202101-citibike-tripdata.csv']
Group 2: ['Trip Duration', 'Start Time', 'Stop Time', 'Start Station ID', 'Start Station Name', 'Start Station Latitude', 'Start Station Longitude', 'End Station ID', 'End Station Name', 'End Station Latitude', 'End Station Longitude', 'Bike ID', 'User Type', 'Birth Year', 'Gender']
  Largest subgroup length: 6
  Largest subgroup: ['../data/citibike/201610-citibike-tripdata.csv', '../data/citibike/201611-citibike-tripdata.csv', '../data/citibike/201612-citibike-tripdata.csv', '../data/citibike/201701-citibike-tripdata.csv', '../data/citibike/201702-citibike-tripdata.csv', '../data/citibike/201703-citibike-tripdata.csv']
Group 3: ['ride_id', 'rideable_type', 'started_at', 'ended_at', 'start_station_name', 'start_station_id', 'end_station_name', 'end_station_id', 'start_lat', 'start_lng', 'end_lat', 'end_lng', 'member_casual']
  Largest subgroup length: 26
  Largest subgroup: ['../data/citibike/202102-citibike-tripdata.csv', '../data/citibike/202103-citibike-tripdata.csv', '../data/citibike/202104-citibike-tripdata.csv', '../data/citibike/202105-citibike-tripdata.csv', '../data/citibike/202106-citibike-tripdata.csv', '../data/citibike/202107-citibike-tripdata.csv', '../data/citibike/202108-citibike-tripdata.csv', '../data/citibike/202109-citibike-tripdata.csv', '../data/citibike/202110-citibike-tripdata.csv', '../data/citibike/202111-citibike-tripdata.csv', '../data/citibike/202112-citibike-tripdata.csv', '../data/citibike/202201-citibike-tripdata.csv', '../data/citibike/202202-citibike-tripdata.csv', '../data/citibike/202203-citibike-tripdata.csv', '../data/citibike/202204-citibike-tripdata.csv', '../data/citibike/202205-citibike-tripdata.csv', '../data/citibike/202206-citibike-tripdata.csv', '../data/citibike/202207-citibike-tripdata.csv', '../data/citibike/202208-citibike-tripdata.csv', '../data/citibike/202209-citibike-tripdata.csv', '../data/citibike/202210-citibike-tripdata.csv', '../data/citibike/202211-citibike-tripdata.csv', '../data/citibike/202212-citibike-tripdata.csv', '../data/citibike/202301-citibike-tripdata.csv', '../data/citibike/202302-citibike-tripdata.csv', '../data/citibike/202303-citibike-tripdata.csv']