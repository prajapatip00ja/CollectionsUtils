echo compiling...
javac -cp junit-4.10.jar CollectionTest.java CollectionsUtils.java
echo running...
java -cp ".;junit-4.10.jar" org.junit.runner.JUnitCore CollectionTest