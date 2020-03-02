job('secondJob') {
    description 'Job just to demonstrate creating multiple jobs'
    label('rvais-openshift-testrunner')

    steps {
        shell('''echo "Cool"''')
    }
}


