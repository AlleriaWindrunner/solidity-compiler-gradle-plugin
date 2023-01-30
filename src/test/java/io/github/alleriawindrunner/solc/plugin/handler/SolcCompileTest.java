package io.github.alleriawindrunner.solc.plugin.handler;

import io.github.alleriawindrunner.solc.compiler.SolidityCompiler;
import io.github.alleriawindrunner.solc.plugin.config.SolidityCompileExtensions;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static io.github.alleriawindrunner.solc.compiler.SolidityCompiler.Options.*;


/**
 * @author eleven
 * @date 2023年01月30日 10:43 AM
 * @see
 * @since
 */

public class SolcCompileTest {

    private File helloworld4 = new File("src/test/resources/HelloWorldV4.sol");
    @Test
    public void testV4() throws Exception{
        SolidityCompiler.Result smRes =
                SolcHandler.buildSolidityCompiler().compile(helloworld4, true, true, ABI, BIN, METADATA);
        SolidityCompiler.Result eccRes =
                SolcHandler.buildSolidityCompiler().compile(helloworld4, false, true, ABI, BIN, METADATA);
        Assert.assertTrue(!smRes.isFailed());
        Assert.assertTrue(!eccRes.isFailed());
    }

    @Test
    public void testSelector() throws Exception{
        File projectDir = new File(System.getProperty("user.dir"));
        SolidityCompileExtensions extensions = new SolidityCompileExtensions();
        extensions.setContracts("src/test/resources");
        extensions.setSelector("*");
        extensions.setOnlyAbiBin(true);
        extensions.setOutput("tmp");
        extensions.setSelector("HelloWorldV4");

        CompileHandler compileHandler = new CompileHandler(projectDir, extensions);
        compileHandler.doSolc();
    }
}
