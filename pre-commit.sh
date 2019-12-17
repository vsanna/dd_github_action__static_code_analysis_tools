git stash -q --keep-index
./sample/gradlew -b ./sample/build.gradle test
RESULT=$?
git stash pop -q
exit $RESULT
