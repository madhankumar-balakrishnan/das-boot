node {
	def branchName = env.BRANCH_NAME
	echo 'Microservice CI/CD Pipeline - DAS-BOOT Service' 
	echo " #################### Initiating ${branchName} Build #################### "
		
    properties([pipelineTriggers([githubPush()])])
	
	stage ('Pull Repository') {
		checkout scm
	}	
}