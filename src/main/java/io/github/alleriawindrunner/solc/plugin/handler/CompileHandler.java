package io.github.alleriawindrunner.solc.plugin.handler;

import io.github.alleriawindrunner.solc.plugin.compiler.CompileSolToJava;
import io.github.alleriawindrunner.solc.plugin.config.SolidityCompileExtensions;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * @author eleven
 * @date 2023年01月30日 10:43 AM
 * @see
 * @since
 */

public class CompileHandler  {

    private File projectDir;
    private SolidityCompileExtensions extensions;

    public CompileHandler(File projectDir, SolidityCompileExtensions extensions){
        this.projectDir = projectDir;
        this.extensions = extensions;
    }

    public void doSolc() throws Exception{

        File contractsDir = new File(projectDir, extensions.getContracts());
        String solSelector = extensions.getSelector();
        if(!contractsDir.exists()){
            System.out.println("Solidity contracts dir not found "+contractsDir.getAbsolutePath());
            return;
        }

        CompileSolToJava solToJava = new CompileSolToJava();

        File outputBaseDir = new File(projectDir, extensions.getOutput());//src/main
        String packageName = extensions.getPkg();
        File abiOutputDir = new File(outputBaseDir, "abi");
        File binOutputDir = new File(outputBaseDir, "bin/ecc");
        File smbinOutputDir = new File(outputBaseDir, "bin/sm");
        File javaOutputDir = extensions.isOnlyAbiBin()?null:new File(outputBaseDir, "java");
        if(!extensions.isOnlyAbiBin() && StringUtils.isBlank(packageName)) {
            System.out.println("Java package is empty");
            return;
        }
        solToJava.compileSolToJava(solSelector, packageName, contractsDir, abiOutputDir, binOutputDir, smbinOutputDir, javaOutputDir);

        System.out.println("Solidity contracts compile complete ");
    }
}
