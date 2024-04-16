node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/murexport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/murexport.git'), string(name: 'PORT_DESCRIPTION', value: 'A smarter shell and scripting environment with advanced features designed for usability, safety and productivity (eg smarter DevOps tooling)' ), string(name: 'BUILD_LINE', value: 'STABLE'), string(name: 'NODE_LABEL', value: "v3r1"), string(name: 'NODE_LABEL', value: "go_122") ]
  }
}
