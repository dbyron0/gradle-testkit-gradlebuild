import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.GradleBuild
 
class HelloWorldPlugin implements Plugin<Project> {     
    void apply(Project project) {     
        project.task('doWork') {
            doLast {
                println 'Hello world!'
            }
        }
        def externalBuildFile = new File(project.getProperty('externalBuildFile'))
        
        project.task('invokeExternalBuild', type: GradleBuild) {
            //buildFile = externalBuildFile
            //tasks = ['helloWorld']
            tasks = ['doWork']
        }
    }
}