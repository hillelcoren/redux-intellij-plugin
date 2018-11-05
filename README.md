# Redux IntelliJ Plugin

The purpose of this plugin is to try to make it easier to navigate in a Redux app.

Here's a basic overview of how it works:

- When you right-click to show the context menu the plugin checks if the word under the caret is upper case.
- If it is it then checks files in the lib folder with 'reducer' or 'middleware' in their path for matching references.
- Finally, matching files are added as options in the context menu.

Most of the code can be found in [plugin.xml](https://github.com/hillelcoren/redux-intellij-plugin/blob/master/src/main/resources/META-INF/plugin.xml) and [ReduxProjectAction.java](https://github.com/hillelcoren/redux-intellij-plugin/blob/master/src/main/java/com/hillelcoren/redux_plugin/ReduxProjectAction.java).

It's still in an experimental state, feel free to create issues to help figure out how it should be improved.