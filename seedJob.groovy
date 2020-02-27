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



pipelineJob('firstJob') {
    parameters {
        stringParam('FIRSTPARAMETER', 'DEFAULT', 'DESCRIPTION')
    }
    definition {
        cps {
            script(readFileFromWorkspace('firstJob.groovy'))
            sandbox()
        }
    }
}
