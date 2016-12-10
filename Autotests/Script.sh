vagrant up
cd wordpressTests
mvn clean test
mkdir report
cp -r ./target/surefire-reports/html/ ./report/