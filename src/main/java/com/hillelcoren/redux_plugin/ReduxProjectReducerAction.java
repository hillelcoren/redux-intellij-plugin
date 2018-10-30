package com.hillelcoren.redux_plugin;


import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.vfs.VirtualFile;

public class ReduxProjectReducerAction extends ReduxProjectAction {


    @Override
    public void update(AnActionEvent event) {

        VirtualFile file = getFile(event, "reducer");

        event.getPresentation().setEnabledAndVisible(file != null);
    }

    @Override
    public void actionPerformed(AnActionEvent event) {

        handleAction(event, "reducer");
    }

}
