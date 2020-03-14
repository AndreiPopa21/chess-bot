build:
	javac *.java
	rm -f xboard.debug

run: Main
	xboard -debug -fcp "java Main"

Main: Main.java
	javac Main.java

clean:
	rm -f *.class
