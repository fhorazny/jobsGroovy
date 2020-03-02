# jobsGroovy
scripts for seed job to execute and create jobs we want

makeSeed.sh - rewrites seedJob.groovy and push it to git (here)
seedJob.groovy - creates views and jobs defined by its own file and called in makeSeed.sh
baseSeedJob.groovy - base for seedJob, mostly views, might add some features
other *.groovy - jobs groovy scripts for creations


how to use:
1. create/commit your jobs you want to create
2. change baseSeedJob.groovy -> your own views etc.
3. insert your groovy skripts in makeSeed.sh (cat command)
4. call "sh makeSeed.sh"
5. manually create jenkins job (seedJob) with git attached and do 
      build -> Process Job DSLs -> Look on Filesystem -> DSL Scripts = seedJob.groovy
