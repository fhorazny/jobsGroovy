// ######## Views definitions ########
// ###################################
sectionedView('fhoraznySeedExperiment') {
description('Automated jobs for fhorazny')
sections {
    listView {
        name("fhoraznySeedJobed")
        alignment('LEFT')
        jobs {
            name("firstJob")
            name("secondJob")
            name("firstTry")
            name("secondTry")
        }
        columns {
            status()
            weather()
            name()
            lastSuccess()
            lastFailure()
            lastDuration()
            buildButton()
            lastBuildConsole()
        }
    }
    /*listView {
        name("another view")
        alignment('LEFT')
        jobs {
            regex("amq7-broker-ocp.*")
            regex("amq7-broker-ocp-*")
        }
        columns {
            status()
            weather()
            name()
            lastSuccess()
            lastFailure()
            lastDuration()
            buildButton()
            lastBuildConsole()
        }
    }*/
}
}

// ######### Job definitions #########
// ###################################


job('firstJob') {
    description 'useless job, only calling some shell commands, when i figure out how to upload sources, will try building java.'
    label('rvais-openshift-testrunner')
    scm{
        git {
            branch('*/master')
            remote{
                credentials('buildadm-ccikey')
                github('fhorazny/uselessCalc')
            }
        }
    }
    triggers {
        githubPush()
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


job('secondJob') {
    description 'Job just to demonstrate creating multiple jobs'
    label('rvais-openshift-testrunner')

    steps {
        shell('''echo "Cool2"''')
    }
}


