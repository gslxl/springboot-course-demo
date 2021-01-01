.PHONY:all clean
all:
	mvn clean package -DskipTests
clean:
	mvn clean
