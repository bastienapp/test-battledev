#!/usr/bin/env bash
clear

rm -rf out/*
javac -classpath out:lib/junit-4.12.jar -d out src/com/isograd/exercise/IsoContest.java 2> logs/checkmethod_output.txt
if [[ $(< logs/checkmethod_output.txt) != "" ]]; then
    cat logs/checkmethod_output.txt
else
    cp resources/* out
    javac -classpath out:lib/junit-4.12.jar -d out src/com/isograd/test/IsoContestTest.java

    java -classpath out:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore IsoContestTest
fi