.PHONY:	build

build:
	./gradlew build

run-dist:
	./app/build/install/app/bin/app

diff-json:
	./app/build/install/app/bin/app app/src/test/resources/file1.json app/src/test/resources/file2.json

diff-yml:
	./app/build/install/app/bin/app app/src/test/resources/file1.yml app/src/test/resources/file2.yml

diff-nested-json:
	./app/build/install/app/bin/app app/src/test/resources/file1-nested.json app/src/test/resources/file2-nested.json

diff-nested-yml:
	./app/build/install/app/bin/app app/src/test/resources/file1-nested.yml app/src/test/resources/file2-nested.yml

diff-plain:
	./app/build/install/app/bin/app -f plain app/src/test/resources/file1-nested.json app/src/test/resources/file2-nested.json

diff-json-format:
	./app/build/install/app/bin/app -f json app/src/test/resources/file1-nested.json app/src/test/resources/file2-nested.json