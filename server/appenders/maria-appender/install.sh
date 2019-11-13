echo "Maven build and installation"
mvn install
echo "copy jar to library repositories"
cp target/maria-appender-0.10.0.jar /usr/lib/kaa-node/lib
