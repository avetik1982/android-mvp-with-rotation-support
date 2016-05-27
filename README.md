# android-mvp-with-rotation-support
Android MVP design pattern implementation example with rotation support

This example demonstrates how to handle rotation issues related
to custom dialogs in Android.
Also, shows how to handle UI state changes and react on them in clean way.

What does this example.

Implements following scenario:

User clicks to the button and it shows a progress dialog and starts some task.
After having the result of the task, app dismisses the progress dialog, applies UI changes 
and shows some custom dialog.

What's the goal of this example.

Not to have any crashes or invalid states in UI and in objects.

What covers this example:

- Does not hide the dialog when there are rotations of the screen.
- Does not apply UI changes after async task result when progress 
  dialog is canceled by the user.
- Delays dissmis of progress dialog when async task is finished, but app
  is in background.