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
java -classpath /opt/programs/hsqldb-2.3.2/hsqldb/lib/hsqldb.jar org.hsqldb.Server -database.0 file:/home/aw/workspace-intellij-git/HibernateTutorial/target/data/tutorial -dbname.0 xdb
