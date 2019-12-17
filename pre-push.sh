git stash -q --keep-index
./sample/gradlew -b ./sample/build.gradle checkstyleMain pmdMain spotbugsMain dependencyCheckAnalyze 
RESULT=$?
git stash pop -q
exit $RESULT

