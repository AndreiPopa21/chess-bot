JAVAC = javac
JAVA = java
XBOARD = xboard -debug

build:
	$(JAVAC) *.java

run: Main
	$(JAVA) Main
first: 
	$(XBOARD) -fcp "make run" -scp "fairymax" -secondInitString "new\nrandom\nsd 2\n" -tc 5 -inc 2 -autoCallFlag true -mg 10 -sgf partide.txt -reuseFirst false

second:
	$(XBOARD) -fcp "make run"

Main: Main.java
	$(JAVAC) Main.java

clean:
	rm -f *.class
	rm -f xboard.debug
	rm -f partide.txt
