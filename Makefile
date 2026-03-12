.PHONY:	build

build:
	./gradlew build

run-dist:
	./app/build/install/app/bin/app

diff-json:
	./app/build/install/app/bin/app app/src/test/resources/file1.json app/src/test/resources/file2.json

diff-yml:
	./app/build/install/app/bin/app app/src/test/resources/file1.yml app/src/test/resources/file2.yml