# Should run in the directory containing the citibike data files

# Maybe we can just remove them?
mkdir temp
mv *.zip temp

for file in *-*-*; do mv "$file" "$(echo "$file" | sed -r 's/([0-9]{4})-([0-9]{2}) - Citi Bike trip data.csv/\1\2-citibike-tripdata.csv/')"; done