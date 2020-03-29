cp = /volumes/data/lib/antlr-4.8-complete.jar:$(PWD):$(PWD)/target
jdriver = /volumes/data/bin/jdriver.sh

compile: g4 java

g4:
	java -cp $(cp) org.antlr.v4.Tool -no-listener -no-visitor src/*.g4

java:
	mkdir -p ./target
	javac -cp $(cp) -d target -sourcepath src src/*.java src/numlang/*.java

run:
	java -cp $(cp) Check $(file)

debug:
	java -cp $(cp) org.antlr.v4.gui.TestRig ProgLang program -tree < $(file)

clean:
	rm -rf target
	rm -f src/ProgLang*.java src/*.interp src/*.tokens

check:
	$(jdriver) :testdrive expected.edn output.edn > /dev/null
	$(jdriver) :report output.edn report.edn
