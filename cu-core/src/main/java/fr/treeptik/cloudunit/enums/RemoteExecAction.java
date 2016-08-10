package fr.treeptik.cloudunit.enums;

import java.util.Map;

/**
 * Created by nicolas on 19/04/2016.
 */
public enum RemoteExecAction {

    ADD_USER("Add user for admin console", "/opt/cloudunit/scripts/add-user.sh CU_USER CU_PASSWORD"),
    CHANGE_CU_RIGHTS("Change rights for user CloudUnit", "chown -R cloudunit:cloudunit /opt/cloudunit"),
    CHECK_RUNNING("Check running", "/opt/cloudunit/scripts/check-running.sh"),
    DEPLOY("Deploy application", "/opt/cloudunit/scripts/deploy.sh CU_USER CU_PASSWORD"),
    CHANGE_SERVER_CONFIG("Change Server Configuration", "/opt/cloudunit/scripts/change-server-config.sh MEMORY_VALUE JVM_OPTIONS"),
    CHANGE_JAVA_VERSION("Change Server Configuration", "/opt/cloudunit/scripts/change-java-version.sh MEMORY_VALUE JVM_OPTIONS"),
    MODULE_PRE_CREATION("Module pre creation", "/opt/cloudunit/hooks/module-pre-creation.sh"),
    MODULE_POST_CREATION("Module pre creation", "/opt/cloudunit/hooks/module-post-creation.sh"),
    APPLICATION_PRE_FIRST_DEPLOY("Application pre first deploy", "/opt/cloudunit/hooks/application-pre-first-deploy.sh"),
    APPLICATION_POST_FIRST_DEPLOY("Application post first deploy", "/opt/cloudunit/hooks/application-post-first-deploy.sh"),
    APPLICATION_PRE_START("Application pre start", "/opt/cloudunit/application-pre-start.sh"),
    APPLICATION_POST_START("Application post start", "/opt/cloudunit/hooks/application-post-start.sh"),
    APPLICATION_PRE_STOP("Application pre stop", "/opt/cloudunit/hooks/application-pre-stop.sh"),
    APPLICATION_POST_STOP("Application post stop", "/opt/cloudunit/hooks/application-post-stop.sh"),
    SNAPSHOT_PRE_ACTION("Before Snapshot", "/opt/cloudunit/hooks/snapshot-pre-action.sh"),
    SNAPSHOT_POST_ACTION("After Snapshot", "/opt/cloudunit/hooks/snapshot-post-action.sh"),
    CLONE_PRE_ACTION("Before restoring an application", "/opt/cloudunit/hooks/clone-pre-action.sh"),
    CLONE_POST_ACTION("After restoring an application", "/opt/cloudunit/hooks/clone-post-action.sh"),
    GATHER_CU_ENV("Gather CU env variables", "/opt/cloudunit/scripts/env.sh");

    private final String label;
    private String command;

    RemoteExecAction(String label, String command) {
        this.label = label;
        this.command = command;
    }

    public String getLabel() {
        return label;
    }

    public String getCommand() {
        return command;
    }

    public String getCommand(Map<String, String> kvStore) {
        kvStore.entrySet().stream().forEach(e -> command = command.replaceAll(e.getKey(), e.getValue()));
        return command;
    }

    public String[] getCommandBash() {
        String[] commandBash = new String[2];
        commandBash[0] = "bash";
        commandBash[1] = command;
        return commandBash;
    }

}