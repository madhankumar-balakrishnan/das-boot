node {
	echo 'Microservice CI/CD Pipeline - DAS-BOOT Service' 
	echo "#################### Initiating ${env.BRANCH_NAME} Build ####################"
		
    properties([pipelineTriggers([githubPush()])])
	
	stage ('Pull Repository') {
		checkout scm
	}	
}