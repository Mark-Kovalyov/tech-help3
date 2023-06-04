go: build
	./bbackup -b 4096 /mnt/c/db/classification/fraud/union.avro/

build:
	nim compile --assertions:on --checks:on --app:console --stackTrace:on --lineTrace:on --opt:none bbackup.nim 

doc:
	nim doc bbackup.nim

