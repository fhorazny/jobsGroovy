job('secondTry') {
    description 'useless job, only calling some shell commands, when i figure out how to upload sources, will try building java.'
    label('rvais-openshift-testrunner')
    scm{
        git {
            branch('*/master')
            remote{
                credentials('buildadm-ccikey')
                github('com:fhorazny/uselessCalc.git')
            }
        }
    }

    steps {
        maven {
            goals 'clean package'
        }
        shell('''java -jar target/first-0.0.1-SNAPSHOT.jar

RANDOM=$$
R=$(($RANDOM%5))
echo $R
if [ "$R" = "1" ]
then
    echo "not Cool"
    exit 1
else
    echo "Cool"
fi''')
    }
}
