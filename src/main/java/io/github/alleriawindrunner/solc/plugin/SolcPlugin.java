package io.github.alleriawindrunner.solc.plugin;

import io.github.alleriawindrunner.solc.plugin.config.SolidityCompileExtensions;
import io.github.alleriawindrunner.solc.plugin.task.CompileTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author eleven
 * @date 2023年01月30日 10:43 AM
 * @see
 * @since
 */

public class SolcPlugin implements Plugin<Project> {
    

    @Override
    public void apply(Project project) {
        //Confuration
        project.getExtensions().create("solc", SolidityCompileExtensions.class);
        //Task
        project.getTasks().create("solc", CompileTask.class);
    }

    //call solc.exe
}
