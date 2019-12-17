git stash -q --keep-index
./sample/gradlew -b ./sample/build.gradle prePush
RESULT=$?
git stash pop -q
exit $RESULT

