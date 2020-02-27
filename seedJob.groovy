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
    parameters {
        stringParam('FIRSTPARAMETER', 'DEFAULT', 'DESCRIPTION')
    }
	
    steps {
        dsl {
            text(readFileFromWorkspace('firstJob.groovy'))
            removeAction('DELETE')
            //script(readFileFromWorkspace('firstJob.groovy'))
            //sandbox()
        }
    }
}
