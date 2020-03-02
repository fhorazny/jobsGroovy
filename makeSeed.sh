#!/bin/bash
cat baseSeedJob.groovy firstJob.groovy secondJob.groovy > seedJob.groovy

git add seedJob.groovy
git commit -m "NEW: create seedJob from defined scripts"
git push
