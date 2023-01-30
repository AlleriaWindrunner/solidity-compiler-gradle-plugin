package io.github.alleriawindrunner.solc.plugin.config;

/**
 * @author eleven
 * @date 2023年01月30日 10:43 AM
 * @see
 * @since
 */
public class SolidityCompileExtensions {

    private String pkg;

    private String output = "src/main";

    private boolean onlyAbiBin = false;

    private String contracts = "src/main/contracts";
    private String selector;
    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public boolean isOnlyAbiBin() {
        return onlyAbiBin;
    }

    public void setOnlyAbiBin(boolean onlyAbiBin) {
        this.onlyAbiBin = onlyAbiBin;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }
}
