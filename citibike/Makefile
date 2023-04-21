clean:
	rm -f *.jar *.class
	hadoop fs -rm -r cleaning/output

build:
	javac -classpath `hadoop classpath` *.java
	jar cvf citibike.jar *.class

run:
	hadoop jar citibike.jar CitibikeDriver cleaning/202210-202303-citibike-tripdata-merged.csv cleaning/output

.PHONY: clean build run