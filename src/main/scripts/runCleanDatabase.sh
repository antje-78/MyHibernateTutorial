# Delete database and recreate/start it
if test ! -d data
then
        mkdir data
fi
if test -d data
then
        echo Removing database files...
        rm -r data/test.*
fi
echo Starting database engine...
cd data/
java -classpath /home/aw/.m2/repository/org/hsqldb/hsqldb/2.3.2/hsqldb-2.3.2.jar org.hsqldb.Server
