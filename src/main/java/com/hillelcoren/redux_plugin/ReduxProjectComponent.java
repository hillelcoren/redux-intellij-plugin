package com.hillelcoren.redux_plugin;

import com.intellij.openapi.components.ProjectComponent;
import org.jetbrains.annotations.NotNull;

public class ReduxProjectComponent implements ProjectComponent {

    private static final String TEST_PROJECT_COMPONENT_NAME = "TestProjectComponent";

    @Override
    public void projectOpened() {

    }

    @Override
    public void projectClosed() {

    }

    @Override
    public void initComponent() {
        System.out.println("THIS IS A TEST");
    }

    @Override
    public void disposeComponent() {}

    @NotNull
    @Override
    public String getComponentName() {
        return TEST_PROJECT_COMPONENT_NAME;
    }
}