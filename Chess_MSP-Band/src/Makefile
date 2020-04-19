build:
	javac *.java
	rm -f xboard.debug

run: Main
	java Main
first: 
	xboard -debug -fcp "make run" -scp "fairymax" -secondInitString "new\nrandom\nsd 2\n" -tc 5 -inc 2 -autoCallFlag true -mg 10 -sgf partide.txt -reuseFirst false

second:
	xboard -debug -fcp "make run"

Main: Main.java
	javac Main.java

clean:
	rm -f *.class
