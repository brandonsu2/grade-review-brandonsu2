CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

pwd
if ! [ -f student-submission/ListExamples.java ] 
then
    echo "Missing necessary files"
    exit
fi
    echo "Continue"

cp TestListExamples.java student-submission/ListExamples.java grading-area
cp -r lib grading-area

cd grading-area
pwd

javac -cp $CPATH *.java 
echo $?

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > results.txt
grep 

