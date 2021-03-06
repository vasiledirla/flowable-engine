#!/bin/sh
echo "Building dependencies"
cd ..
mvn clean install -DskipTests

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error building v6 dependencies. Exiting."
  exit $?
fi

cd modules/flowable5-engine/
mvn clean install -DskipTests
STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error building v5 dependencies. Exiting."
  exit $?
fi

cd ../..

cd modules/flowable5-compatibility/
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable5-compatibility. Exiting."
  exit $?
fi

cd ../..

cd modules/flowable5-test
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable5-test. Exiting."
  exit $?
else
  echo "All Flowable 5 tests succeeded"
fi

cd ../..

cd modules/flowable5-spring
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable5-spring. Exiting."
  exit $?
fi

cd ../..

cd modules/flowable5-spring-compatibility/
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable5-spring-compatibility. Exiting."
  exit $?
fi

cd ../..

cd modules/flowable5-spring-test/
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable5-spring-test. Exiting."
  exit $?
fi

cd ../..

cd modules/flowable-cxf/
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable-cxf. Exiting."
  exit $?
fi

cd ../..

cd modules/flowable5-cxf-test/
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable5-cxf-test. Exiting."
  exit $?
fi

cd ../..

cd modules/flowable-camel/
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable5-camel. Exiting."
  exit $?
fi

cd ../..

cd modules/flowable5-camel-test/
mvn clean install

STATUS=$?
if [ $STATUS -ne 0 ]
then
  echo "Error while building flowable5-camel-test. Exiting."
  exit $?
fi


echo "All good!"
