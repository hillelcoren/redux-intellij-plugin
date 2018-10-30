# Redux IntelliJ Plugin

The purpose of this plugin is to try to make it easier to navigate in a Redux app.

Here's a basic overview of how it works:

- When you right-click to show the context menu the plugin checks if the word under the caret is upper case.
- If it is it then checks files with 'reducer' or 'middleware' in their path for matching references.
- Finally, matching files are added as options in the context menu.

It's still in an experimental state, feel free to create issues to help figure out how it should be improved.