package io.github.alleriawindrunner.solc.plugin.task;

import io.github.alleriawindrunner.solc.plugin.config.SolidityCompileExtensions;
import io.github.alleriawindrunner.solc.plugin.handler.CompileHandler;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * @author eleven
 * @date 2023年01月30日 10:43 AM
 * @see
 * @since
 */

public class CompileTask extends DefaultTask {
    @TaskAction
    public void solc(){
        System.out.println("Entering solc task, pid " + ManagementFactory.getRuntimeMXBean().getName());
        try{
            File projectDir = getProject().getProjectDir();

            SolidityCompileExtensions extensions = getProject().getExtensions().findByType(SolidityCompileExtensions.class);
            if(extensions == null) extensions = new SolidityCompileExtensions();

            new CompileHandler(projectDir, extensions).doSolc();
        }
        catch (Exception ex){
            System.out.println("Failed" + ex.getMessage());
            System.exit(-1);
        }
    }
}
