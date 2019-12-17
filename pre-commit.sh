git stash -q --keep-index
PROJECT_ROOT=../..
$PROJECT_ROOT/sample/gradlew -b $PROJECT_ROOT/sample/build.gradle test
RESULT=$?
git stash pop -q
exit $RESULT
