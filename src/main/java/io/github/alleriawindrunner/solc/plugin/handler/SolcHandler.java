package io.github.alleriawindrunner.solc.plugin.handler;


import io.github.alleriawindrunner.solc.compiler.SolidityCompiler;

/**
 * @author eleven
 * @date 2023年01月30日 10:43 AM
 * @see
 * @since
 */

public class SolcHandler {

    public static SolidityCompiler buildSolidityCompiler() {
        return SolidityCompiler.getInstance();
    }
}










