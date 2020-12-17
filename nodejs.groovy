job('NodeJS Job') {
    scm {
        git('https://github.com/Hasegawa0313/jenkins_sample.git') {  node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@example.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs_v12.14.1')
    }
    steps {
        shell("npm install -g yarn")
        shell("yarn install")
        shell("yarn test")
    }
}